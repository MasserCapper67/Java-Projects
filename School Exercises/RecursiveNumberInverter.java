import java.util.Scanner;

public class RecursiveNumberInverter {
    public static Scanner sc = new Scanner(System.in);

    public static int checkNumber(int x){
        while(x > 9999 || x < 0){
            System.out.println("Introduce a correct number: ");
            x = sc.nextInt();
        }
        return x;
    }
    public static int result = 0;
    public static int numberReverse(int x){
        if (x == 0){
            return x;
        }
        else{
            int remainder = (x % 10);
            int quotient = (x / 10);

            result = (result * 10) + remainder;
            numberReverse(quotient);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("Introduce a number under 4 digits: ");
        int choice = sc.nextInt();
        int checker = checkNumber(choice);
        int inverted = numberReverse(checker);
        System.out.println(inverted);
    }
}
