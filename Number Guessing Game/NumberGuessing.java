import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());
        int trials = 5;
        int i, guess;
        System.out.println(
                "A number from 1 to 100 will be chosen. \nGuess the number within 5 trials");
        for (i = 0; i < trials; i++) {
            System.out.println("Guess the number: ");
            guess = sc.nextInt();

            if (number == guess) {
                System.out.println("Congrats mate! \nYou did it!");
                break;
            }

            else if (number > guess) {
                System.out.println("The number is greater than " +  guess);
            }
            else{
                System.out.println("The number is lower than " + guess);
            }

        }
        if (i == trials) {
            System.out.println(
                    "You lost! \nThe number was " + number);

        }
    }
}

