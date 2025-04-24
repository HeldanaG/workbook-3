package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    static DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static LocalDateTime timeStamp = LocalDateTime.now();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        logActions("launch");

        boolean appRunning=true;
        while(appRunning) {

            System.out.print("Enter a search term (X to exit): ");
            String searchTerm = input.nextLine();

            if (searchTerm.equalsIgnoreCase("x")) {
                System.out.print("Good Bye!");
                logActions("Exit");
                appRunning = false;
            } else if (searchTerm.isEmpty()) {
                System.out.println("Search term can not be empty. Try Again!");
                continue;
            } else {
                logActions("Search : " + searchTerm);
            }
        }
    }
    // this the method that will create and maintain our log life
    public static void logActions(String theAction){
        // allow us to catch invalid input
        try{
            // create a file writter and set append to true so it adds to the file
            // and not override its contents
            FileWriter outPutFile = new FileWriter("src/main/resources/logs.txt", true);

            // create the buffered writer to write to the log file
            BufferedWriter bufWriter = new BufferedWriter(outPutFile);

            //create the line to write to the log file buy cancanting the timeStamp in the correct format a space and action
            bufWriter.write(timeStamp.format(timeStampFormatter)+ " " + theAction);

            //make sure we have new line
            bufWriter.newLine();

            // close the bufferwriter
            bufWriter.close();
        }catch (Exception e){
            System.out.println("Error writing to the file: "+ e.getMessage());
        }
    }
}
