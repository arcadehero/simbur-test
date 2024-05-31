package com.simbirsoft.testtask.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatterHelper {

    public static String changeDateFormat(String dateInput) {

        SimpleDateFormat originalFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");

        String result = "";
        try {
            Date date = originalFormat.parse(dateInput);
            result = targetFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
