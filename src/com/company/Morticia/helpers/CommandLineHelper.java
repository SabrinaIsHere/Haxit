package com.company.Morticia.helpers;

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
}
