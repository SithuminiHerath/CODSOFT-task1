import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner Number = new Scanner(System.in);
        Random ranNumber = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        System.out.println("****** Welcome to the Number Game ******");

        do {
            int targetNumber = ranNumber.nextInt(max - min + 1) + min;
            int attempts = 0;

            System.out.println("\n*** Round " + (roundsPlayed + 1)+" ***");
            System.out.println("Guess the number between " + min + " and " + max);

            while (attempts < maxAttempts) {
                System.out.print("Enter the Number you guess: ");
                int guess = Number.nextInt();
                attempts++;

                if (guess == targetNumber)
                {
                    System.out.println("\nYou guessed the correct number in " + attempts + " attempts.\n \tCongratulations!");
                    totalAttempts += attempts;
                    break;
                }
                else if (guess < targetNumber)
                {
                    System.out.println("Try again,The Number you guessed is too small.");
                }
                else
                {
                    System.out.println("Try again,The Number you guessed is too High.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("\nSorry,You can't try anymore. The correct number was: " + targetNumber);
                totalAttempts += attempts;
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = Number.next().toLowerCase();
            if (playAgain.equals("no")) {
                break;
            }

            roundsPlayed++;

        }
        while (true);

        System.out.println("\nGame Over. Thanks for playing!");
        System.out.println("Total rounds played: " + ++roundsPlayed);
        System.out.println("Total attempts: " + totalAttempts);

        Number.close();
    }
}
