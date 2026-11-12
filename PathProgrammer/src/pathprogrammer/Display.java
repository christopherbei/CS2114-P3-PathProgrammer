package pathprogrammer;

import pathprogrammer.Main.moves;
import pathprogrammer.Main.tiles;

/**
 * Static displayer class to print map and move enums to the console
 * 
 * @author Group 7
 * @version 10 Nov 2026
 */
public class Display
{
    /**
     * prints the given map data to the console
     * 
     * @param map
     *            2D array map data
     */
    public static void displayMap(tiles[][] map)
    {
        if (map == null) {
            return;
        }

        System.out.println("--- MAP ---");
        for (int i = 0; i < map.length; i++) {
            StringBuilder display = new StringBuilder();
            for (int j = 0; j < map[i].length; j++) {
                tiles tile = map[i][j];
                
                if (tile == tiles.PLAYER_UP) {
                    display.append("🡡 ");
                }
                else if (tile == tiles.PLAYER_DOWN) {
                    display.append("🡣 ");
                }
                else if (tile == tiles.PLAYER_RIGHT) {
                    display.append("🡢 ");
                }
                else if (tile == tiles.PLAYER_LEFT) {
                    display.append("🡠 ");
                }
                else if (tile == tiles.EMPTY) {
                    display.append("☐ ");
                }
                else if (tile == tiles.WALL) {
                    display.append("⏹ ");
                }
                else if (tile == tiles.GOAL) {
                    display.append("✪ ");
                }
                else {
                    display.append("? ");
                }
            }
            System.out.println(display.toString().trim());
        }
        System.out.println("-----------");
    }


    /**
     * prints the given command list data to the console
     * 
     * @param commands
     *            command list
     */
    public static void displayMoves(moves[] commands)
    {
        System.out.print("Queued Moves: [ ");
        if (commands != null)
        {
            for (int i = 0; i < commands.length; i++)
            {
                System.out.print(commands[i] + " ");
            }
        }
        System.out.println("]");
    }
}
