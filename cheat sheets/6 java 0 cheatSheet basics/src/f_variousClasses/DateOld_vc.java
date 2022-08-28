
package f_variousClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateOld_vc {
    
    public static void main(String[] args) throws ParseException {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< patterns, locale & timezone >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // patterns
        String pattern1 = "HH:mm:ss dd/MM/yyyy";
        String pattern2 = "22:34:22 04/03/1997";
        
        // constructor variant for language and country
        Locale locale = new Locale("en", "US");
        
        // time zone associated with system
        TimeZone zone2 = TimeZone.getDefault();
        // specified time zone
        TimeZone zone3 = TimeZone.getTimeZone("Europe/Copenhagen");
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< date formats >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // simple date format
        SimpleDateFormat format = new SimpleDateFormat(pattern1);

        /*
        DateFormat allows you to define dates / times using predefined
        styles DEFAULT, SHORT, MEDIUM, LONG, or FULL
        */
        DateFormat defaultFormat = DateFormat.getDateTimeInstance();
        DateFormat defaultFormatShort = DateFormat.getInstance();
        DateFormat timeFormat 
                = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        DateFormat dateFormat 
                = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        DateFormat timeDateFormat 
                = DateFormat.getDateTimeInstance(
                        DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< date class >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // class for getting current timestamp in specified format
        Date date = new Date();
        
        // show current date
        System.out.println(date);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< combining formats & date classes >>>>> @@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        Simple date format
        making string from date object in accordance to pattern
        */
        String formatiranDateTime = format.format(date);
        // making date object from string
        Date date2 = format.parse(pattern2);

        /*
        date format
        making string from date object
        */
        String dateStr = defaultFormat.format(date);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< gregorian calendar >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // return date/time based on your time zone and locale
        GregorianCalendar dateTime 
                = (GregorianCalendar) GregorianCalendar.getInstance();
        
        // return current date/time based on specified time zone & locale
        GregorianCalendar dateTime2 
                = (GregorianCalendar) GregorianCalendar.getInstance(
                        zone2, locale);
        
        // gets time zone associated with this calendar
        TimeZone zone = dateTime.getTimeZone();
        // set time zone for this calendar
        dateTime.setTimeZone(zone2);
        
        int sec = dateTime.get(GregorianCalendar.SECOND);
        int minute = dateTime.get(GregorianCalendar.MINUTE);
        int hour = dateTime.get(GregorianCalendar.HOUR);
        int day = dateTime.get(GregorianCalendar.DAY_OF_MONTH);
        int month = dateTime.get(GregorianCalendar.MONTH);
        int year = dateTime.get(GregorianCalendar.YEAR);
        
        System.out.println(sec + " " + minute + " " + hour + " "
                + day + " " + month + " " + year);
    }
}
