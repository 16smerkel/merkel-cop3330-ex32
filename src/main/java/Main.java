import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ending = ("y");
        while(ending.equals("y")) {
            int goodToGo = 1;
            int guessCount = 0;
            int theAns = 0;
            Random rand = new Random();
            System.out.println("Let's play Guess the Number.\n" +
                    "Pick a difficulty level (1, 2, or 3): ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                theAns = rand.nextInt(10);
            } else if (choice == 2) {
                theAns = rand.nextInt(100);
            } else if (choice == 3) {
                theAns = rand.nextInt(1000);
            }
            System.out.println("I have my number. What's your guess?");
            String g3ess = scanner.nextLine();
            String guess = scanner.nextLine();
            for (char c : guess.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    System.out.println("Please only use numbers.");
                    goodToGo = 1;
                    guessCount++;
                    break;
                }
                goodToGo = 0;
            }
            if (goodToGo != 1) {
                int guessAns = Integer.parseInt(guess);
                if (theAns > guessAns) {
                    System.out.println("Too low.");
                    guessCount++;
                } else if (theAns < guessAns) {
                    System.out.println("Too high.");
                    guessCount++;
                } else {
                    System.out.println("You got it in " + guessCount + " guesses!");
                }
            }
            while (goodToGo != 2) {
                System.out.println("Guess again: ");
                guess = scanner.nextLine();
                for (char c : guess.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        System.out.println("Please only use numbers.");
                        goodToGo = 1;
                        guessCount++;
                        break;
                    }
                    goodToGo = 0;
                }
                if (goodToGo != 1) {
                    int guessAns = Integer.parseInt(guess);
                    if (theAns > guessAns) {
                        System.out.println("Too low.");
                        guessCount++;
                    } else if (theAns < guessAns) {
                        System.out.println("Too high.");
                        guessCount++;
                    } else {
                        System.out.println("You got it in " + guessCount + " guesses!");
                        goodToGo = 2;
                    }
                }
            }
            System.out.println("Play again? Yes(y) or No(n)");
            ending = scanner.nextLine();
        }
        System.out.println("Goodbye!");
    }
}