import java.util.*;

public class GuessingGame {
    // Instance variables to store the secret number, user input scanner, and game constants
    private int secretNumber;
    private Scanner scan;
    private static final int MAX_GUESS = 6;
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;

    // Method to start the guessing game
    public void start() {
        String input;
        int guess;
        int winCount = 0;
        int lostCount = 0;
        Random random = new Random();

        // Initialize the scanner for user input
        scan = new Scanner(System.in);

        // Display game instructions
        display();

        // Ask the user if they want to play
        System.out.println("Do you want to play a game (y/n)? ");
        input = scan.next().toLowerCase();
        System.out.println("You responded: " + input);

        // If the user doesn't want to play, exit
        if (!input.equals("y")) {
            System.out.println("You never got to guess");
        } else {
            // While the user wants to play, keep playing rounds
            while (input.equals("y")) {

                int count = 0;

                // Generate a new secret number for each round
                secretNumber = random.nextInt(UPPER_BOUND) + 1;

                // Allow the user to guess the number within a limited number of attempts
                do {
                    guess = validate();
                    count++;

                    // Provide feedback on the user's guess
                    if (guess > secretNumber)
                        System.out.println("Your guess is too high");
                    else if (guess < secretNumber)
                        System.out.println("Your guess is too low");
                } while (guess != secretNumber && count < MAX_GUESS);

                // Display the secret number and outcomes of the round
                System.out.println("The secret number generated = " + secretNumber);
                if (guess == secretNumber) {
                    winCount++;
                    System.out.println("Congratulations! Number of guesses: " + count);
                } else {
                    lostCount++;
                    System.out.println("Sorry. Good luck next time");
                }

                // Ask the user if they want to play again
                System.out.println("Do you want to play again (y/n)? ");
                input = scan.next().toLowerCase();
            }
        }

        // Display the overall results of the game
        System.out.println("Won " + winCount + ", lost " + lostCount);
        System.out.println("Goodbye");
    }

    // Method to validate user input and ensure it is a valid integer within the specified bounds
    private int validate() {
        Scanner keyboard = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println("Enter a number between 0 and 100: ");
            if (keyboard.hasNextInt()) {
                num = keyboard.nextInt();
                if ((num < 0) || (num > 100)) {
                    System.out.println("Error: Enter a number between 0 and 100: ");
                    keyboard.nextLine();
                }
            } else {
                System.out.println("Must be an integer!");
                keyboard.nextLine();
            }
        } while ((num < 0) || (num > 100));

        return num;
    }

    // Method to display game instructions
    private static void display() {
        System.out.println("The number of maximum guesses is " + MAX_GUESS);
        System.out.println("You have to enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND);
    }
}
