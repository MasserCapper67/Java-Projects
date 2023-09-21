import java.util.Scanner;

public class NumGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int k = 0;   //Number of tries

        int min = 1;
        int max = 25;

        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 1;

        System.out.println(
                "This is a number guessing game. " +
                        "Please introduce a number " +
                        "between 1-25: "
        );
        num = sc.nextInt();
        k++;

        if (num > 0 && num <= 25) {

            while (num != random) {
                k++;
                if (num < random) {
                    System.out.println("The number you are looking for is higher");
                } else System.out.println("The number you are looking for is lower");
                num = sc.nextInt();
            }
            System.out.println("Congratulations! You guessed the number " + "(" + random + ")");
            System.out.println("You did it in " + k + " attempts");
        }
        else System.out.println("Your number is not valid");
    }
}