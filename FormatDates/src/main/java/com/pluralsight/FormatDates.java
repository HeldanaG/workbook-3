package com.pluralsight;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FormatDates {
    public static void main(String[] args) {

        // Get the current local date and time
        LocalDateTime localNow = LocalDateTime.now();

        // Convert the local date and time to GMT timezone
        ZonedDateTime gmtNow = localNow.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT"));

        // Print the date
        System.out.println("Format 1: " + localNow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println("Format 2: " + localNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("Format 3: " + localNow.format(DateTimeFormatter.ofPattern("MMM d, yyyy ")));
        System.out.println("Format 4: " + localNow.format(DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm")));
        System.out.println("Format 5: " + localNow.format(DateTimeFormatter.ofPattern("HH:mm")) + " on "
                + localNow.format(DateTimeFormatter.ofPattern("d-MMM-yyyy")));



    }
}
