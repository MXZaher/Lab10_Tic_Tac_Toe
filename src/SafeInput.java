import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeInput
{
    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                validInput = true;
            } else {
                System.out.print("Invalid input, please enter an integer.");
                pipe.next();
            }
        } while (!validInput);
        return number;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double number = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                validInput = true;
            } else {
                System.out.print("Invalid input, please enter a double.");
                pipe.next();
            }
        } while (!validInput);
        return number;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int number = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                if (low < number && number < high) {
                    validInput = true;
                } else {
                    System.out.print("Please enter an integer within the valid range.");
                }
            } else {
                System.out.print("Invalid input, please enter an integer.");
                pipe.next();
            }
        } while (!validInput);
        return number;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double number = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                if (low < number && number < high) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a double within the valid range.");
                }
            } else {
                System.out.print("Invalid input, please enter a double.");
                pipe.next();
            }
        } while (!validInput);
        return number;
    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.isEmpty());

        return retString;

    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String ynInput = "";
        boolean answer = false;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            ynInput = pipe.nextLine();
            if (ynInput.equalsIgnoreCase("y")) {
                answer = true;
                validInput = true;
                return answer;
            } else if (ynInput.equalsIgnoreCase("n")) {
                validInput = true;
                return answer;
            }
            System.out.print("Invalid input, please enter yY/nN.");
        } while (!validInput);

        return answer;

    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String regExString = "";
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            String input = pipe.nextLine();
            Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                regExString = input;
                validInput = true;
            }
        } while (!validInput);
        return regExString;
    }
}
