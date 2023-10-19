import java.util.Scanner;

public class BuscarElementoArray {
    private static Scanner sc;

    public static void buscarElemento(int[] array, int elemento, int indice, int contador) {
        if (indice < array.length) {
            if (array[indice] == elemento) {
                System.out.println("Se ha encontrado un elemento " + "'" + elemento + "'" + " en la posición " + "[" + indice + "]");
                contador++;
            }
            buscarElemento(array, elemento, indice + 1, contador);
        } else {
            if (contador == 0) {
                System.out.println("No se ha encontrado ningún elemento coincidente en el array.");
            } else
                System.out.println("El total de elementos " + "(" + elemento + ")" + " coincidentes es: " + contador);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {1, 1, 2, 3, 3, 5, 6, 3, 8, 1, 1, 2};
        System.out.println("Introduzca el número que desees encontrar. \nEl programa se seguirá ejecutando hasta que introduzcas '-1'");
        int choice = sc.nextInt();
        while (choice != -1) {
            buscarElemento(array, choice, 0, 0);
            choice = sc.nextInt();
        }
    }
}
