public class Circulo {
    private Punto centro;
    private double radio;

    public Circulo(Punto centro, double radio){
        this.centro = centro;
        this.radio = radio;
    }
    public Punto getCentro(){
        return centro;
    }
    public double getRadio(){
        return radio;
    }
    @Override
    public String toString(){
        return "[centro: " + centro.toString() + ", radio: " + radio + "]";
    }
    public boolean cotiene(Punto punto){
        double distancia = centro.distancia(punto);
        return distancia <= radio;
    }
}
