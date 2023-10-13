import java.util.Scanner;

public class Extraordinaria22 {
    public static Scanner sc;
    public static double potencia(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double joker = potencia(x, n / 2);
            return joker * joker;
        } else {
            double joker = potencia(x, (n - 1) / 2);
            return x * joker * joker;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número: ");
        double choice = sc.nextDouble();
        System.out.println("Introduzca un exponente: ");
        int exp = sc.nextInt();
        double calcularPotencia = potencia(choice, exp);
        System.out.println(choice + " ^ " + exp + " = " + calcularPotencia) ;
    }
}
