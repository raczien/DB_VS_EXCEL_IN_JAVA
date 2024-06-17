package utils;

import java.time.LocalDateTime;

public class MappingUtils {

    public static Long convertToLong(String longAsString) {
        return Long.parseLong(longAsString.replace(".0", ""));
    }

    public static Integer convertToInteger(String integerAsString) {
        return Integer.parseInt(integerAsString.replace(".0", ""));
    }

    public static LocalDateTime convertToLocalDateTime(String localDateTimeAsString) {
        return LocalDateTime.parse(localDateTimeAsString, Constants.DATE_TIME_FORMATTER);
    }

    public static Double convertToDouble(String doubleAsString) {
        return Double.parseDouble(doubleAsString);
    }
}
