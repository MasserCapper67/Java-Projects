import java.util.Scanner;

public class Sesion3 {
    private static Scanner sc = new Scanner(System.in);

    public static int menu(int x) {
        System.out.println("Introduzca un número del 1 al 5: \nLas opciones son las siguientes: ");
        System.out.println("1. Dibujar un triángulo rectángulo ");
        System.out.println("2. Dibujar un cuadrado: ");
        System.out.println("3. Multiplicar dos números: ");
        System.out.println("4. Escribir una tabla de multiplicar: ");
        System.out.println("5. Finalizar la ejecución");
        x = sc.nextInt();
        while (x < 1 || x > 5) {
            System.out.println("Introduzca un número válido: ");
            x = sc.nextInt();
        }
        return x;
    }

    public static int leerNumero(int min, int max) {
        int num = sc.nextInt();
        while (num < min || num > max){
            System.out.println("Introduzca un número válido: ");
            num = sc.nextInt();
        }
        return num;
    }

    public static char leerCharacter(char c){
        System.out.println("Introduzca un caracter especial (Ni númerico ni alfabético: ");
        c = sc.next().charAt(0);
        while (!(Character.isAlphabetic(c)) || !(Character.isDigit(c))) {
            System.out.println("Caracter introducido incorrecto. \nInténtelo de nuevo: ");
            c = sc.next().charAt(0);
        }
        return c;
    }

    public static void dibujarTriángulo(int base, char character){
        base = sc.nextInt();
        for (int k = 0; k < base; k++){

            for (int i = 0; i < k; i++){
                System.out.print(character + " ");
            };
            System.out.println(character);
        }
    }

    public static void dibujarCuadrado(int lado, char character){
        lado = sc.nextInt();

        for (int k = 0; k < lado; k++){
            for (int i = 0; i < lado; i++){
                System.out.print(character + "  ");
            }
            System.out.println();
        }
    }




}
