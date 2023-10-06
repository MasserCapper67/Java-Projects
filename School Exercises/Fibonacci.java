import java.util.Scanner;

public class Fibonacci {
    private static long[] cache;
    public static long fibonacciSequence(int x){

        if (x <= 1){
            return x;
        }
        else{
            if (cache[x] != 0){
                return cache[x];
            }
            long sequence = (fibonacciSequence(x - 1) + fibonacciSequence(x - 2));
            cache[x] = sequence;
            return sequence;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce a number: \nThe program will show up the fibonacci sequence up to its number");
        int x = sc.nextInt();
        cache = new long[x + 1];
        System.out.print("Fibonacci sequence" + " (" + x + "): ");
        for (int k = 0; k <= x; k++){
            System.out.print(fibonacciSequence(k) + " ");
        }
    }
}