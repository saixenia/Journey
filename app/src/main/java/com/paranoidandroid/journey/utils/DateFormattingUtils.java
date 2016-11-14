package com.paranoidandroid.journey.utils;

import android.content.Context;
import android.text.format.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class DateFormattingUtils {
    private static DateFormat DATE_FORMAT = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM);

    public static String formatDateRange(Context context, Date start, Date end) {
        if (start == null || end == null) {
            return "";
        }
        return DateUtils.formatDateRange(context, start.getTime(), end.getTime(), DateUtils.FORMAT_ABBREV_ALL);
    }

    /**
     * Get the number of days between start and end as a string.
     */
    public static CharSequence formatDurationInDays(Date start, Date end) {
        // TODO(emmanuel): maybe there is a way to do this that accounts for current locale?
        long days = getDateDiff(start, end, TimeUnit.DAYS);
        return days + "d";
    }

    /**
     * Get a diff between two dates
     *
     * @param date1    the oldest date
     * @param date2    the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    private DateFormattingUtils() {
    }
}
