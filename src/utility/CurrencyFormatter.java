package utility;

import java.util.Locale;
public class CurrencyFormatter {
    public static String format(double amount){
       return "PHP" + String.format(Locale.US, "%,.2f", amount);
    }
}
