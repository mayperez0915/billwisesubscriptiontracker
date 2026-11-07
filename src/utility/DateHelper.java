package utility;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateHelper {

    public static LocalDate parseDate(String date){
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                "Invalid date! Use YYYY-MM-DD"
            );
        }
        }
        public static long getDaysRemaining (LocalDate date) {
            return LocalDate.now().until(date).getDays();
        
        }
}
