public class BinarioRecursivo {
    public static void binaryConverter(int x){
        if (x == 0 || x == 1){
            System.out.print(x + " ");
        }
        else{
            binaryConverter(x / 2);
            System.out.print(x % 2 + " ");
        }
    }

    public static void main(String[] args) {
     binaryConverter(5);
    }
}
