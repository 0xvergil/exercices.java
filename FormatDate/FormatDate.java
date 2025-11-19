import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) return null;

        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.FRENCH);

        String month = dateTime.format(monthFormatter);

        return String.format(
                "Le %d %s de l'an %d à %dh%dm et %ds",
                dateTime.getDayOfMonth(),
                month,
                dateTime.getYear(),
                dateTime.getHour(),
                dateTime.getMinute(),
                dateTime.getSecond()
        );
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yy", Locale.ITALIAN);

        return date.format(formatter);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;

        return time.toString();
    }
}
