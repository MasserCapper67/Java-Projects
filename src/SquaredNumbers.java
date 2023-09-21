import java.util.Scanner;

public class SquaredNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, joker;
        System.out.println("Type a positive number: ");
        num = sc.nextInt();
        joker = num;

        if (num != -1){
            num = num * num;
            System.out.println(joker + " squared = " + num);
        }
        else System.out.println("Introduced number is not correct");
    }
}