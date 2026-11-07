package utility;

import java.util.Scanner;
public class InputHelper {
    public static int getInt(Scanner sc, String message){

        while (true){
            try {
                System.out.println(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid input! Enter a number.");
            }
        }
    }
    public static  double getDouble (Scanner sc, String message){

        while (true) { 
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());

                if (value < 0){
                    System.out.println("Price cannot be negative");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price! try again");
            }
        }
    }
    public static String getString (Scanner sc, String message){

        System.out.print(message);
        return sc. nextLine ();
    }
}
