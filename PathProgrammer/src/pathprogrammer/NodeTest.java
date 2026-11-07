package pathprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Node class for all expected behaviors
 * 
 * @author Chris
 * @version 7 Nov 2026
 */
class NodeTest
{
    private Node<String> node1;
    private Node<String> node2;

    /**
     * sets up node objects for testing
     */
    @BeforeEach
    void setUp()
    {
        node2 = new Node<String>("green");
        node1 = new Node<String>("red", node2);
    }


    /**
     * tests main behaviors for the node class
     */
    @Test
    void testNode()
    {
        assertEquals("red", node1.getData());
        assertEquals("green", node2.getData());

        assertEquals(node2, node1.getNext());
        assertNull(node2.getNext());
        
        node2.setNext(node1);
        node1.setNext(null);
        
        assertEquals(node1, node2.getNext());
        assertNull(node1.getNext());
    }

}
