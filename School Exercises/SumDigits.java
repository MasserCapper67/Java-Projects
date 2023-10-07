import java.util.Scanner;

public class SumDigits{
    public static Scanner sc = new Scanner(System.in);
    public static int posInt(int x){
        while (x < 0){
            System.out.println("Introduce a positive number: ");
            x = sc.nextInt();
        }
        if (x < 10){
            return x;
        }
        else{
            return x % 10 + posInt(x / 10);
        }
    }

    public static void main(String[] args) {
        System.out.println("Introduce a positive number: ");
        int choice = sc.nextInt();
        System.out.print("The sum of its digits is ");
        int pos1 = posInt(choice);
        System.out.println(pos1);

        int k = 0;
        int num = 1;
        while (k < 10){
            int pos2 = posInt(num);
            if (pos2 > 10){
                System.out.println("Number: " + num + " || Sum of digits: " + pos2);
                k++;
            }
            num ++;
        }

        System.out.println();

        int minNum = 200;
        while (minNum < 300){
            int pos3 = posInt(minNum);
            if (pos3 == 9){
                System.out.println("Number: " + minNum + " || Sum of digits: " + pos3);
            }
            minNum++;
        }
    }
}