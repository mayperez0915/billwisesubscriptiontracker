package utility;

public class InputValidator {
    
    public static boolean isValid(double price){
        return price >=0;
    } 

    public static boolean isValid(int id){
        return id > 0;
    }

    public static boolean isNotEmpty(String value){
        return value != null && !value.trim(). isEmpty();
    }
}