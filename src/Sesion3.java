import java.util.Scanner;

public class Sesion3 {
    private static Scanner sc = new Scanner(System.in);
    private static String green = "\u001B[32m"; // Uso el color verde para que el resultado sea más vistoso
    private static String normal = "\u001B[0m";

    public static int menu() {
        System.out.println("Introduzca un número del 1 al 5: \nLas opciones son las siguientes: ");
        System.out.println("1. Dibujar un triángulo rectángulo ");
        System.out.println("2. Dibujar un cuadrado: ");
        System.out.println("3. Multiplicar dos números: ");
        System.out.println("4. Escribir una tabla de multiplicar: ");
        System.out.println("5. Finalizar la ejecución");
        int x = sc.nextInt();
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

    public static void dibujarTriangulo(int base, char character){
        System.out.println("Introduzca un número del 5 al 30: \nEl número representará la base de su triángulo.");
        base = sc.nextInt();
        while(base < 5 || base > 30){
            System.out.println("Introduzca un número del 1 al 30: ");
            base = sc.nextInt();
        }
        for (int k = 0; k < base; k++){

            for (int i = 0; i < k; i++){
                System.out.print(character + " ");
            };
            System.out.println(character);
        }
    }

    public static void dibujarCuadrado(int lado, char character){
        System.out.println("Introduzca un número entre 10 y 35. \nEl número representará el lado de su cuadrado: ");
        lado = sc.nextInt();
        while(lado < 10 || lado > 35){
            System.out.println("Introduzca un número del 10 al 35: ");
            lado = sc.nextInt();
        }

        for (int k = 0; k < lado; k++){
            for (int i = 0; i < lado; i++){
                System.out.print(character + "  ");
            }
            System.out.println();
        }
    }

    public static int multiplicarIterativo() {
        System.out.println("Introduzca dos números enteros positivos: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        while (num1 < 0 || num2 < 0) {
            System.out.println("Introduzca números correctos");
            num1 = sc.nextInt();
            num2 = sc.nextInt();
        }
        System.out.print(num1 + " X " + num2 + " = ");
        return num1 * num2;
    }


    public static void tablaMultiplicar(){
        System.out.println("Introduzca un número entero. \nSe mostrará su tabla de multiplicar: ");
        int num = sc.nextInt();

        for (int j = 1; j <= 10; j++){
            System.out.println(num + " X " + j + " = " + green + num * j + normal);
        }
    }

    public static void main(String[] args) {
        boolean continuar = true; // Bucle que ejecutará el menú indefinidamente
        while (continuar) {
            int opcion = menu();

            switch (opcion) {
                case 1:
                    dibujarTriangulo(0, '*');
                    break;
                case 2:
                    dibujarCuadrado(0, '*');
                    break;
                case 3:
                    int resultado = multiplicarIterativo();
                    System.out.println(green + resultado + normal);
                    break;
                case 4:
                    tablaMultiplicar();
                    break;
                case 5:
                    continuar = false;
            }
        }
    }
}
