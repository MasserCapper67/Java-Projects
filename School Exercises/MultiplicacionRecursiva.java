import java.util.Scanner;

public class MultiplicacionRecursiva {
    public static Scanner sc;
    public static int leerNumero(Scanner sc){
        int num = sc.nextInt();
        while (num < 0){
            System.out.println("Introduzca un número entero positivo: ");
            num = sc.nextInt();
        }
        return num;
    }

    public static int multiplicarRecursivo(int x, int y){
        if (y == 0){
            return 0;
        }
        if (y == 1){
            return x;
        }
        else{
            return x + multiplicarRecursivo(x, y- 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número entero positivo: \nSe mostrará la tabla de multiplicar de dicho número.");
        int choice = leerNumero(sc);
        for (int k = 0; k <= 10; k++){
            int multiplicacion = multiplicarRecursivo(choice, k);
            System.out.println(choice + " X " + k + " = " + multiplicacion);
        }
    }
}
