public class Usuario {
    private String nombre;
    private int numeroUsuario;
    private String telefono;
    private String tarjeta;

    public Usuario(String nombre, Usuario numeroUsuario, String telefono, String tarjeta) {
        nombre = Utilidad.generaNombre();
        numeroUsuario = Utilidad.generaUsuario();
        telefono = Utilidad.generaNum(9);
        tarjeta = Utilidad.generaNum(16);
    }

    public Usuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
        this.nombre = "";
        this.telefono = "";
        this.tarjeta = "";
        // constructor que inicializa un objeto Usuario con datos vacios
        // pero con identificador único pasado por parámetro
        //código
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
// GET Y SET necesarios

    public void setNumeroUsuario(int numeroUsuario){
        this.numeroUsuario = numeroUsuario;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
}
