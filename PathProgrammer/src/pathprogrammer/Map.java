package pathprogrammer;

import pathprogrammer.Main.moves;
import pathprogrammer.Main.tiles;

/**
 * Stores and updates the state of a Path Programmer game board.
 *
 * The map is supplied as rows of characters separated by line breaks (or
 * /). Use the same symbols shown by the display: █ for a
 * wall, ☐ for an empty tile, ✪ for the goal, and 🡡,
 * 🡣, 🡠, or 🡢 for the player's starting position and
 * direction. Whitespace around rows is ignored.
 *
 * @author Group 7
 * @version 10 Nov 2026
 */
public class Map
{
    private final tiles[][] map;
    private final int rows;
    private final int columns;
    private int playerRow;
    private int playerColumn;
    private tiles playerTile;
    private int goalRow;
    private int goalColumn;

    /**
     * Creates a map from a rectangular text grid.
     *
     * @param data textual map with one player and one goal
     * @throws IllegalArgumentException if the map is null, malformed, or
     *         missing its player or goal
     */
    public Map(String data)
    {
        if (data == null || data.trim().isEmpty())
        {
            throw new IllegalArgumentException("Map data must not be empty");
        }

        String[] mapRows = data.trim().split("(?:\\r?\\n|/)");
        rows = mapRows.length;
        columns = mapRows[0].trim().codePointCount(0, mapRows[0].trim().length());
        if (columns == 0)
        {
            throw new IllegalArgumentException("Map rows must not be empty");
        }

        map = new tiles[rows][columns];
        boolean foundPlayer = false;
        boolean foundGoal = false;
        for (int row = 0; row < rows; row++)
        {
            String line = mapRows[row].trim();
            if (line.codePointCount(0, line.length()) != columns)
            {
                throw new IllegalArgumentException(
                    "Map rows must all have the same width");
            }

            int charIndex = 0;
            for (int column = 0; column < columns; column++)
            {
                int symbol = line.codePointAt(charIndex);
                charIndex += Character.charCount(symbol);
                switch (symbol)
                {
                    case 0x2588: // █
                        map[row][column] = tiles.WALL;
                        break;
                    case 0x2610: // ☐
                        map[row][column] = tiles.EMPTY;
                        break;
                    case 0x272A: // ✪
                        if (foundGoal)
                        {
                            throw new IllegalArgumentException(
                                "Map must contain exactly one goal");
                        }
                        foundGoal = true;
                        goalRow = row;
                        goalColumn = column;
                        map[row][column] = tiles.GOAL;
                        break;
                    case 0x1F861: // 🡡
                    case 0x1F863: // 🡣
                    case 0x1F860: // 🡠
                    case 0x1F862: // 🡢
                        if (foundPlayer)
                        {
                            throw new IllegalArgumentException(
                                "Map must contain exactly one player");
                        }
                        foundPlayer = true;
                        playerRow = row;
                        playerColumn = column;
                        playerTile = directionTile(symbol);
                        map[row][column] = playerTile;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Unrecognized map character: "
                                + new String(Character.toChars(symbol)));
                }
            }
        }

        if (!foundPlayer || !foundGoal)
        {
            throw new IllegalArgumentException(
                "Map must contain exactly one player and one goal");
        }
    }


    /**
     * Applies one command. The return value is true when a move is blocked,
     * matching the controller's current use of this method. Turns always
     * succeed and moving forward is blocked by map edges and walls.
     *
     * @param move command to apply
     * @return true if the command was blocked, false if it was applied
     */
    public boolean movePlayer(moves move)
    {
        if (move == null)
        {
            return true;
        }

        if (move == moves.LEFT)
        {
            playerTile = turnLeft(playerTile);
            map[playerRow][playerColumn] = playerTile;
            return false;
        }
        if (move == moves.RIGHT)
        {
            playerTile = turnRight(playerTile);
            map[playerRow][playerColumn] = playerTile;
            return false;
        }

        int nextRow = playerRow;
        int nextColumn = playerColumn;
        switch (playerTile)
        {
            case PLAYER_UP:
                nextRow--;
                break;
            case PLAYER_DOWN:
                nextRow++;
                break;
            case PLAYER_LEFT:
                nextColumn--;
                break;
            case PLAYER_RIGHT:
                nextColumn++;
                break;
            default:
                return true;
        }

        if (nextRow < 0 || nextRow >= rows || nextColumn < 0
            || nextColumn >= columns || map[nextRow][nextColumn] == tiles.WALL)
        {
            return true;
        }

        map[playerRow][playerColumn] = playerRow == goalRow
            && playerColumn == goalColumn ? tiles.GOAL : tiles.EMPTY;
        playerRow = nextRow;
        playerColumn = nextColumn;
        map[playerRow][playerColumn] = playerTile;
        return false;
    }


    /**
     * Checks whether the player is currently on the goal.
     *
     * @return true when the player has reached the goal
     */
    public boolean winCondition()
    {
        return playerRow == goalRow && playerColumn == goalColumn;
    }


    /**
     * Returns a copy of the visible board so callers cannot modify model state.
     *
     * @return a deep copy of the map tile array
     */
    public tiles[][] getMap()
    {
        tiles[][] copy = new tiles[rows][columns];
        for (int row = 0; row < rows; row++)
        {
            System.arraycopy(map[row], 0, copy[row], 0, columns);
        }
        return copy;
    }


    private static tiles directionTile(int symbol)
    {
        switch (symbol)
        {
            case 0x1F861: return tiles.PLAYER_UP;
            case 0x1F863: return tiles.PLAYER_DOWN;
            case 0x1F860: return tiles.PLAYER_LEFT;
            default: return tiles.PLAYER_RIGHT;
        }
    }


    private static tiles turnLeft(tiles direction)
    {
        switch (direction)
        {
            case PLAYER_UP: return tiles.PLAYER_LEFT;
            case PLAYER_LEFT: return tiles.PLAYER_DOWN;
            case PLAYER_DOWN: return tiles.PLAYER_RIGHT;
            default: return tiles.PLAYER_UP;
        }
    }


    private static tiles turnRight(tiles direction)
    {
        switch (direction)
        {
            case PLAYER_UP: return tiles.PLAYER_RIGHT;
            case PLAYER_RIGHT: return tiles.PLAYER_DOWN;
            case PLAYER_DOWN: return tiles.PLAYER_LEFT;
            default: return tiles.PLAYER_UP;
        }
    }
}
