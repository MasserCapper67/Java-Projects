public class Lista{
    private final int CAPACIDAD;
    private int[] elementos;
    private int ocupacion = 0;
    public Lista(int maximo){
        CAPACIDAD = maximo;
        elementos = new int[CAPACIDAD];
        ocupacion = 0;
    }
    public int getOcupacion(){
        return this.ocupacion;
    }

    public int getElemento(int posicion){
        return elementos[posicion];
    }
    public void anadir(int elemento){
        elementos[ocupacion] = elemento;
        ocupacion++;
    }

    public int posicion(int elemento){
        for (int i = 0; i < ocupacion; i++){
            if (elementos[i] == elemento ){
                return i;
            }
            else{
                return -1;
            }
        }
        return 0;
    }

    private int joker = 0;
    public void invertir(){

        for (int i = ocupacion - 1; i > 0; i --){
            elementos[i] = elementos[joker];
            joker++;
        }
    }
    public int recorrerArray(int[] array){
        int resultado = 0;
        for (int i = 0; i < ocupacion / 2; i++){
            resultado = elementos[i];
        }
        return resultado;
    }
    public int recorrerArrayInverso(int[]array){
        int resultado = 0;
        for (int i = ocupacion - 1; i > ocupacion / 2; i--){
            resultado = elementos[i];
        }
        return resultado;
    }

    public boolean esSimetrica(){
        int puntoMedio = elementos.length / 2;
        return recorrerArray(elementos) == recorrerArrayInverso(elementos);
    }

    public void rotar(){

    }
}