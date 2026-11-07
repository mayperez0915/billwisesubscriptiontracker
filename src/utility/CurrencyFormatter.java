package utility;

import java.text.NumberFormat;
import java.util.Locale;
public class CurrencyFormatter {
    public static String format(double amount){
        NumberFormat formatter =
            NumberFormat.getCurrencyInstance(
                Locale.forLanguageTag("en-PH"));
        
        return formatter.format(amount);
    }
}
