package pathprogrammer;

import pathprogrammer.Main.tiles;
import javax.swing.*;
import java.awt.*;

public class GraphicDisplay
{
    private class DrawComponent
        extends JComponent
    {
        public void paintComponent(Graphics g, int x, int y, int w, int h)
        {
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.BLACK);
            g2.drawRect(x, y, w, h);
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
        // TODO clear stuff if needed
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
        
        if (tile == tiles.WALL)
        {
            draw.paintComponent(g, x, y, 1, 1);
        }
        else
        {
            // TODO
        }
    }

}
