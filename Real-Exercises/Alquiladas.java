public class Alquiladas {
    private Bicicleta alquiladas[];//array para guardar las bicis alquiladas
    //como hay dos estacionamientos el número máximo de bicis alquiladas
    // será NUMEROBICISESTACIONAMIENTO * 2
    private int numeroBicisMaximo = Utilidad.NUMERO_BICIS_ESTACIONAMIENTO * 2;
    private int numeroBicisAlquiladas; //número de bicis alquiladas en ese momento

    public Alquiladas() {
        //constructor inicializa el número de bicis y el array para guardar los objetos
        this.numeroBicisAlquiladas = 0;
        alquiladas = new Bicicleta[numeroBicisMaximo];

    }

    public int getNumeroBicisAlquiladas() {
        return numeroBicisAlquiladas;
    }

    public void introduceBici(Bicicleta bici) {
        // introduce un objeto tipo Bicicleta en el array
        if (this.numeroBicisAlquiladas < this.numeroBicisMaximo) {
            alquiladas[numeroBicisAlquiladas] = bici;
            numeroBicisAlquiladas++;
        }

    }

    public Bicicleta eliminaBici() {
        // Elimina la ultima bici alquilada del array y la devuelve
        Bicicleta resul = null;
        if (this.numeroBicisAlquiladas > 0) {
            numeroBicisAlquiladas--;
            resul = alquiladas[numeroBicisAlquiladas];
        }
        return resul;

    }

}
