public class PruebasFecha {
    public static void main(String[] args) {
        Fecha comienzoCurso = new Fecha(11, 9, 2023);
        System.out.println("Comienzo del curso: " + comienzoCurso.imprimir());
        Fecha cursoAvanzado = comienzoCurso.copia();

        boolean esPosterior = cursoAvanzado.posteriorA(comienzoCurso);
        if (esPosterior){
            System.out.println("Curso avanzado es posterior al comienzo del curso");
        }else System.out.println("Curso avanzado no es posterior al comienzo del curso");

        for (int k = 0; k < 150; k++){
            cursoAvanzado.siguienteDia();
        }
        System.out.println("Fecha del curso después de 150 días :" + cursoAvanzado.imprimir());

        boolean esPosteior2 = cursoAvanzado.posteriorA(comienzoCurso);
        if (esPosteior2){
            System.out.println("Curso avanzado es posterior al curso inicial.");
        }else System.out.println("Curso avanzado no es posterior a curso inicial.");

        boolean esBisiesto = cursoAvanzado.esBisiesto();
        if (esBisiesto){
            System.out.println("La fecha " + cursoAvanzado.imprimir() + " pertenece a un año bisiesto.");
        }else System.out.println("La fecha " + cursoAvanzado.imprimir() + " no pertenece a un año bisiesto.");

        int año2100 = 2100;
        boolean esBisiesto2100 = Fecha.bisiesto(año2100);
        if (esBisiesto2100){
            System.out.println("El año " + año2100 + " es bisiesto");
        }else System.out.println("El año " + año2100 + " no es bisiesto");
    }
}
