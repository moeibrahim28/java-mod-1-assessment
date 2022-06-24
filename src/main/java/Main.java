import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runValue = true;
        while (runValue) {
            int difficulty = getDifficulties(scanner);
            if (difficulty != 4) {
                int lowerBound = getLowerBound(scanner);
                int upperBound = getUpperBound(scanner);
                int random = generateRandomNumber(scanner, lowerBound, upperBound);
                int userNumber = getUserGuess(scanner, lowerBound, upperBound);
                checkGuess(userNumber, random, difficulty);
            } else {
                runValue = false;
            }
        }

    }

    public static int generateRandomNumber(Scanner scanner, int lowerBound, int upperBound) {
        Random random = new Random();
        int range = upperBound - lowerBound;
        int randomInt = random.nextInt(range);
        randomInt += lowerBound;
        return randomInt;
    }

    public static int getDifficulties(Scanner scanner) {

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
                break;
            case 2:
                System.out.println(difficulties[1]);
                break;
            case 3:
                System.out.println(difficulties[2]);
                break;
            case 4:
                System.out.println("Thanks, Bye!");
                break;
            default:
                System.out.println("You are bad at typing numbers 1 to 4");
                difficultyNumber = getDifficulties(scanner);
                break;
        }

        return difficultyNumber;

    }

    public static int getLowerBound(Scanner scanner) {
        System.out.println("Enter a lower bound:");
        String userInput = scanner.nextLine();
        int input = getInput(userInput);

        return input;

    }

    public static int getUpperBound(Scanner scanner) {
        System.out.println("Enter a upper bound:");
        String userInput = scanner.nextLine();
        int input = getInput(userInput);

        return input;

    }

    public static int getUserGuess(Scanner scanner, int lowerBound, int upperBound) {
        System.out.println("Enter your guess:");
        String userInput = scanner.nextLine();
        int input = getInput(userInput);

        if (input <= upperBound && input >= lowerBound) {
            return input;
        } else if (input > upperBound || input < lowerBound) {
            System.out.println("That is not a valid number. Try again with a number between the bound " + lowerBound
                    + "-" + upperBound + ".");
            input = getUserGuess(scanner, lowerBound, upperBound);
        }
        return input;

    }

    public static void checkGuess(int userGuess, int random, int difficulty) {
        boolean userWins = false;
        switch (difficulty) {
            case 1:
                userWins = userGuess >= random;
                break;
            case 2:
                userWins = userGuess > random;
                break;
            case 3:
                userWins = userGuess == random;
                break;

        }
        if (userWins == true) {
            System.out.println("You win!");
        } else {
            System.out.println("The computer won :( Try again!");
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
