package com.pluralsight;

// Importing utility classes for Scanner (user input) and Random (random numbers)

import java.util.*;

public class FamousQuotes {
    public static void main(String[] args) {

        // Create a Scanner object to read user input from the console
        Scanner input = new Scanner(System.in);

        // Create a Random object to generate random numbers later
        Random rand = new Random();

        // Boolean flag to control the while loop (keep app running)
        boolean appRunning = true;

        // Declare and initialize an array of 10 famous quotes
        String[] quotes = new String[10];
        quotes[0] = "What you get by achieving your goals is not as important as what you become by achieving your goals.";
        quotes[1] = "Believe you can and you're halfway there.";
        quotes[2] = "Do what you can, with what you have, where you are.";
        quotes[3] = "The only way to do great work is to love what you do.";
        quotes[4] = "It always seems impossible until it's done.";
        quotes[5] = "Success is not final, failure is not fatal: It is the courage to continue that counts.";
        quotes[6] = "Hardships often prepare ordinary people for an extraordinary destiny.";
        quotes[7] = "Don’t watch the clock; do what it does. Keep going.";
        quotes[8] = "Great things never come from comfort zones.";
        quotes[9] = "Push yourself, because no one else is going to do it for you.";

        // Main loop: keeps running until the user decides to quit
        while (appRunning) {
            try {
                // Prompt the user to select a quote number between 1 and 10
                System.out.print("Enter 1-10 to display a quote: ");
                int userChoice = input.nextInt();

                // Display the corresponding quote from the array
                System.out.println(quotes[userChoice - 1]);

            } catch (Exception e) {
                // If user enters invalid input (like a letter or out of range), show error and retry
                System.out.println("Invalid Input! try again.\n");
                input.nextLine(); // Clear bad input from scanner buffer
                continue; // Skip to next loop iteration
            }

            input.nextLine(); // Clear leftover newline character from buffer

            // Ask user if they want to see another quote
            System.out.print("\nDo you want to see another quote (y/n): ");
            String userAnotherChoice = input.nextLine();

            if (userAnotherChoice.equalsIgnoreCase("y")) {
                // If yes, ask if they want a random quote
                System.out.print("Do you want to see random quote (y/n): ");
                String userRandomChoice = input.nextLine();

                if (userRandomChoice.equalsIgnoreCase("y")) {
                    // Display a randomly selected quote from the array
                    System.out.println("\n" + quotes[rand.nextInt(10)]);

                    // asking user if they still want to see another quote
                    System.out.print("\nDo you want to see another quote (y/n): ");
                    String userAnotherChoice2 = input.nextLine();

                    // if they say yes start again if not exit the loop
                    if (userAnotherChoice2.equalsIgnoreCase("y")) {
                        continue;
                    } else {
                        appRunning = false;

                    }

                } else {
                    // If not, continue to start over from the top of the loop
                    continue;
                }
            } else {
                // If user doesn't want another quote, exit the loop and end the program
                appRunning = false;
            }
        }
    }
}
