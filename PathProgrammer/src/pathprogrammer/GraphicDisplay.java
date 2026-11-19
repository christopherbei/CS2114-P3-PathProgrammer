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


        /**
         * draws a square to the panel
         */
        public void draw(Graphics g, int x, int y, int size, Color color)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(color);
            g2.fillRect(x, y, size, size);
        }


        /**
         * draws a triangle to the panel
         */
        public void draw(Graphics g, int[] x, int[] y, Color color)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(color);
            g2.fillPolygon(x, y, x.length);
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

        switch(tile) {
            case WALL:
                gui.draw(g, xPos, yPos, size, color);
                break;
            case GOAL:
                xPos += 4;
                yPos += 4;
                size -= 8;
                color = Color.YELLOW;
    
                gui.draw(g, xPos, yPos, size, color);
                break;
            case KEY:
                xPos += 4;
                yPos += 4;
                size -= 8;
                color = Color.GREEN;
    
                gui.draw(g, xPos, yPos, size, color);
                break;
            case DOOR:
                color = Color.GREEN;
    
                gui.draw(g, xPos, yPos, size, color);
                break;
            case PLAYER_UP:
            case PLAYER_RIGHT:
            case PLAYER_DOWN:
            case PLAYER_LEFT:
                xPos += 2;
                yPos += 2;
                size -= 4;
                color = Color.BLUE;
    
                int[] xPoints = null;
                int[] yPoints = null;
                switch (tile)
                { // player direction pointer
                    case PLAYER_UP:
                        xPoints = new int[] { xPos + size * 1 / 4,
                            xPos + size * 2 / 4, xPos + size * 3 / 4 };
                        yPoints = new int[] { yPos + size * 3 / 4,
                            yPos + size * 1 / 4, yPos + size * 3 / 4 };
                        break;
                    case PLAYER_DOWN:
                        xPoints = new int[] { xPos + size * 1 / 4,
                            xPos + size * 2 / 4, xPos + size * 3 / 4 };
                        yPoints = new int[] { yPos + size * 1 / 4,
                            yPos + size * 3 / 4, yPos + size * 1 / 4 };
                        break;
                    case PLAYER_LEFT:
                        xPoints = new int[] { xPos + size * 3 / 4,
                            xPos + size * 1 / 4, xPos + size * 3 / 4 };
                        yPoints = new int[] { yPos + size * 1 / 4,
                            yPos + size * 2 / 4, yPos + size * 3 / 4 };
                        break;
                    case PLAYER_RIGHT:
                        xPoints = new int[] { xPos + size * 1 / 4,
                            xPos + size * 3 / 4, xPos + size * 1 / 4 };
                        yPoints = new int[] { yPos + size * 1 / 4,
                            yPos + size * 2 / 4, yPos + size * 3 / 4 };
                        break;
                }
    
                gui.draw(g, xPos, yPos, size, color);
                gui.draw(g, xPoints, yPoints, Color.CYAN);
                break;
        }

    }

}
