public class Impostor {
    private Clave[] claves;
    private int numClaves;
    private Tripulante tripulanteImpostor;
    private int contadorClaves = 1;

    public Impostor(int numTripulantes, Tripulante tripulanteImpostor) {
        claves = new Clave[numClaves];
        this.numClaves = numTripulantes;
        this.tripulanteImpostor = tripulanteImpostor;
        claves[0] = tripulanteImpostor.getClave();
    }

    public int getIdentificador(){
        return tripulanteImpostor.getIdentificador();
    }

    public void robarClave(Tripulante tripulante) {
        Clave claveRobada = tripulante.getClave();
        claves[contadorClaves] = claveRobada;
        contadorClaves++;
        System.out.println("Has obtenido una nueva clave del reactor. Ya tienes las siguientes:");
    }

    private void mostrarClaves() {
        for (int i = 0; i < contadorClaves - 1; i++){
            claves[i].toString();
        }
    }

    public boolean quiereJugar() {
        return Teclado.leerBoolean("Quieres tratar de adivinar la clave del reactor (S/N)? ");
    }

    public boolean adivinaClave(Clave claveReactor) {
        boolean resultado;
        String claveLetras = Teclado.leerString("Introduce la parte alfabética de la clave: ");
        String claveDigitos = Teclado.leerString("Introduce la parte numérica de la clave: ");
        resultado = claveReactor.equals(new Clave(claveLetras, claveDigitos));
        if (!resultado) {
            System.out.println("Has fallado. La clave del reactor era " + claveReactor);
        }
        return resultado;
    }

}
