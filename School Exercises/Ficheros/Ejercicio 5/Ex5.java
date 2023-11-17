import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5 {
    private static Scanner sc;
    public static String identificador(){
        String letras = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        int random = (int)(Math.random() * letras.length());
        char letra = letras.charAt(random);
        String id = "";
        for (int i = 0; i < 6; i++){
            id += letra;
        }
        return id;
    }
    public static int[] numeroApuesta(){
        int[] id = new int[6];
        for (int i = 0; i < 6; i++){
            id[i] = (int)((Math.random() * 49) + 1);
        }
        return id;
    }
    public static String arrayToString(int[] array){
        String result = "";
        for (int i = 0; i < array.length; i++){
            result += array[i] + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        DataOutputStream salida = null;
        sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de su fichero: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el número de apuestas a generar: ");
        boolean repetir = true;
        int numApuestas = 0;
        while (repetir) {
            try {
                numApuestas = sc.nextInt();
                repetir = false;
            }catch (InputMismatchException e){
                System.err.println("No introdujiste un número válido. \nInténtelo de nuevo: ");
                sc.next();
            }
        }

        try {
            salida = new DataOutputStream(new FileOutputStream(nombre));
            for (int i = 0; i < numApuestas; i++){
                salida.writeUTF(identificador() + ": " + arrayToString(numeroApuesta()));
                salida.writeUTF("\n");
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }finally {
            try {
                if (salida != null){
                    salida.close();
                }
            }catch (IOException e){
                e.getMessage();
            }
        }
    }
}
