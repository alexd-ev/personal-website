package com.alexd.app;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {
    public static String formatYearMonth(String date) {
        if (date == null || date.isBlank()) {
            return "Present";
        }
        YearMonth ym = YearMonth.parse(date);
        return ym.format(DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH));
    }
}
