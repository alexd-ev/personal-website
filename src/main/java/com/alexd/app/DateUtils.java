package com.alexd.app;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {
    public static String formatYearMonth(String completion_date) {
        if (completion_date == null || completion_date.isBlank()) {
            return "Present";
        }

        YearMonth ym = YearMonth.parse(completion_date);

        return ym.format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH));
    }
}
