import java.util.Scanner;

public class Sesion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        // Triángulo

        System.out.println("Introduzca un número del 5 al 30");
        System.out.println("Este representará la altura de su triángulo");

        numero = sc.nextInt();

        while (!(numero>5 && numero<30)){
            System.out.println("Introduzca un número correcto: ");
            numero = sc.nextInt();
        }
        final char asterisco = '*';

        for (int k = 1; k <= numero; k++){

            for (int i = 0; i < k; i++){
                System.out.print(asterisco + " ");
            };
            System.out.println();
        }

        // Cuadrado

        System.out.println("Introduzca un número entre 10 y 35");
        System.out.println("Este corresponderá al lado del cuadrado que se va a dibujar");

        numero = sc.nextInt();

        while (numero < 10 || numero > 35){
            System.out.println("Introduzca un número correcto: ");
            numero = sc.nextInt();
        }
        for (int k = 1; k <= numero; k++){
            for (int i = 0; i < numero; i++){
                System.out.print(asterisco + "  ");
            }
            System.out.println();
        }

        // Multiplicación con bucle

        int num1, num2;
        System.out.println("Introduzca dos números entre 0 y 20:");

        num1 = sc.nextInt();

        while (num1 < 0 || num1 > 20){
            System.out.println("Por favor, introduzca un número entre 0 y 20:");
            num1 = sc.nextInt();
        }

        System.out.println("Introduzca otro número entre 0 y 20:");
        num2 = sc.nextInt();

        while (num2 < 0 || num2 > 20){
            System.out.println("Por favor, introduzca un número entre 0 y 20:");
            num2 = sc.nextInt();
        }
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));


        // Tabla de multiplicar

        System.out.println("Introduzca un número del 1 al 10.\nSe mostrará la tabla de multiplicar de dicho número.");
        numero = sc.nextInt();

        while(numero < 1 || numero > 10){
            System.out.println("Introduzca un número del 1 al 10");
            numero = sc.nextInt();
        }
        for (int k = 1; k <= 10; k++){
            System.out.println(numero + " X " + k + " = " + (numero * k));
        }
    }
}
