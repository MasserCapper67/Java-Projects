import java.util.Scanner;

public class SumaPromedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número que quieras. \nEsta operación se repetirá hasta que escribas un 0");

        int num = sc.nextInt();
        int k = 0; // Contador
        int suma = 0;
        while (num != 0){
            suma = suma + num;
            k++;
            num = sc.nextInt();
        }
        System.out.println("La suma total de los números introducidos es " + suma);
        System.out.println("El promedio de los números introducidos es " + (suma/k));
    }
}