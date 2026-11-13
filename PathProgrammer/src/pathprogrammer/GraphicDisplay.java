package pathprogrammer;

import pathprogrammer.Main.tiles;
import javax.swing.*;
import java.awt.*;

public class GraphicDisplay
{
    private final int SCALE = 25;

    private class DrawComponent
        extends JPanel
    {
        public void clear() {
            Graphics g = frame.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setPaint(Color.GRAY);
            g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        }
        
        public void paint(Graphics g, int x, int y, int w, int h)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.BLACK);
            g2.fillRect(x, y, w, h);
        }
    }

    private JFrame frame;
    private DrawComponent draw;
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

        draw = new DrawComponent();
        frame.add(draw);

        displayMap(map);
    }


    /**
     * edits the display to show the current map
     */
    public void displayMap(tiles[][] map)
    {
        draw.clear();
        
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
        Graphics g = frame.getGraphics();

        int leftBuffer = (frame.getWidth() - width * SCALE) / 2;
        int topBuffer = (frame.getHeight() + 25 - height * SCALE) / 2;
        
        int xPos = leftBuffer + x * SCALE;
        int yPos = topBuffer + y * SCALE;
        int width = SCALE;
        int height = SCALE;

        if (tile == tiles.EMPTY)
        {
            return;
        }
        else if (tile == tiles.GOAL)
        {
            xPos += 4;
            yPos += 4;
            width -= 8;
            height -= 8;
        }
        else if (tile != tiles.WALL) {
            xPos += 2;
            yPos += 2;
            width -= 4;
            height -= 4;
        }

        draw.paint(g, xPos, yPos, width, height);
    }

}
