package pathprogrammer;

import java.util.Scanner;

/**
 * The msin method and controller for the path programmer game
 * 
 * @author Group 7
 * @version 5 Nov 2026
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
        FLOOR,
        WALL,
        FINISH
    }

    private static String mapdata = "something";
    private static boolean running = false;

    private static Scanner input;
    private static Map map;
    private static Queue<moves> commands;

    /**
     * the initial method and main loop for the program to run
     */
    public static void main(String[] args)
    {
        System.out.println("PATH PROGRAMMER");
        System.out.println(
            "use commands 'forward' 'right' and 'left' to set your moves");
        System.out.println(
            "type 'run' to play through your commands and 'quit' to stop the program");
        System.out.println();

        input = new Scanner(System.in);
        map = new Map(mapdata);
        commands = new Queue<>();

        while (!running)
        {
            Display.displayMap(map.getMap());
            Display.displayMoves(commands.toArray(moves.class));

            validateInput();
        }

        runCommands();

        if (map.winCondition())
        {
            System.out.println("congratulations! you win!");
        }
        else
        {
            System.out.println("you lost, try again.");
        }

        Display.displayMap(map.getMap());
        Display.displayMoves(commands.toArray(moves.class));
    }


    /**
     * takes user input and runs the corresponding command, if valid
     */
    public static void validateInput()
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
                System.out.println("command added.");
                break;
            case "left":
                commands.enqueue(moves.LEFT);
                System.out.println("command added.");
                break;
            case "right":
                commands.enqueue(moves.RIGHT);
                System.out.println("command added.");
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
    public static void runCommands()
    {
        while (!commands.isEmpty())
        {
            Display.displayMap(map.getMap());
            Display.displayMoves(commands.toArray(moves.class));

            boolean failed = map.movePlayer(commands.dequeue());

            if (failed)
            {
                break;
            }

            // delays console for one second
            try
            {
                Thread.sleep(1000);
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
        }
    }
}
