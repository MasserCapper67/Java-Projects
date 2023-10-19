import java.util.Scanner;

public class pruebasAvion{
    public static Avión leerAvion(Scanner sc){
        String marca, modelo, matricula;
        int numAsientos;
        double maxCombustible;

        System.out.println("Introduzca la marca");
        marca = sc.nextLine();
        System.out.println("Indique el modelo: ");
        modelo = sc.nextLine();
        System.out.println("Indique la matrícula: ");
        matricula = sc.nextLine();
        System.out.println("Número de asientos: ");
        numAsientos = sc.nextInt();

        while (numAsientos <= 0){
            System.out.println("Introduzca un número de asientos correcto");
            numAsientos = sc.nextInt();
        }
        System.out.println("Combustible máximo: ");
        maxCombustible = sc.nextDouble();

        while(maxCombustible <= 0){
            System.out.println("Indique el combustible máximo: ");
            maxCombustible = sc.nextDouble();
        }

        return new Avión(marca, modelo, matricula, numAsientos, maxCombustible);
    }

    public static double traspasoCombustible(Avión avion1, Avión avion2) {
        double traspaso = 0.0;
        double media = (avion1.getCombustible() + avion2.getCombustible()) / 2.0;
        traspaso = avion1.getCombustible() + avion2.getCombustible() - media;
        if (avion1.getCombustible() > avion2.getCombustible()) {
            if (avion2.getCombustible() + media > avion2.getCapacidad()) {
                traspaso = avion2.getCapacidad() + avion2.getCombustible();
                avion2.llenarDepóstio();
                avion1.gastarCombustible(traspaso);
            }else {
                avion1.gastarCombustible(traspaso);
                avion2.repostarCombustible(traspaso);
            }
        }else {
            if (avion1.getCombustible() + media > avion1.getCapacidad()) {
                traspaso = avion1.getCapacidad();
            }else {
                avion1.repostarCombustible(traspaso);
                avion2.gastarCombustible(traspaso);
            }
        }
        return traspaso;
    }
    public static void main(String[] args) {
        Avión avion1, avion2, avion3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Avion 1 datos: ");
        avion1 = leerAvion(sc);
        System.out.println("Avion 2 datos: ");
        avion2 = leerAvion(sc);
        System.out.println("Avion 3 datos: ");
        avion3 = leerAvion(sc);

        avion1.llenarDepóstio();
        avion2.llenarDepóstio();
        System.out.println("Litros a extraer Avion 2: ");
        double extraccion = sc.nextDouble();
        avion2.gastarCombustible(extraccion);
        System.out.println("Antes del traspaso. ");
        System.out.println(avion1.toString());
        System.out.println(avion2.toString());
        System.out.println(avion3.toString());
        double traspaso = traspasoCombustible(avion1, avion2);
    }
}