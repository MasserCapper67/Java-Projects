import java.util.Scanner;

class PruebasIntervalo {

    public static Intervalo temperaturaDias(){
        Scanner sc = new Scanner(System.in);
        double tempMax, tempMin;
        Intervalo resultado;
        System.out.println("Introduzca la temperatura mímima: ");
        tempMin = sc.nextDouble();
        System.out.println("Introduzca la temperatura máxmima: ");
        tempMax = sc.nextDouble();

       do {
           System.out.println("Introduzca temperaturas correctas: ");
           System.out.println("Introduzca la temperatura mímima: ");
           tempMin = sc.nextDouble();
           System.out.println("Introduzca la temperatura máxmima: ");
           tempMax = sc.nextDouble();
       }while (tempMin > tempMax);
       resultado = new Intervalo(tempMin, tempMax);
       return resultado;
    }

    public static void main(String[] args) {
        double suma = 0;
        double media = 0;
        int diasTemplados = 0;
        for (int i = 1; i <= 7; i++){
            Intervalo temperaturas = temperaturaDias();
            suma += temperaturas.puntoMedio();
            if (temperaturas.incluye(15))
                diasTemplados++;
        }
        media = suma / 7;
        System.out.println("Temperatura media: " + media);
        System.out.println("Días templados: " + diasTemplados);
    }
}
