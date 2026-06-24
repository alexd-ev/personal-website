package com.alexd.app;

import java.util.Locale;

import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
 * Date/time formatting utilities used across the application.
 */
public class DateTimeUtils {
    /**
     * Formats a date string as "MMM yyyy" or returns "Present" for null/blank
     * values.
     *
     * @param date ISO year-month string (yyyy-MM)
     * @return formatted display date or "Present"
     */
    public static String formatYearMonth(String date) {
        if (date == null || date.isBlank()) {
            return "Present";
        }
        YearMonth ym = YearMonth.parse(date);
        return ym.format(DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH));
    }

    /**
     * Returns the current local date/time in the specified timezone.
     *
     * @param zone timezone identifier
     * @return formatted timestamp string
     */
    public static String formatLocalDateTime(String zone) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zone));
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
