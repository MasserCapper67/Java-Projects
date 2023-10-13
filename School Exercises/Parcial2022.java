public class Parcial2022 {
    public static int generarNumero(int n1, int n2) {
        int random = (int) (Math.random() * (n2 - n1) + n1);
        return random;
    }

    public static double sumaSucesion(int n) {
        double resultado = 0;
        for (int k = 0; k <= n - 1; k++) {
            resultado = 1 / Math.pow(2, k) + resultado;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int random;
        double suma;
        do {
            random = generarNumero(0, 20);
            suma = sumaSucesion(random);
            System.out.println("Para n = " + random + ", la solución es: " + suma);
        }while (suma != 0);
        System.out.println("See ya");
    }
}
