package com.pluralsight;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FormatDates {
    public static void main(String[] args) {

        LocalDateTime currentDateAndTime = LocalDateTime.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("Format 1: " + currentDateAndTime.format(formatter1));

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Format 2: " + currentDateAndTime.format(formatter2));

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMM d, yyyy ");
        System.out.println("Format 3: " + currentDateAndTime.format(formatter3));

        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm");
        System.out.println("Format 4: " + currentDateAndTime.format(formatter4));

        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        System.out.println("Format 5: " + currentDateAndTime.format(formatter5) + " on " + currentDateAndTime.format(formatter6));



    }
}
