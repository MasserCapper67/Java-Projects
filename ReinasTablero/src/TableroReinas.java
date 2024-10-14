import java.util.ArrayList;
import java.util.Arrays;

public class TableroReinas {
    private int[][] tablero;
    private int numReinas;
    private int dimension;
    int[] posReinas;

    public TableroReinas(int dimension) {
        this.dimension = dimension;
        tablero = new int[dimension][dimension];
        numReinas = 0;
        posReinas = new int[dimension];
        Arrays.fill(posReinas, -1);
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int getDimension() {
        return dimension;
    }

    public int getNumReinas() {
        return numReinas;
    }

    public void backtracking(int fila) {
        if (fila == dimension) {
            imprimirReinas();
            return;
        }

        for (int columna = 0; columna < dimension; columna++) {
            if (movimientoValido(fila, columna)) {
                ponerReina(fila, columna);
                tablero[fila][columna] = 1;

                backtracking(fila + 1);

                //Backtracking momento
                posReinas[fila] = -1;
                tablero[fila][columna] = 0;
            }
        }
    }

    public boolean movimientoValido(int fila, int columna) {
        return movimientoValidoAux(fila, columna, posReinas);
    }

    private boolean movimientoValidoAux(int fila, int columna, int[] reinas) {
        boolean valido = true;

        for (int i = 0; i < fila; i++) {
            int columnaReina = reinas[i];

            if (columnaReina != -1) {
                if (columnaReina == columna) {
                    valido = false;
                }

                if (Math.abs(i - fila) == Math.abs(columnaReina - columna)) {
                    valido = false;
                }
            }
        }
        return valido;
    }

    public void ponerReina(int fila, int columna) {
        posReinas[fila] = columna;
        tablero[fila][columna] = 1;
        numReinas++;
    }


    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void imprimirReinas() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (posReinas[i] == j) {
                    System.out.print("Q  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
