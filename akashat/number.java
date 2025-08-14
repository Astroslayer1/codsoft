import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Generate random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1; 
        int guess = -1; // initialize with a value not equal to target

        System.out.println("🎯 Guess the number between 1 and 100!");

        // Step 2 & 3: Keep looping until the guess is correct
        while (guess != targetNumber) {
            System.out.print("Enter your guess: ");

            // Ensure user enters a number
            if (!scanner.hasNextInt()) {
                System.out.println("⚠ Please enter a valid number!");
                scanner.next(); // clear invalid input
                continue;
            }

            guess = scanner.nextInt();

            if (guess == targetNumber) {
                System.out.println("✅ Correct! The number was " + targetNumber);
            } else if (guess > targetNumber) {
                System.out.println("📉 Too high! Try again.");
            } else {
                System.out.println("📈 Too low! Try again.");
            }
        }

        scanner.close();
    }
}
