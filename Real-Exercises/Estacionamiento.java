public class Estacionamiento {
    private int numeroBicis;
    private int numeroEstacionamiento;
    private GestionEstacionamiento misCargadores;
    public Estacionamiento(int numeroBicisEstacionamiento) {
        numeroBicis = Utilidad.NUMERO_BICIS_ESTACIONAMIENTO;

        Utilidad.asignaNumeroEstacionamiento();

        misCargadores = new GestionEstacionamiento();

    }

    public Bicicleta cogeBici(Usuario miUsuario) {
        Bicicleta resul = null;
        if (numeroBicis > 0){
            resul = misCargadores.sacaBici();
            resul.setUsuario(miUsuario);
            numeroBicis --;
        }
        return resul;
    }

    public boolean dejaBici(Bicicleta bici) {
        // metodo que simula el devolver una bici
        // introduciendo  la bici en misCargadores e incrementado el número de bicis del
        // estacionamiento
        boolean resul = false;
        //Escribir el código del método
        if (numeroBicis < Utilidad.NUMERO_BICIS_ESTACIONAMIENTO){
            bici.cargaBateria(Utilidad.CARGA_MAXIMA);
            resul = misCargadores.introduceBici(bici);
            numeroBicis++;
        }
        return resul;
    }

    public int getNumeroBicis() {
        //devuelve el número de bicis que hay en el estacionamiento
        return numeroBicis;
    }
}
