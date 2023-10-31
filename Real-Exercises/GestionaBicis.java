import java.util.Scanner;


public class GestionaBicis {
    // Álvaro Bardají Robles bu0102
    // las pruebas las haremos sobre dos estacionamientos estacion1 y estacion2
    Scanner sc = new Scanner(System.in);
    Estacionamiento estacion1 = null, estacion2 = null;
    //Inicializamos la estructura para guardar las bicis que están en alquiler
    Alquiladas alquiladas = null;

    public static void main(String[] args) {
        // creamos un objeto de la clase para poder ejecutar el programa
        GestionaBicis miObjeto = new GestionaBicis();
    }

    public GestionaBicis() {
        //constructor de la clase que inicia el programa
        int opcion;
        do {
            opcion = menu();
            ejecutarOpcion(opcion);
        } while (opcion != 0);

    }

    public int menu() {
        int opt=0;
        //código
        System.out.println("1. Inicializa Estacionamientos \n2. Alquilar Bici \n3. Dejar Bici" +
                "\n4. Número de bicis de un estacionamiento \n5. Número de bicicletas alquiladas " +
                "en este momento \n0.Salir de la aplicación");
        opt = sc.nextInt();
        return opt;
    }

    public int leerNumero(int n1, int n2, String texto) {
        //método que me permite pedir un número y valida que este entre un límite
        // mínimo y uno máximo pasados por parámetro, asi como poner un texto en pantalla
        // idicando que tiene que hacer el usuario
        Scanner teclado = new Scanner(System.in);
        int num;
        do {
            System.out.print(texto);
            num = teclado.nextInt();
            if (num < n1)
                System.out.println("El número " + num + " no es mayor que " + n1);
            else if (num > n2)
                System.out.println("El número " + num + " no es menor que " + n2);
        } while (num < n1 || num > n2);
        return num;
    }

    public void ejecutarOpcion(int opcion) {
        //Ejecuta la acción elegida por el usuario
        int esta;
        switch (opcion) {
            case 1: // inicializa Estacionamientos
                this.estacion1 = new Estacionamiento(Utilidad.NUMERO_BICIS_ESTACIONAMIENTO);
                this.estacion2 = new Estacionamiento(Utilidad.NUMERO_BICIS_ESTACIONAMIENTO);
                this.alquiladas = new Alquiladas();
                break;
            case 2://Alquilar Bici
                Usuario mainUser = Utilidad.generaUsuario();
                System.out.println("Elija un estacionamiento: \n1. Estacionamiento 1 \n2. Estacionamiento 2");
                int choice = sc.nextInt();
                if (choice == 1 && estacion1.getNumeroBicis() > 0) {
                    Bicicleta bici = new Bicicleta();
                    bici.setUsuario(mainUser);
                    estacion1.cogeBici(mainUser);
                    Alquiladas alquiladas = new Alquiladas();
                    alquiladas.introduceBici(bici);
                    System.out.println("Bicicleta alquilada correctamente.");
                } else if (choice == 2 && estacion2.getNumeroBicis() > 0) {
                    Bicicleta bici = new Bicicleta();
                    bici.setUsuario(mainUser);
                    estacion2.cogeBici(mainUser);
                    Alquiladas alquiladas = new Alquiladas();
                    alquiladas.introduceBici(bici);
                    System.out.println("Bicicleta alquilada correctamente.");
                } else {
                    System.out.println("Error. Puede que haya introducido un número incorrecto o " +
                            "que no haya bicis disponibles.");
                }
                System.out.println("Introduzca cualquier carácter para continuar");
                sc.next();
                break;
            case 3://dejar Bici
                System.out.println("Introduzca el estacionamiento donde desea dejar su bici: \n1. Estacionamiento 1" +
                        "\n2. Estacionamiento 2");

            case 4://número de bicis de un estacionamiento
                //código
                break;
            case 5://número de bicis alquiladas en ese momento además de los huecos libres en cada estacionamiento
                //código
                break;

            case 0:
                System.out.println("Adiós");
                break;
        }

    }
    public Usuario pideUsuario() {
        // método que genera un usuario con datos aleatorios pero con identificador único
        //  utilizando el método de la clase Utilidad generaUsuario()
        Usuario resul;
        resul = Utilidad.generaUsuario();
        return resul;
    }
}
