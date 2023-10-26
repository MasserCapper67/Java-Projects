public class PruebasCirculo {
    public static void main(String[] args) {
        Punto punto1 = new Punto();
        Punto punto2 = new Punto(3.0, 4.0);
        System.out.println("Punto 1: " + punto1.toString());
        System.out.println("Punto 2: " + punto2.toString());

        double distancia = punto1.distancia(punto2);
        System.out.println("Distancia entre puntos: " + distancia);

        Circulo circulo = new Circulo(punto1, 5.0);
        System.out.println("Círculo: " + circulo.toString());

        if (circulo.cotiene(punto2)){
            System.out.println("El punto " + punto2 + " está contenido en el círculo.");
        }else System.out.println("El punto " + punto2 + " está fuera del círculo.");
    }
}
