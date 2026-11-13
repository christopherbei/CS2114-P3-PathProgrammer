package pathprogrammer;

import java.util.Scanner;

/**
 * The msin method and controller for the path programmer game
 * 
 * @author Group 7
 * @version 6 Nov 2026
 */
public class Main
{
    /**
     * enum to represent all possible player moves
     */
    public static enum moves
    {
        FORWARD,
        LEFT,
        RIGHT
    }


    /**
     * enum to represent all tiles and player orientations
     */
    public static enum tiles
    {
        PLAYER_RIGHT,
        PLAYER_UP,
        PLAYER_LEFT,
        PLAYER_DOWN,
        EMPTY,
        WALL,
        GOAL
    }

    private static String mapdata = "■■■■■■■■■■■■\r\n" + //
        "■🡢☐☐■☐☐☐■☐☐■\r\n" + //
        "■■■☐■☐■☐■■☐■\r\n" + //
        "■☐☐☐☐☐■☐☐☐☐■\r\n" + //
        "■☐■■■☐■■■■☐■\r\n" + //
        "■☐☐☐■☐☐■☐☐☐■\r\n" + //
        "■■■☐■■☐☐☐■☐■\r\n" + //
        "■■☐☐☐☐☐■■■■■\r\n" + //
        "■■☐■☐■■☐☐☐☐■\r\n" + //
        "■☐☐☐■☐☐☐■■☐■\r\n" + //
        "■☐■☐☐☐■■■✪☐■\r\n" + //
        "■■■■■■■■■■■■\r\n" + //
        "";
    private static boolean running = false;
    private static boolean gui;

    private static Scanner input;
    private static Map map;
    private static Queue<moves> commands;
    private static GraphicDisplay GUI;

    /**
     * the initial method and main loop for the program to run
     */
    public static void main(String[] args)
    {
        // title and setup
        System.out.println(
            "                                                                                  \r\n"
                + " _____ _____ _____ _____    _____ _____ _____ _____ _____ _____ _____ _____ _____ \r\n"
                + "|  _  |  _  |_   _|  |  |  |  _  | __  |   __| __  |  _  |     |     |   __| __  |\r\n"
                + "|   __|     | | | |     |  |   __|    -|  |  |    -|     | | | | | | |   __|    -|\r\n"
                + "|__|  |__|__| |_| |__|__|  |__|  |__|__|_____|__|__|__|__|_|_|_|_|_|_|_____|__|__|\r\n"
                + "                                                                                  ");

        input = new Scanner(System.in);
        map = new Map(mapdata);
        commands = new Queue<>();

        // takes user input to decide what display format to use
        System.out.print("display format (gui or terminal): ");
        String preference = input.nextLine();
        while (!preference.equals("gui") && !preference.equals("terminal"))
        {
            System.out.print("not recognized, try again: ");
            preference = input.nextLine();
        }

        gui = (preference.equals("gui"));
        if (gui)
        {
            GUI = new GraphicDisplay(map.getMap());
        }
        System.out.println();

        // main game loop
        while (!running)
        {
            System.out.println(
                "use commands 'forward' 'right' and 'left' to set your moves");
            System.out.println(
                "type 'run' to play through your commands and 'quit' to stop the program");

            callDisplay();

            validateInput();
        }

        // end game logic
        runCommands();

        if (map.winCondition() && commands.isEmpty())
        {
            System.out.println("congratulations! you win!");
        }
        else
        {
            System.out.println("you lost... try again?");
        }

        callDisplay();
    }


    /**
     * calls the display methods for the chosen display type
     */
    private static void callDisplay()
    {
        if (gui)
        {
            System.out.println();
            GUI.displayMap(map.getMap());
        }
        else
        {
            Display.displayMap(map.getMap());
        }
        Display.displayMoves(commands.toArray(moves.class));
    }


    /**
     * takes user input and runs the corresponding command, if valid
     */
    private static void validateInput()
    {
        // takes and cleans up user input
        System.out.print("input a command: ");
        String command = input.nextLine();
        command = command.toLowerCase().trim();

        // prints new lines to clean up console
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }

        // checks for valid commands and runs / adds them
        switch (command)
        {
            case "forward":
                commands.enqueue(moves.FORWARD);
                break;
            case "left":
                commands.enqueue(moves.LEFT);
                break;
            case "right":
                commands.enqueue(moves.RIGHT);
                break;
            case "run":
                running = true;
                System.out.println("running all moves:");
                break;
            case "quit":
                System.out.println("quitting...");
                System.exit(0);
            default:
                System.out.println("command not recognized, try again.");
                break;
        }
    }


    /**
     * handles logic of running the queue of player commands
     */
    private static void runCommands()
    {
        int moves = 0;
        int speedup = 0;
        
        while (!commands.isEmpty())
        {
            // display map
            callDisplay();

            // try moving player
            boolean success = map.movePlayer(commands.peek());

            // delays console for one second
            try
            {
                Thread.sleep(1000 - speedup);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // prints new lines to clean up console
            for (int i = 0; i < 50; i++)
            {
                System.out.println();
            }

            // updates queue if player moved, ends loop if the move failed
            if (success)
            {
                commands.dequeue();
            }
            else
            {
                break;
            }
            
            // speeds up the loop as it goes on
            moves++;
            if (moves > 5) {
                speedup = 200;
            }
        }
    }
}
