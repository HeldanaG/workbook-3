package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Which bedtime story do you want to read?\n" +
                "1. Goldilocks\n2. Hansel and Gretel\n3. Mary had a little lamb\n" +
                "Enter Choice: ");

        int choice = 0; // Declare choice before try so it's accessible later
        boolean appRunning = true;

        while (appRunning) {
            try {
                // Read user choice
                choice = input.nextInt();

                // Handle file reading based on choice
                switch (choice) {
                    case 1: {
                        // Open and read Goldilocks story
                        FileInputStream fis = new FileInputStream("src/main/resources/goldilocks.txt");
                        Scanner story1 = new Scanner(fis);
                        int lineNum = 1;
                        while (story1.hasNextLine()) {
                            System.out.println(lineNum + ": " + story1.nextLine());
                            lineNum++;
                        }
                        story1.close();
                        appRunning=false;
                        break;
                    }
                    case 2: {
                        // Open and read Hansel and Gretel story
                        FileInputStream fis2 = new FileInputStream("src/main/resources/hansel_and_gretel.txt");
                        Scanner story2 = new Scanner(fis2);
                        int lineNum = 1;
                        while (story2.hasNextLine()) {
                            System.out.println(lineNum + ": " + story2.nextLine());
                            lineNum++;
                        }
                        story2.close();
                        appRunning=false;
                        break;
                    }
                    case 3: {
                        // Open and read Mary had a little lamb story
                        FileInputStream fis3 = new FileInputStream("src/main/resources/mmary_had_a_little_lamb.txt");
                        Scanner story3 = new Scanner(fis3);
                        int lineNum = 1;
                        while (story3.hasNextLine()) {
                            System.out.println(lineNum + ": " + story3.nextLine());
                            lineNum++;
                        }
                        story3.close();
                        appRunning=false;
                        break;
                    }
                    default:
                        System.out.print("Invalid choice. Please choose 1, 2, or 3: ");
                        continue;
                }

            } catch (InputMismatchException e) {
                System.out.print("Invalid input type! Please enter a number: ");
                input.nextLine();
                continue;
            } catch (FileNotFoundException e) {
                System.out.println("The selected story file could not be found.");
                input.nextLine();
                continue;
            }
        }


    }
}
