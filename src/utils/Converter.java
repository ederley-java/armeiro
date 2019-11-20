package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
    private static String PATTERN_DATETIME = "dd/MM/yyyy HH:mm:ss";

    public static String dateToString(Date date) {
        return dateToString(date, PATTERN_DATETIME);
    }
    
    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date stringToDate(String date) throws ParseException {
        return stringToDate(date, PATTERN_DATETIME);
    }

    public static Date stringToDate(String date, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(date);
    }
}