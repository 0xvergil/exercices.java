import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;
        try {
            return LocalDateTime.parse(stringDate);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()                        // ← FIX
                .appendPattern("EEEE d MMMM yyyy")
                .toFormatter(Locale.ENGLISH);

        try {
            return LocalDate.parse(stringDate, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;

        try {
            String lower = stringDate.toLowerCase();

            int hour = Integer.parseInt(lower.substring(0, 2));

            boolean isEvening = lower.contains("evening");
            boolean isAfternoon = lower.contains("afternoon");
            boolean isMorning = lower.contains("morning");

            if (isEvening || isAfternoon) {
                if (hour != 12) hour += 12;
            } else if (isMorning) {
                if (hour == 12) hour = 0;
            }

            int minuteIndex = lower.indexOf("minutes");
            int minute = Integer.parseInt(lower.substring(minuteIndex - 3, minuteIndex - 1));

            int secondIndex = lower.indexOf("seconds");
            int second = Integer.parseInt(lower.substring(secondIndex - 3, secondIndex - 1));

            return LocalTime.of(hour, minute, second);
        } catch (Exception e) {
            return null;
        }
    }
}
