package com.sebnsab.demo.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtilityDemo {

    // Convert Util Date To Local Date
    public static LocalDate toLocalDateFromUtilDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate toLocalDateFromUtilDateViaSqlDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    // Convert Util Date To LocalDateTime
    public static LocalDateTime toLocalDateTimeFromUtilDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTimeFromUtilDateViaTimeStamp(Date date) {
        return new java.sql.Timestamp(date.getTime()).toLocalDateTime();
    }

    // Convert LocalDate To Util Date

    public static Date toUtilDateFromLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date toUtilDateFromLocalDateViaSqlDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    // Convert LocalDateTime To Util Date

    public static Date toUtilDateFromLocalDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toUtilDateFromLocalDateViaSqlTimeStamp(LocalDateTime localDateTime) {
        return java.sql.Timestamp.valueOf(localDateTime);
    }


    // String to Local Date

    public LocalDate toLocalDateFromStringViaParse(String stringDate) {
        return LocalDate.parse("2019/12/31", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    // String to Util Date

    public Date toUtilDateFromString() throws ParseException {

        return new SimpleDateFormat("dd-MMM-yyyy").parse("05-May-2019");
    }

    // Integers  to Local Date

    public LocalDate toLocalDateFromString(int year, int month, int day) {
        return LocalDate.of(year,month,day);

    }

    // Util Date To SqlDate

    public java.sql.Date ToSqlDateFromUtilDate(Date utilDate) {
        return new java.sql.Date(utilDate.getTime());

    }

    // SQL Date to Util Date
    public Date ToUtilDateFromSQLDate(java.sql.Date sqlDate) {
        return new Date(sqlDate.getTime());
    }





}
