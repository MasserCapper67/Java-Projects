import java.util.Scanner;

public class Parcial22Ej4 {
    public static Scanner sc;
    public static int leerNumero(Scanner sc){
        int x = sc.nextInt();
        while (x < 0){
            System.out.println("Introduzca un número correcto: ");
            x = sc.nextInt();
        }
        return x;
    }

    public static int multiplicarRecursivo(int x, int y){
        if (y == 0){
            return 0;
        }
        if (y == 1){
            return x;
        }
        else{
            return x + x * (y - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el primer número: ");
        int choice1 = leerNumero(sc);
        System.out.println("Introduzca el segundo número: ");
        int choice2 = leerNumero(sc);
        int resultado = multiplicarRecursivo(choice1, choice2);
        System.out.println(choice1 + " X " + choice2 + " = " + resultado);
    }
}
