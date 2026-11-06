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

    private static String mapdata = "something";
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

        // print initial map probably
        while (validateInput()){
            // TODO
            // print map and do other stuff idk
        }
        // check win condition and end the game
        // maybe chain into other levels
    }


    /**
     * takes user input and runs the corresponding command, if valid
     * 
     * @return boolean to determine if the game loop continues or not
     */
    public static boolean validateInput()
    {
        System.out.print("input a command: ");
        String command = input.nextLine();

        command = command.toLowerCase().trim();

        switch (command)
        {
            case "forward":
                commands.enqueue(moves.FORWARD);
                return true;
            case "left":
                commands.enqueue(moves.LEFT);
                return true;
            case "right":
                commands.enqueue(moves.RIGHT);
                return true;
            case "run":
                System.out.println("running all moves:");
                runCommands();
                return false;
            case "quit":
                System.out.println("quitting...");
                System.exit(0);
                return false;
            default:
                System.out.println("command not recognized, try again.");
                return true;
        }
    }


    /**
     * handles logic of running the queue of player commands
     */
    public static void runCommands()
    {

        // TODO
    }
}
