import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Juego {

    private Clave claveReactor;
    private Tripulante[] tripulacion;
    private final int TOTAL_TRIPULANTES;
    private int numTripulantes;
    private Impostor impostor;

    public Juego(int numTripulantes, int longitudClave) {
        this.TOTAL_TRIPULANTES = numTripulantes;
        this.numTripulantes = numTripulantes;
        this.claveReactor = new Clave(longitudClave);
        this.tripulacion = new Tripulante[TOTAL_TRIPULANTES];

        int numeroImpostor = aleatorio(1, TOTAL_TRIPULANTES + 1);
        for (int i = 0; i < TOTAL_TRIPULANTES; i++){
            int id = 100 + i;
            Clave claveDistorsionada = claveReactor.getDistorsionada();
            tripulacion[i] = new Tripulante(id, claveDistorsionada);
        }
        impostor = new Impostor(numTripulantes, tripulacion[numeroImpostor - 1]);
        System.out.println("Te escondes como tripulante " + impostor.getIdentificador() + ", que no te descubran");
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
                    AsciiArt.gameWon1();
                    explotada = true;
                    finJuego = true;
                } else {
                    System.out.println("SUENAN LAS ALARMAS");
                    System.out.println("ERES EXPULSADO DE LA NAVE. FRACASASTE EN LA MISIÓN");
                    AsciiArt.gameLost();
                    this.expulsarImpostor();
                    finJuego = true;
                }
            } else {
                int idExpulsado = this.expulsarSospechoso();
                if (idExpulsado == impostor.getIdentificador()) {
                    System.out.println(". 　　　。　　　　•　 　ﾟ　　。 　　.\n" +
                            "\n" +
                            "　　　.　　　 　　.　　　　　。　　 。　. 　\n" +
                            "\n" +
                            ".　　 。　　　　　 ඞ 。 . 　　 • 　　　　•\n" +
                            "\n" +
                            "　　ﾟ　　 "+ impostor.getIdentificador() +  " was the Impostor.　 。　.\n" +
                            "\n" +
                            "　　'　　　     0 Impostors remain 　 　　。\n" +
                            "\n" +
                            "　　ﾟ　　　.　　　. ,　　　　.　 .");
                    System.out.println("ERES EXPULSADO DE LA NAVE. FRACASASTE EN LA MISIÓN");
                    finJuego = true;
                }
            }
        } while (!finJuego && numTripulantes > 1);
        if (!finJuego) {
            AsciiArt.gameWon2();
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
        if (numTripulantes > 1) {
            int eliminado = 0;
            while (tripulacion[eliminado].getIdentificador() == impostor.getIdentificador()){
                eliminado = aleatorio(0, numTripulantes);
            }
            System.out.println("Ves al tripulante " + tripulacion[eliminado].getIdentificador() + ". Es tu oportunidad \nPresiona ENTER para asesinarlo:");
            Teclado.enter();
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⣤⣤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠟⠋⠉⠉⠉⠉⠉⠙⠻⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⣼⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⣸⡟⠀⠀⠀⢀⣴⣶⠿⠿⠿⠟⠛⠛⠛⠻⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢀⣿⠁⠀⠀⠀⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⣠⣤⣶⡾⣾⡏⠀⠀⠀⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⢸⡿⠋⠀⠀⣾⡇⠀⠀⠀⠀⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣾⠇⡀⠀⠀⣿⠁⠀⠀⠀⠀⠘⢿⣦⣤⣤⣤⣤⣤⣤⣤⣤⣶⢿⣟⠁⠀⠀⠀⠀⠀Tripulante " + tripulacion[eliminado].getIdentificador() + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣿⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⠀⢸⡟⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣿⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⣠⡾⠋⠉⠀⠀⠀⠀⠀⠀⠈⠉⠙⠳⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣿⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⣿⠀⠀⣀⣀⣤⣤⣄⣀⣀⠀⠀⠀⠀⠈⣻⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⢿⡇⠀⠀⠀⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠇⠀⠀⠀⠀⢀⣿⠾⢟⣉⣁⣤⣤⣄⣉⡉⠛⢶⣴⡶⠟⠛⠛⠶⣤⡀⠀⠀⠀⠀⠀\n" +
                    "⠸⣷⡄⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣴⠟⣧⡾⠛⠉⢉⣀⡀⠉⠉⠙⠳⣦⣌⠻⣦⡀⠀⠀⠈⠿⠞⠛⠻⣦⠀\n" +
                    "⠀⠙⠿⠿⠶⣿⡇⠀⠀⠀⠀⠀⠀⣤⣤⣄⣀⣀⣠⣤⠆⠀⢸⡿⠀⠀⠀⣼⡿⠿⠿⣶⠶⠛⠋⠉⣿⡄⠀⠀⠀⠀⠙⣧⠈⢷⡄⠀⠀⠀⠀⠀⠀⢹⡆\n" +
                    "⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⣿⡅⠉⢹⣿⠁⠀⠀⠀⢸⡇⠀⠀⠀⣿⠀⠀⣴⠗⠀⠐⠶⣴⠟⠁⠀⠀⠀⠀⠀⣼⠃⢸⡇⠀⢀⡤⠀⢀⣠⡿⠀\n" +
                    "⠀⠀⠀⠀⠀⢸⣧⠀⠀⠀⠀⠀⠀⣿⠇⠀⠸⣿⡀⠀⠀⠀⣼⠁⠀⣀⣤⣽⡷⢶⣯⠀⠀⠀⠀⣹⠀⠀⠀⢀⣠⣴⠞⠋⢀⣾⢃⣴⠿⣷⠛⠋⠉⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠈⢿⣦⣤⣀⣀⣤⣾⠟⠀⠀⠀⠙⠛⠿⠿⠟⣫⡶⠟⠉⠁⠀⠀⠀⠙⠷⠦⢤⣶⣟⣛⡛⠛⠋⣉⣀⣤⣴⡿⠟⠋⣡⣼⠋⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⢧⣤⣀⣀⣀⣀⣀⣤⣤⣬⣧⠀⠀⠉⠉⠉⠉⠉⠉⢉⣡⣤⡴⠶⠛⠋⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠀⠀⠸⣷⣶⡶⠶⠶⠶⠖⠛⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
            System.out.println("De pronto, el tripulante " + tripulacion[eliminado].getIdentificador() + " es atacado y eliminado");
            impostor.robarClave(tripulacion[eliminado]);
            eliminarTripulante(eliminado);
            impostor.mostrarClaves();
        }else System.out.println("No hay tripulantes para atacar");
    }

    public void eliminarTripulante(int posicion) {
        if (posicion == numTripulantes - 1){
            tripulacion[numTripulantes - 1] = null;
            numTripulantes--;
        }else {
            for (int i = posicion; i < numTripulantes - 1; i++){
                tripulacion[i] = tripulacion[i + 1];
            }
            tripulacion[numTripulantes - 1] = null;
            numTripulantes--;
        }
        System.out.println("Quedan " + numTripulantes + " tripulantes vivos");
    }

    public void expulsarImpostor() {
        int posicionImpostor = -1;
        for (int i = 0; i < numTripulantes - 1; i++){
            if (tripulacion[i].getIdentificador() == impostor.getIdentificador()){
                posicionImpostor = i;
            }
        }
        if (posicionImpostor >= 0 && posicionImpostor < numTripulantes) {
            eliminarTripulante(posicionImpostor);
        }
    }

    public int expulsarSospechoso() {
        int decision = (int)(Math.random() * 4);
        int idAux = 0;
        if (decision == 0){
            AsciiArt.noOneEjected();
            System.out.println("Tras un largo debate se ha decidido no expulsar a nadie");
            return -1;
        }else{
            if (numTripulantes > 1){
                int expulsar = (int) (Math.random() * numTripulantes);
                while (expulsar < 0 || expulsar >= numTripulantes || tripulacion[expulsar] == null){
                    expulsar = (int) (Math.random() * numTripulantes);
                }
                idAux = tripulacion[expulsar].getIdentificador();
                if (tripulacion[expulsar] != null){
                    System.out.println("Se ha decidido expulsar de la nave al tripulante " + tripulacion[expulsar].getIdentificador() + " por sospechoso");
                    if (tripulacion[expulsar].getIdentificador() != impostor.getIdentificador() && tripulacion != null) {
                        System.out.println(". 　　　。　　　　•　 　ﾟ　　。 　　.\n" +
                                "\n" +
                                "　　　.　　　 　　.　　　　　。　　 。　. 　\n" +
                                "\n" +
                                ".　　 。　　　　　 ඞ 。 . 　　 • 　　　　•\n" +
                                "\n" +
                                "　　ﾟ　　 " + tripulacion[expulsar].getIdentificador() + " was not An Impostor.　 。　.\n" +
                                "\n" +
                                "　　'　　　     1 Impostor remain 　 　　。\n" +
                                "\n" +
                                "　　ﾟ　　　.　　　. ,　　　　.　 .");
                        eliminarTripulante(expulsar);
                    }
                    return idAux;
                }
            }
        }
        return -1;
    }

    public void guardarEstadoNave(String ruta) {
        File fileNave = new File(ruta + ".txt");

        try (PrintWriter pw = new PrintWriter(fileNave)){
            pw.println("Clave del reactor: " + claveReactor.toString());
            pw.println("Tripulación de la nave: " + TOTAL_TRIPULANTES);
            pw.println("Tripulantes elimiandos: " + (TOTAL_TRIPULANTES - numTripulantes));
            pw.println("Tripulantes supervivientes: ");
            for (int i = 0; i < numTripulantes; i++){
                pw.println("\tTripulante " + tripulacion[i].getIdentificador() + " clave: " + tripulacion[i].getClave());
            }
        }catch (FileNotFoundException e){
            System.err.println ("Error al escribir.");
        }
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
