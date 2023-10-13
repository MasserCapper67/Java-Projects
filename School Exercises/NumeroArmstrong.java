import java.util.Scanner;

public class NumeroArmstrong {
    public static Scanner sc;
    public static boolean esNumeroArmstrong(int x){
        int joker = x;
        int resultado = 0;
        while (x > 9){
            resultado = resultado + (int) Math.pow(x % 10, 3);
            x /= 10;
        }
        resultado += Math.pow(x, 3);
        return resultado == joker;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número: ");
        int choice = sc.nextInt();
        while (choice > 0){
            if (esNumeroArmstrong(choice)){
                System.out.println(choice + " es un número Armstrong");
            }
            else System.out.println(choice + " no es un número Armstrong");
            choice = sc.nextInt();
        }
    }
}
