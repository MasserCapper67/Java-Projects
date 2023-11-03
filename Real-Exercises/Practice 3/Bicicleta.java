public class Bicicleta {
    private int numeroBici;
    private int bateria;
    private Usuario usuario;

    public Bicicleta() {
        //constructor a la propiedad numeroBici le asigna un identificador único generado en la
        //clase Utilidad por el método asignaNumeroBici()
        numeroBici = Utilidad.asignaNumeroBici();
        bateria = Utilidad.CARGA_MAXIMA;
    }
    public void setUsuario(Usuario usuario1) {
        this.usuario = usuario1;
    }

    public void setNumeroBici(int numeroBici) {
        this.numeroBici = Utilidad.asignaNumeroBici();
    }

    public void descargaBateria(int cantidad) {
        if (bateria - cantidad < 0){
            bateria = 0;
        }else{
            bateria -= cantidad;
        }
    }

    public void cargaBateria(int carga) {
        if (bateria + carga > Utilidad.CARGA_MAXIMA){
            bateria = Utilidad.CARGA_MAXIMA;
        }else{
            bateria += carga;
        }
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public int getNumeroBici() {
        return numeroBici;
    }

    @Override
    public String toString() {
        return "numeroBici = " + numeroBici + ", batería = " + bateria + ", \nDatos usuario: " + usuario.toString();
    }
}
