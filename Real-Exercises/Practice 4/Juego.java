import java.io.PrintWriter;

public class Juego {

    private Clave claveReactor;
    private Tripulante[] tripulacion;
    private final int TOTAL_TRIPULANTES;
    private int numTripulantes;
    private Impostor impostor;

    public Juego(int numTripulantes, int longitudClave) {
        this.numTripulantes = numTripulantes;
        this.claveReactor = new Clave(longitudClave);
        this.tripulacion = new Tripulante[TOTAL_TRIPULANTES];
    }

    private static int aleatorio(int minimo, int maximo) {
        return (int)(Math.random() * (maximo - minimo) + minimo);
    }

    public void jugar() {
        boolean finJuego = false;
        boolean explotada = false;
        do {
            System.out.println("\nLos tripulantes realizan sus actividades en la nave ...");
            this.atacarTripulante();
            if (impostor.quiereJugar()) {
                System.out.println("Iniciando autodestrucción ...");
                if (impostor.adivinaClave(claveReactor)) {
                    System.out.println("EXPLOTÓ LA NAVE. HAS TENIDO ÉXITO");
                    explotada = true;
                    finJuego = true;
                } else {
                    System.out.println("SUENAN LAS ALARMAS");
                    System.out.println("ERES EXPULSADO DE LA NAVE. FRACASASTE EN LA MISIÓN");
                    this.expulsarImpostor();
                    finJuego = true;
                }
            } else {
                int idExpulsado = this.expulsarSospechoso();
                if (idExpulsado == impostor.getIdentificador()) {
                    System.out.println("ERES EXPULSADO DE LA NAVE. FRACASASTE EN LA MISIÓN");
                    finJuego = true;
                }
            }
        } while (!finJuego && numTripulantes > 1);
        if (!finJuego) {
            System.out.println("TE HAS QUEDADO SOLO EN LA NAVE. TRIUNFASTE EN LA MISIÓN");
        }
        if (!explotada) {
            boolean respuesta = Teclado.leerBoolean("¿Guardar los datos de la nave (S/N)? ");
            if (respuesta) {
                String ruta = Teclado.leerString("Nombre del archivo: ");
                this.guardarEstadoNave(ruta);
            }
        }
    }

    public void atacarTripulante() {
        // TODO 5 El impostor ataca a un tripulante para robarle la clave.
    }

    public void eliminarTripulante(int posicion) {
        // TODO 6 El tripulante que ocupa la posicion recibida en el array es eliminado.
    }

    public void expulsarImpostor() {
        // TODO 7 Expulsar de la nave al tripulante impostor (lo eliminamos)
    }

    public int expulsarSospechoso() {
        // TODO 8 Los tripulantes de la nave se reunen e intentan determinar
        //        quien es el impostor para echarle de la nave.
    }

    public void guardarEstadoNave(String ruta) {
        // TODO 9 Almacenar en un fichero el estado de la nave
    }

    public static void main(String[] args) {
        int numTripulantes = Teclado.leerEntero(5, 15,
                "¿Cuántos tripulantes tendrá la nave (min=5 y max=15)? ");
        int longitudClave = Teclado.leerEntero(2, 4,
                "¿Cuál es el tamaño de cada parte de la clave del reactor (min=2 y max=4)? ");
        Juego juego = new Juego(numTripulantes, longitudClave);
        juego.jugar();
    }
}
