package pathprogrammer;

import pathprogrammer.Main.moves;
import pathprogrammer.Main.tiles;

/**
 * Map class to store all data for the game board state
 * 
 * @author Group 7
 * @version 7 Nov 2026
 */
public class Map
{
    private tiles[][] map;
    private tiles currentTile;

    /**
     * creates a new Map object
     * 
     * @param data
     *            String representation of the map
     */
    public Map(String data)
    {
        // TODO
    }


    /**
     * @return false if the command results in an invalid move
     */
    public boolean movePlayer(moves move)
    {
        // TODO
        return false;
    }


    /**
     * @return false if the player / map state is incomplete
     */
    public boolean winCondition()
    {
        // TODO
        return false;
    }


    /**
     * @return the 2D enum array of the map
     */
    public tiles[][] getMap()
    {
        return map;
    }
}
