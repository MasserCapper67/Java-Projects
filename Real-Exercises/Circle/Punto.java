public class Punto{
    private double x, y;

    public Punto(){
        this.x = 0.0;
        this.y = 0.0;
    }
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(){
        this.x = x;
    }
    public void setY(){
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    public double distancia(Punto punto){
        double x1 = this.x;
        double y1 = this.y;
        double x2 = punto.getX();
        double y2 = punto.getY();
        double operacion1 = x2 - x1;
        double operacion2 = y2 - y1;

        return Math.sqrt((operacion1 * operacion1) + (operacion2 * operacion2));
    }
}