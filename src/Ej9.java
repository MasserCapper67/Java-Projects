import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int pos = 0, neg = 0;
        int kpos = 0, kneg = 0;
        int contZero = 0;
        System.out.println("Introduzca 10 números: ");
        for (int contador = 0; contador < 10; contador++){
            num = sc.nextInt();

            int zero = num;
            do {
                if (zero % 10 == 0){
                 contZero++;
                 zero = zero/10;
                }

            }while (zero != 0);
            if (num >= 0){
                pos = pos + num;
                kpos++;
            }
            else{
                neg = neg + num;
                kneg++;
            }
        }
        System.out.println("La media de los números positivos es " + (pos/kpos));
        System.out.println("La media de los números negativos es " + (neg/kneg));
        System.out.println("Los ceros son " + contZero);
    }
}
