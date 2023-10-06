import java.util.Scanner;
public class FactorialSum {
    public static Scanner sc = new Scanner(System.in);
    public static long factorialFunction(long x){
        if (x > 0 && x <= 2){
            return x;
        }
        else{
            x = x * factorialFunction(x- 1);
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println("Introduce 2 numbers. \nThe result will be the sum of their factorials.");
        long num1 = sc.nextLong();
        long num2 = sc.nextLong();
        long firstFactorial = factorialFunction(num1);
        long secondFactorial = factorialFunction(num2);
        long result = firstFactorial + secondFactorial;
        System.out.println(num1 + "!" + " + " +  num2 + "!" + " = " + result);
    }
}
