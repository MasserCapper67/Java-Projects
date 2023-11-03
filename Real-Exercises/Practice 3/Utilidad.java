import java.util.concurrent.ThreadLocalRandom;

public class Utilidad {
    // numeroUsuario sirve para generar un identicador único por usuario
    //lleva la cuenta de usuarios generados
    private static int numeroUsuario = 0;
    // numeroUsuario sirve para generar un identicador único por bici
    //lleva la cuenta de bicis generadas
    private static int numBicis = 0;
    // numeroUsuario sirve para generar un identicador único por Estacionamiento
    //lleva la cuenta de Estacionamientos  generados
    private static int numEstacionamiento = 0;
    public static final int CARGA_MAXIMA = 100;
    // NUMERO_BICIS_ESTACIONAMIENTO número de bicis máximo de un estacionamiento
    public static final int NUMERO_BICIS_ESTACIONAMIENTO = 15;

    public static int asignaNumeroBici() {
        //Asigna un número de bici con identificador único
        numBicis++;
        return numBicis;
    }

    public static int asignaNumeroEstacionamiento() {
        //Asigna un número de Estacionamiento con identificador único
        numEstacionamiento++;
        return numEstacionamiento;
    }

    public static String generaNombre() {
        // Genera un String con un nombre y un apellido
        String resul;
        String [] nombres = {"Miguel", "Maria", "Susana", "Octavio", "Soledad", "Juan", "Javier", "Pilar", "Adolfo",
                "Victor", "José", "Rocio", "Claudia", "Ana", "Sonia", "Francisco", "Esmeralda", "Jorge",
                "Celia", "Tomas", "Ramon", "Violeta"};
        String [] apellidos = {"Díaz", "Fernández", "López", "Delgado", "Hernández", "Pérez", "García", "Martínez", "Suarez",
                "Rodríguez", "Gutiérrez", "Sevilla", "Gómez", "Arroyo", "Toledo", "Segovia", "Madrid", "Cuenca", "Lugo",
                "Cano", "Leo", "Alameda"};
        resul = nombres[ThreadLocalRandom.current().nextInt(0, nombres.length)] + " " +
                apellidos[ThreadLocalRandom.current().nextInt(0, apellidos.length)] + " " +
                apellidos[ThreadLocalRandom.current().nextInt(0, apellidos.length)];
        return resul;
    }

    public static String generaNum(int longitud) {
        // Genera un String numérico con de la longitud indicada
        String caracteres = "1234567890";
        String resul = "";
        char car;
        for (int i = 0; i < longitud; i++) {
            car = caracteres.charAt(ThreadLocalRandom.current().nextInt(0, caracteres.length()));
            resul += car;
        }
        return resul;
    }

    public static Usuario generaUsuario() {
        //Genera un nuevo usuario con datos aleatorios e identificador único
        Usuario resul = new Usuario(++numeroUsuario);
        resul.setNombre(generaNombre());
        resul.setTelefono(generaNum(7));
        resul.setTarjeta(generaNum(16));
        return resul;
    }
}
