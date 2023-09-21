import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int joker =0;
        System.out.println("Introduce a number: ");

        num = sc.nextInt();

        if (num >=0) {
            while(num !=0) {
                num = num/10;
                joker ++;
            }
            System.out.println("Set number has " +joker+ "  digits");

        }
        else System.out.println("Please type a number higher than 0");
    }
}