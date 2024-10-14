//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int dimension = 4;
        TableroReinas tablero = new TableroReinas(dimension);

        tablero.backtracking(0);
    }
}