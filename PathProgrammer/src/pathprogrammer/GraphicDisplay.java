package pathprogrammer;

import pathprogrammer.Main.tiles;
import javax.swing.*;
import java.awt.*;

public class GraphicDisplay
{
    private JFrame frame;
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
    }
    
    /**
     * edits the display to show the current map
     */
    public void displayMap(tiles[][] map) {
        // TODO
    }
    
    /**
     * helper method to display a singular tile
     */
    private void displayTile(tiles tile, int x, int y) {
        // TODO
    }
}
