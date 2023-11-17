import java.io.*;
import java.util.Scanner;

public class Fichero {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BufferedReader reader = null;
        System.out.println("Introduzca el nombre de su fichero: ");
        String name = sc.nextLine();
        try {
            File file = new File(name);
            reader = new BufferedReader(new FileReader(name));
            System.out.println("File " + name + " exists");
            int character;
            String[] palabras;
            int lines = 0, words = 0, chars = 0;
            String chain;
            while ((chain = reader.readLine()) != null) {
                String[] wordCount = chain.split(" ");
                lines++;
                chars += chain.length();
                words += wordCount.length;
            }
            System.out.println("Number of lines: " + lines);
            System.out.println("Number of characters: " + chars);
            System.out.println("Number of words: " + words);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
