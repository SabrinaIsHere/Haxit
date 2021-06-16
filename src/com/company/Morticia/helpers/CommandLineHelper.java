package com.company.Morticia.helpers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class automates some processes to do with the command line
 *
 * @author Morticia
 * @version 1.0
 * @since 6/13/21
 */
public class CommandLineHelper {
    /**
     * This method is used to clear the output of the systems terminal
     */
    public static void clearCommandLine() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    /**
     * This method guarantees a valid integer input from the player between the specified minimum and maximum
     *
     * @param print This parameter will be printed before getting input, used to specify what the program is asking, i.e. "Iterations: "
     * @param min This is the minimum value the player can input
     * @param max This is the maximum value a player can input
     * @return int This is the input gather from the player
     */
    public static int getInt(String print, int min, int max) {
        int input;
        Scanner sc = new Scanner(System.in);
        if (print == null || print.equals("")) {
            while (true) {
                try {
                    input = Integer.parseInt(sc.nextLine());
                    if (input >= min && input <= max) {
                        break;
                    }
                } catch (Exception ignored) {

                }
            }
        } else {
            while (true) {
                try {
                    System.out.print(print);
                    input = Integer.parseInt(sc.nextLine());
                    if (input >= min && input <= max) {
                        break;
                    }
                } catch (Exception ignored) {

                }
            }
        }
        return input;
    }

    /**
     * This method gets a large amount of text from the player, usually text which is expected to be multiline
     *
     * @return ArrayList List of the text gotten from the user. Every element is an individual line
     */
    public static ArrayList<String> fetchLongInput() {
        ArrayList<String> buffer = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            input = sc.nextLine();
            if (input.equals("\\exit\\")) {
                break;
            } else if (input.equals("\\remove line\\")) {
                int lineNumber = getInt("Line to Remove: ", 1, buffer.size());
                buffer.remove(lineNumber - 1);
                System.out.println("\\Line Removed\\");
            } else if (input.equals("\\replace line\\")) {
                int lineNumber = getInt("Line to Replace: ", 1, buffer.size());
                buffer.set(lineNumber - 1, sc.nextLine());
            } else if (input.equals("\\update\\")) {
                clearCommandLine();
                for (String i : buffer) {
                    System.out.println(i);
                }
            } else {
                buffer.add(input);
            }
        }

        return buffer;
    }

    /**
     * This method gets a large amount of text from the player, usually text which is expected to be multiline
     *
     * @param print Array of Strings to be printed before getting input
     * @return ArrayList List of the text gotten from the user. Every element is an individual line
     */
    public static ArrayList<String> fetchLongInput(ArrayList<String> print) {
        for (String i : print) {
            System.out.println(i);
        }

        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            input = sc.nextLine();
            if (input.equals("\\exit\\")) {
                break;
            } else if (input.equals("\\remove line\\")) {
                int lineNumber = getInt("Line to Remove: ", 1, print.size());
                print.remove(lineNumber - 1);
                System.out.println("\\Line Removed\\");
            } else if (input.equals("\\replace line\\")) {
                int lineNumber = getInt("Line to Replace: ", 1, print.size());
                print.set(lineNumber - 1, sc.nextLine());
            } else if (input.equals("\\update\\")) {
                clearCommandLine();
                for (String i : print) {
                    System.out.println(i);
                }
            } else {
                print.add(input);
            }
        }

        return print;
    }
}
