package com.alexd.app;

import java.util.Locale;

import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String formatYearMonth(String date) {
        if (date == null || date.isBlank()) {
            return "Present";
        }
        YearMonth ym = YearMonth.parse(date);
        return ym.format(DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH));
    }

    public static String formatLocalDateTime(String zone) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zone));
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
