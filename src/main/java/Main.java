import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            int random = generateRandomNumber();
            int difficulty = getDifficulties();
            int userNumber = getUserGuess();
            checkGuess(userNumber, random, difficulty);
        }

    }

    public static int generateRandomNumber() {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        return randomInt;
    }

    public static int getDifficulties() {
        Scanner scanner = new Scanner(System.in);

        String[] difficulties = new String[3];
        String difficultyString;
        int difficultyNumber;

        difficulties[0] = "1. Guess a number - program will tell you if it was higher or equal (you win) or lower (computer wins) than the program's number.";
        difficulties[1] = "2. Guess a number - program will tell you if it was strictly higher (you win) or lower or equal (computer wins) than the program's number.";
        difficulties[2] = "3. Guess a number - program will tell you if it was equal (you win) or not (you lose) to the program's number.";

        System.out.println(
                "Random Number Guessing Game! Please choose a difficulty by entering a number choice from below to start:");
        System.out.println("1. Easy\n2. Medium\n3. Hard\n4. Exit Game");

        difficultyString = scanner.nextLine();
        difficultyNumber = getInput(difficultyString);

        switch (difficultyNumber) {
            case 1:
                System.out.println(difficulties[0]);
                ;
                break;
            case 2:
                System.out.println(difficulties[1]);
                break;
            case 3:
                System.out.println(difficulties[2]);
                break;
            case 4:
                System.out.println("Thanks, Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("You are bad at typing numbers 1 to 4");
                difficultyNumber = getDifficulties();
                break;
        }

        return difficultyNumber;

    }

    public static int getUserGuess() {
        System.out.println("Enter your guess:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int input = getInput(userInput);

        if (input <= 10 && input >= 0) {
            return input;
        } else if (input > 10) {
            System.out.println("Your guess is outside the bound 0-10. Try again.");
            input = getUserGuess();
        } else {
            System.out.println("That is not a number. Try again.");
            input = getUserGuess();
        }

        return input;

    }

    public static void checkGuess(int userGuess, int random, int difficulty) {
        if (difficulty == 1) {
            if (userGuess >= random) {
                System.out.println("You win!");
            } else {
                System.out.println("The computer won :( Try again!");
            }
        } else if (difficulty == 2) {
            if (userGuess > random) {

            } else {
                System.out.println("The computer won :( Try again!");
            }
        } else if (difficulty == 3) {
            if (userGuess == random) {
                System.out.println("You win!");
            } else {
                System.out.println("The computer won :( Try again!");
            }
        }
    }

    private static int getInput(String sampleString) {
        try {
            return Integer.parseInt(sampleString);
        } catch (Exception e) {
            return -1;
        }
    }
}
