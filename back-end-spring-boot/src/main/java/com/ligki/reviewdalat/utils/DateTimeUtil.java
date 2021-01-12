package com.ligki.reviewdalat.utils;

import com.ligki.reviewdalat.constant.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtil.class);

    public static String diff2DateToDayAndHour(String dateBefore, String dateAfter) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(DateTime.FORMAT_GENERAL);
            Date d1 = format.parse(dateBefore);
            Date d2 = format.parse(dateAfter);
            long diff = d2.getTime() - d1.getTime();
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            return diffDays + " days " + diffHours + " hours";
        } catch (ParseException e) {
            LOGGER.error("Cannot diff2DateToDayAndHour: {}", e.getMessage());
            return "";
        }
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat(DateTime.FORMAT_GENERAL).format(new java.util.Date());
    }
}
