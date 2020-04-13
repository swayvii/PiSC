package com.a1.housing.assignment1.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static Date parseDate (String date) {

        if (date != null) {
            DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
            Date result = null;

            try {
                result = df.parse(date);
            } catch (ParseException e) {
                df = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    df.parse(date);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
            return result;

        }else{
            return null;
        }

    }
}
