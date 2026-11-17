package pathprogrammer;

import pathprogrammer.Main.tiles;
import javax.swing.*;
import java.awt.*;

public class GraphicDisplay
{

    private class DrawComponent
        extends JPanel
    {
        public void clear()
        {
            Graphics g = frame.getGraphics();
            Graphics2D g2 = (Graphics2D)g;

            g2.setPaint(Color.GRAY);
            g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        }


        public void draw(Graphics g, int x, int y, int w, int h, Color color)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(color);
            g2.fillRect(x, y, w, h);
        }
    }

    private final int SCALE = 25;

    private JFrame frame;
    private DrawComponent gui;
    private int height;
    private int width;

    /**
     * initializes the gui
     */
    public GraphicDisplay(tiles[][] map)
    {
        height = map.length;
        width = map[0].length;

        frame = new JFrame("PathProgrammer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

        gui = new DrawComponent();
        frame.add(gui);

        displayMap(map);
    }


    /**
     * edits the display to show the current map
     */
    public void displayMap(tiles[][] map)
    {
        gui.clear();

        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                displayTile(map[y][x], x, y);
            }
        }
    }


    /**
     * helper method to display a singular tile
     */
    private void displayTile(tiles tile, int x, int y)
    {
        if (tile == tiles.EMPTY)
        {
            return;
        }

        Graphics g = frame.getGraphics();

        int leftBuffer = (frame.getWidth() - width * SCALE) / 2;
        int topBuffer = (frame.getHeight() + 25 - height * SCALE) / 2;

        int xPos = leftBuffer + x * SCALE;
        int yPos = topBuffer + y * SCALE;
        int size = SCALE;
        Color color = Color.BLACK;

        if (tile == tiles.GOAL) // altered values for goal tile
        {
            xPos += 4;
            yPos += 4;
            size -= 8;
            color = Color.YELLOW;
        }
        else if (tile != tiles.WALL) // altered values for player tile
        {
            xPos += 2;
            yPos += 2;
            size -= 4;
            color = Color.BLUE;

            switch (tile)
            { // player direction pointer TODO (make fit better in walls)
                case PLAYER_UP:
                    gui.draw(
                        g,
                        xPos + size / 4,
                        yPos - size / 2,
                        size / 2,
                        size / 2,
                        color);
                    break;
                case PLAYER_DOWN:
                    gui.draw(
                        g,
                        xPos + size / 4,
                        yPos + size,
                        size / 2,
                        size / 2,
                        color);
                    break;
                case PLAYER_LEFT:
                    gui.draw(
                        g,
                        xPos - size / 2,
                        yPos + size / 4,
                        size / 2,
                        size / 2,
                        color);
                    break;
                case PLAYER_RIGHT:
                    gui.draw(
                        g,
                        xPos + size,
                        yPos + size / 4,
                        size / 2,
                        size / 2,
                        color);
            }
        }

        gui.draw(g, xPos, yPos, size, size, color);
    }

}
