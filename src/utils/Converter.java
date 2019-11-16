package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
    private final static String PATTERN_DATETIME = "dd/MM/yyyy HH:mm:ss";

    public static String dateToString(Date date) {
		return new SimpleDateFormat(PATTERN_DATETIME).format(date);
    }
    
    public static String dateToString(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	public static String stringToDate(String date) {
		return new SimpleDateFormat(PATTERN_DATETIME).format(date);
    }

	public static String stringToDate(String date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}
}