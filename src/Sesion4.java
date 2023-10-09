import java.util.Scanner;

public class Sesion4 {
    public static Scanner sc = new Scanner(System.in);
    private static String green = "\u001B[32m"; // Uso el color verde para que el resultado sea más vistoso
    private static String normal = "\u001B[0m";

    public static char leerCharacter(char c){
        while (Character.isLetterOrDigit(c)){
            System.out.println("Caracter introducido incorrecto. \nInténtelo de nuevo: ");
            c = sc.next().charAt(0);
        }
        return c;
    }
    public static void lineaRecursivo(int num, char caracter){
        if (num == 1){
            System.out.println(caracter + " ");
        }
        else{
            System.out.print(caracter + " ");
            lineaRecursivo(num - 1, caracter);
        }
    }

    public static void trianguloRecursivo(int base, char caracter){
        if (base == 1){
            System.out.println(caracter);
        }
        else{
            trianguloRecursivo(base - 1, caracter);
            lineaRecursivo(base, caracter);
        }
    }
    
    public static int multiplicarRecursivo(int x, int y){
        if (x == 0 || y == 0){
            return 0;
        } else if (y == 1) {
            return x;
        }
        else {
            return x + multiplicarRecursivo(x, y - 1);
        }
    }

    public static void tablaMultiplicar(int x){
        for (int k = 1; k <= 10; k++){
            System.out.print(x + " X " + k + " = ");
            System.out.println(green + multiplicarRecursivo(x, k) + normal);
        }
    }
}
