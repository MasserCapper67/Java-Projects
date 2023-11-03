public class GestionEstacionamiento {
    // Clase proporcionada para gestionar la estructura de datos usada para almacenar las bicis
    private Bicicleta cargadores[];//Array para guardar las bicis
    private int numerobicis = Utilidad.NUMERO_BICIS_ESTACIONAMIENTO;//número bicis inicial en el estacionamiento

    public GestionEstacionamiento() {
        cargadores = new Bicicleta[Utilidad.NUMERO_BICIS_ESTACIONAMIENTO];//genera el array
        llenaCargadores();//rellena el array con los objetos Bicicleta
    }

    private void llenaCargadores() {
        //método que llena el almacen de bicis de un estacionamiento con
        //las bicis
        for (int i = 0; i < numerobicis; i++) {
            cargadores[i] = new Bicicleta();
        }
    }

    public Bicicleta sacaBici() {
        // método que saca una bici del estacionamiento y decrementa el número de
        // bicis disponibles en el
        Bicicleta resul = null;
        if (numerobicis > 0) {
            numerobicis--;
            resul = cargadores[numerobicis];
            resul.cargaBateria(Utilidad.CARGA_MAXIMA);
        }
        return resul;
    }

    public boolean introduceBici(Bicicleta bici) {
        //método que introduce una bici en la estructura e incrementa el
        // número de bicis disponibles en ella.
        boolean resul = false;
        if (numerobicis < Utilidad.NUMERO_BICIS_ESTACIONAMIENTO) {
            resul = true;
            cargadores[numerobicis] = bici;
            numerobicis++;
        }
        return resul;
    }

    public int numBicis() {
        return numerobicis;
    }
}
