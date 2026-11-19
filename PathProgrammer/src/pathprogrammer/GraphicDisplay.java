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
         * draws a polygon to the panel
         */
        public void draw(Graphics g, int[] x, int[] y, Color color)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(color);
            g2.fillPolygon(x, y, x.length);
        }


        /**
         * draws text to the panel, aligned to the center horizontally
         */
        public void draw(Graphics g, int y, String text, Color color)
        {
            Font font = new Font("Monospaced", Font.BOLD, 40);
            FontMetrics metrics = g.getFontMetrics(font);
            int textWidth = metrics.stringWidth(text);

            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(color);
            g2.setFont(font);
            g2.drawString(text, (frame.getWidth() - textWidth) / 2, y);
        }
    }

    private final int SCALE = 25;

    private JFrame frame;
    private DrawComponent gui;
    private int height;
    private int width;
    private int leftBuffer;
    private int topBuffer;

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

        leftBuffer = (frame.getWidth() - width * SCALE) / 2;
        topBuffer = (frame.getHeight() + 25 - height * SCALE) / 2;

        displayMap(map);
    }


    /**
     * overloaded display function
     */
    public void displayMap(tiles[][] map)
    {
        displayMap(map, "");
    }


    /**
     * edits the display to show the current map
     */
    public void displayMap(tiles[][] map, String message)
    {
        gui.clear();

        gui.draw(
            frame.getGraphics(),
            (int)(frame.getHeight() * 0.2),
            "PATH PROGRAMMER",
            Color.BLACK);
        gui.draw(
            frame.getGraphics(),
            (int)(frame.getHeight() * 0.9),
            message,
            Color.RED);

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

        int xPos = leftBuffer + x * SCALE;
        int yPos = topBuffer + y * SCALE;
        int[] xPoints = null;
        int[] yPoints = null;
        int size = SCALE;
        Color color = Color.BLACK;

        switch (tile)
        {
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
                xPos += 2;
                yPos += 2;
                size -= 4;
                color = Color.BLUE;

                xPoints = new int[] { xPos + size * 1 / 4, xPos + size * 2 / 4,
                    xPos + size * 3 / 4 };
                yPoints = new int[] { yPos + size * 3 / 4, yPos + size * 1 / 4,
                    yPos + size * 3 / 4 };

                gui.draw(g, xPos, yPos, size, color);
                gui.draw(g, xPoints, yPoints, Color.WHITE);
                break;
            case PLAYER_DOWN:
                xPos += 2;
                yPos += 2;
                size -= 4;
                color = Color.BLUE;

                xPoints = new int[] { xPos + size * 1 / 4, xPos + size * 2 / 4,
                    xPos + size * 3 / 4 };
                yPoints = new int[] { yPos + size * 1 / 4, yPos + size * 3 / 4,
                    yPos + size * 1 / 4 };

                gui.draw(g, xPos, yPos, size, color);
                gui.draw(g, xPoints, yPoints, Color.WHITE);
                break;
            case PLAYER_LEFT:
                xPos += 2;
                yPos += 2;
                size -= 4;
                color = Color.BLUE;

                xPoints = new int[] { xPos + size * 3 / 4, xPos + size * 1 / 4,
                    xPos + size * 3 / 4 };
                yPoints = new int[] { yPos + size * 1 / 4, yPos + size * 2 / 4,
                    yPos + size * 3 / 4 };

                gui.draw(g, xPos, yPos, size, color);
                gui.draw(g, xPoints, yPoints, Color.WHITE);
                break;
            case PLAYER_RIGHT:
                xPos += 2;
                yPos += 2;
                size -= 4;
                color = Color.BLUE;

                xPoints = new int[] { xPos + size * 1 / 4, xPos + size * 3 / 4,
                    xPos + size * 1 / 4 };
                yPoints = new int[] { yPos + size * 1 / 4, yPos + size * 2 / 4,
                    yPos + size * 3 / 4 };

                gui.draw(g, xPos, yPos, size, color);
                gui.draw(g, xPoints, yPoints, Color.WHITE);
                break;
        }

    }

}
