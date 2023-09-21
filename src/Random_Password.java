import java.util.Scanner;

public class Random_Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Please select the length of the password: ");
        num = sc.nextInt();

        String lowerCases = "qwertyuioplkjhgfdsazxcvbnm";
        String lowerCases2 = "qwertyuioplkjhgfdsazxcvbnm";
        String lowerCases3 = "qwertyuioplkjhgfdsazxcvbnm";
        String upperCases = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String upperCases2 = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String symbols = "!#$%/()=?¿¡+<>_+-*";

        String password = "";

        for (int i = 0; i < num; i++){
            int random = (int)(7 * Math.random());

            switch(random){
                case 0:
                    password += String.valueOf((int)(9 * Math.random()));
                    break;

                case 1:
                    random = (int)(lowerCases.length() * Math.random());
                    password += String.valueOf(lowerCases.charAt(random));
                    break;

                case 2:
                    random = (int)(upperCases.length() * Math.random());
                    password += String.valueOf(upperCases.charAt(random));
                    break;

                case 3:
                    random = (int)(symbols.length() * Math.random());
                    password += String.valueOf(symbols.charAt(random));
                    break;

                case 4:
                    random = (int)(lowerCases2.length() * Math.random());
                    password += String.valueOf(lowerCases2.charAt(random));
                    break;

                case 5:
                    random = (int)(lowerCases3.length() * Math.random());
                    password += String.valueOf(lowerCases3.charAt(random));
                    break;

                case 6:
                    random = (int)(upperCases2.length() * Math.random());
                    password += String.valueOf(upperCases2.charAt(random));
                    break;
            }
        }
        System.out.println("Your password is " + password);
    }
}