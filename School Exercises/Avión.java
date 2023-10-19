public class Avión {
    private final String MARCA;
    private final String MODELO;
    private String matrícula;
    private int númeroDeAsientos;
    private double combustible;
    private final double MAX_COMBUSTIBLE;


    public Avión(String marca, String modelo, String matrícula, int númeroDeAsientos, double máximoCombustible) {
        MARCA = marca;
        MODELO = modelo;
        this.matrícula = matrícula;
        if (númeroDeAsientos > 0)
            this.númeroDeAsientos = númeroDeAsientos;
        else this.númeroDeAsientos = 0;
        combustible = 0;
        MAX_COMBUSTIBLE = máximoCombustible;
    }

    public String getMarca() {
        return MARCA;
    }

    public String getModelo() {
        return MODELO;
    }

    public String getMatrícula() {
        return matrícula;
    }

    public void setMatrícula(String matrícula) {
        this.matrícula = matrícula;
    }

    public int getNúmeroDeAsientos() {
        return númeroDeAsientos;
    }

    public void setNúmeroDeAsientos(int númeroDeAsientos) {
        if (númeroDeAsientos > 0)
            this.númeroDeAsientos = númeroDeAsientos;
        else númeroDeAsientos = 0;
    }

    public double getCapacidad() {
        return MAX_COMBUSTIBLE;
    }
	
    public double getCombustible() {
        return combustible;
    }

    public boolean sinCombustible(){
        return combustible == 0;
    }

    public void llenarDepóstio(){
        combustible = MAX_COMBUSTIBLE;
    }

    public void vaciarDepósito(){
        combustible = 0;
    }

    public void gastarCombustible(double númeroLitros){
        if (númeroLitros < combustible)
            combustible -= númeroLitros;
        else combustible = 0;
    }

    public void repostarCombustible(double númeroLitros){
        if (númeroLitros < MAX_COMBUSTIBLE - combustible)
            combustible += númeroLitros;
        else combustible = MAX_COMBUSTIBLE;
    }
	
    public String toString(){
        return MARCA + MODELO + "(" + matrícula +"): " + númeroDeAsientos + " asientos, " + combustible + " l de fuel";
    }
}
