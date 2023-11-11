public class Impostor {
    private Clave[] claves;
    private int numClaves;
    private Tripulante tripulanteImpostor;

    public Impostor(int numTripulantes, Tripulante tripulanteImpostor) {
        this.numClaves = numTripulantes;
        claves = new Clave[numClaves];
        this.tripulanteImpostor = tripulanteImpostor;
        claves[0] = tripulanteImpostor.getClave();
    }

    public int getIdentificador(){
        return tripulanteImpostor.getIdentificador();
    }

    public void robarClave(Tripulante tripulante) {
        int contiene = 0;
        Clave claveRobada = tripulante.getClave();
        while (contiene < claves.length && claves[contiene] != null){
            contiene++;
        }
        if (contiene < claves.length){
            claves[contiene] = tripulante.getClave();
            System.out.println("Has obtenido una nueva clave del reactor. Ya tienes las siguientes:");
        }
    }

    public void mostrarClaves() {
        for (Clave clave : claves){
            if (clave != null){
                System.out.println(clave.toString());
            }
        }
    }

    public boolean quiereJugar() {
        return Teclado.leerBoolean("¿Quieres tratar de adivinar la clave del reactor (S/N)? ");
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
