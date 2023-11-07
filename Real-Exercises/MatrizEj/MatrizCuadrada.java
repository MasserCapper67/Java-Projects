public class MatrizCuadrada{
    private String codigoRojo = "\u001B[31m";
    private String codigoReset = "\u001B[0m";
    private int[][] matriz;

    public MatrizCuadrada(int dimension, int valor){
        this.matriz = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                matriz[i][j] = valor;
            }
        }
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

    public void mostrarMatriz(){
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void resaltarDiagonales(){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (j == i || j == (matriz.length - 1) - i){
                    System.out.print(codigoRojo + matriz[i][j] + "\t");
                }else System.out.print(codigoReset + matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void rellenarDiagonales(){
        for (int fila = 0; fila <= matriz.length - 1; fila++){
            matriz[fila][fila] = 0;
            matriz [fila][(matriz.length - 1) - fila] = 0;
        }
    }
    public void rellenarTrianguloInferior(){
        for (int i = 1; i <= matriz.length - 1; i++){
            for (int k = 0; k < i; k++){
                matriz[i][k] = 0;
            }
        }
    }
    public void resaltarTriangulo(){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (j < i){
                    System.out.print(codigoRojo + matriz[i][j] + "\t");
                }else System.out.print(codigoReset + matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}