import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("The point is set to: " + point);
                boolean tryingForPoint = true;

                while (tryingForPoint) {
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win.");
                        tryingForPoint = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7! You lose.");
                        tryingForPoint = false;
                    } else {
                        System.out.println("Still trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            char response = input.next().toLowerCase().charAt(0);
            if (response != 'y') {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
    }
}

