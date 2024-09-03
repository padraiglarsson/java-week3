public class PlayGame {
    // Main method, serves as the entry point of the program
    public static void main(String[] args) {
        // Welcome message to the guessing game
        System.out.println("Welcome to the Guessing Game! ");

        // Create an instance of the GuessingGame class
        GuessingGame hiLo = new GuessingGame();

        // Start the guessing game
        hiLo.start();
    }
}

