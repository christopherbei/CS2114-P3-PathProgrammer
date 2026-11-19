package pathprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Map class for all expected behaviors, normal movement,
 * key and door mechanics and bad-input cases
 * 
 * @author Tyler
 * @version 19 Nov 2026
 */
class MapTest {
    private Map map;
    private final String validMapData = 
        "■■■\r\n" +
        "■🡢✪\r\n" +
        "■■■";

    private final String keyDoorMapData =
        "■■■■■\r\n" +
        "■🡢🔑🚪✪\r\n" +
        "■■■■■";

    /**
     * sets up map for each test
     */
    @BeforeEach
    void setUp() {
        map = new Map(validMapData);
    }

    /**
     * tests normal map construction and initial win condition
     */
    @Test
    void testMapConstruction() {
        assertNotNull(map.getMap());
        assertFalse(map.winCondition());
    }

    /**
     * tests player turning and moving forward successfully
     */
    @Test
    void testNormalMovement() {
        assertTrue(map.movePlayer(Main.moves.FORWARD));
        assertTrue(map.winCondition());
    }

    /**
     * tests player turning left and right
     */
    @Test
    void testTurning() {
        assertTrue(map.movePlayer(Main.moves.LEFT));
        assertTrue(map.movePlayer(Main.moves.RIGHT));
    }

    /**
     * tests wall collisions and null moves returning false
     */
    @Test
    void testBlockedMovements() {
        map.movePlayer(Main.moves.LEFT);
        assertFalse(map.movePlayer(Main.moves.FORWARD));
        assertFalse(map.movePlayer(null));
    }

    /**
     * tests key collection and door unlocking mechanics
     */
    @Test
    void testKeyAndDoorMechanics() {
        Map interactiveMap = new Map(keyDoorMapData);

        assertTrue(interactiveMap.movePlayer(Main.moves.FORWARD));
        
        assertTrue(interactiveMap.movePlayer(Main.moves.FORWARD));

        assertTrue(interactiveMap.movePlayer(Main.moves.FORWARD));
        assertTrue(interactiveMap.winCondition());
    }

    /**
     * tests bad input cases for map constructor throwing exceptions
     */
    @Test
    void testMapExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Map(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Map("   ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Map("■■\n■");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Map("■■■\n■☐✪\n■■■");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Map("■■■\n■🡢☐\n■■■");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Map("■■■\n■🡢X\n■■■");
        });
    }
}