
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) return null;
        return LocalDateTime.parse(stringDate);

    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) return null;

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("EEEE d MMMM yyyy").toFormatter(Locale.ENGLISH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) return null;

        String text = stringDate.replace("in the evening", "PM").replace("in the morning", "AM");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh' hours 'a', 'mm' minutes and 'ss' seconds'", Locale.ENGLISH);
        return LocalTime.parse(text, formatter);
    }

}
