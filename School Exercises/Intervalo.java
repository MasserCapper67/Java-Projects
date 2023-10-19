import java.util.Scanner;

public class Intervalo {

    private double minimo;
    private double maximo;

    public Intervalo(double minimo, double maximo) {
        if (minimo <= maximo) {
            this.minimo = minimo;
            this.maximo = maximo;
        } else {
            System.out.println("El valor mínimo no puede ser superior al valor máximo");
            this.minimo = 0;
            this.maximo = 0;
        }
    }

    public Intervalo() {
        this(0,0);
    }

    public Intervalo(Intervalo intervalo) {
        this(intervalo.minimo, intervalo.maximo);
    }

    public Intervalo(String cadena) {
        minimo = Double.parseDouble(cadena.substring(1, cadena.indexOf(",")));
        cadena = cadena.substring(cadena.indexOf(",") + 1, cadena.length() - 1);
        maximo = Double.parseDouble(cadena);
        if (minimo > maximo){
            System.out.println("El valor mínimo no puede ser superior al valor máximo");
            minimo = 0;
            maximo = 0;
        }
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMinimo(double minimo) {
        if (minimo <= maximo) {
            this.minimo = minimo;
        } else {
            System.out.println("El valor mínimo no puede ser superior al valor máximo");
        }
    }

    public void setMaximo(double maximo) {
        if (maximo >= minimo) {
            this.maximo = maximo;
        } else {
            System.out.println("El valor máximo no puede ser inferior al valor mínimo");
        }
    }

    public double longitud() {
        return maximo - minimo;
    }

    public double puntoMedio() {
        return (maximo + minimo) / 2;
    }

    public void desplazar(double cantidad) {
        minimo += cantidad;
        maximo += cantidad;
    }

    public String toString() {
        return "[" + minimo + ", " + maximo + "]";
    }

    public void escalar(double escala) {
        double nuevaLongitud = this.longitud() * escala;
        double puntoMedio = this.puntoMedio();
        minimo = puntoMedio - nuevaLongitud / 2;
        maximo = puntoMedio + nuevaLongitud / 2;
    }

    public boolean incluye(double punto) {
        return minimo <= punto && punto <= maximo;
    }

    private Intervalo copia() {
        return new Intervalo(minimo, maximo);
    }

    public Intervalo simetrico() {
        return new Intervalo(-maximo, -minimo);
    }

    public Intervalo desplazado(double cantidad) {
        Intervalo intervalo = this.copia();
        intervalo.desplazar(cantidad);
        return intervalo;
    }

    public boolean incluye(Intervalo intervalo) {
        return this.incluye(intervalo.minimo)
                && this.incluye(intervalo.maximo);
    }

    public boolean iguales(Intervalo intervalo) {
        return minimo == intervalo.minimo
                && maximo == intervalo.maximo;
    }
    
    public Intervalo interseccion(Intervalo intervalo) {
        if (this.incluye(intervalo)) {
            return intervalo.copia();
        } else if (intervalo.incluye(this)) {
            return this.copia();
        } else if (this.incluye(intervalo.minimo)) {
            return new Intervalo(intervalo.minimo, this.maximo);
        } else if (this.incluye(intervalo.maximo)) {
            return new Intervalo(this.minimo, intervalo.maximo);
        } else {
            return null;
        }
    }

    public static Intervalo leerIntervalo (Scanner teclado){
        double minimo = 0;
        double maximo = 0;
        do{
            System.out.print("Introduzca el mínimo del intervalo: ");
            minimo = teclado.nextDouble();
            System.out.print("Introduzca el máximo del intervalo: ");
            maximo = teclado.nextDouble();
        } while (minimo > maximo);
        return new Intervalo(minimo,maximo);
    }
}

