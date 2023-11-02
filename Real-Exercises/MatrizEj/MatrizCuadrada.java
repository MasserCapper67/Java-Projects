public class MatrizCuadrada{
    private int[][] matriz;

    public MatrizCuadrada(int dimension, int valor){
        this.matriz = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                matriz[i][j] = valor;
            }
        }
        dimension = valor;
    }
    public int getDimension(){
        return matriz.length;
    }
    public int getElemento(int fila, int columna){
        return this.matriz[fila][columna];
    }
    public void asignar(int fila, int columna, int valor){
        this.matriz[fila][columna] = valor;
    }
    public void rellenarDiagonales(){
        for (int fila = 0; fila < matriz.length - 1; fila++){
            matriz[fila][fila] = 0;
        }
    }
    public void mostrarMatriz(){
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j ++){
                System.out.println(matriz[i][j]);
            }
            System.out.println();
        }
    }
}