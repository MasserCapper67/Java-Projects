import java.util.Scanner;

public class Sesion4 {
    public static Scanner sc = new Scanner(System.in);

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


    public static void main(String[] args) {
        System.out.println("Introduzca un número: ");
        int chNum = sc.nextInt();
        System.out.println("Introduzca un carácter: ");
        char chChar = sc.next().charAt(0);
        chChar = leerCharacter(chChar);
        lineaRecursivo(chNum, chChar);

        trianguloRecursivo(5, '*');
    }
}
