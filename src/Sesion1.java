import java.util.Scanner;

public class Sesion1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice; // Primera elección
        int choice2; // Segunda elección
        int compare1; // Tercera elección
        int compare2; // Cuarta elección

        System.out.println("Seleccione un número del 1 al 5 para comenzar el programa: ");

        System.out.println("1. Dibujar un triángulo rectángulo ");
        System.out.println("2. Dibujar un cuadrado: ");
        System.out.println("3. Multiplicar dos números: ");
        System.out.println("4. Escribir una tabla de multiplicar: ");
        System.out.println("5. Finalizar la ejecución");


        choice = sc.nextInt();

        while (!(choice >0 && choice <=5)){
            System.out.println("Por favor, seleccione un número correcto");
            choice = sc.nextInt();
        }
        System.out.println("Ha seleccionado la opción " + choice);

        System.out.println("Ahora escoja un número entre 0 y 100: ");
        choice2 = sc.nextInt();

        while (!(choice2>=0 && choice2 <101)){
            System.out.println("Por favor, seleccione un número correcto");
            choice2 = sc.nextInt();
        }
        System.out.println("Ha seleccionado el número " + choice2);

        System.out.println("Elija dos números enteros. Estos se compararán y se mostrará el mayor de ellos: ");
        System.out.println("Además, se comprobará si el segundo número es múltiplo del primero: ");

        compare1 = sc.nextInt();
        compare2 = sc.nextInt();

        if ((compare1 <= compare2) && (compare2 % compare1 == 0)){
            System.out.println("El número " + compare1 + " es menor o igual que el número " + compare2 + " y este es múltiplo del primero");
        }
        else System.out.println("El número " + compare1 + " no es menor o igual que el número " + compare2 + " o este no es múltiplo del primero");
    }
}
