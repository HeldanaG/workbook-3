package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean appRunning = true;
        String fileToProcess;
        String fileToCreate;

        while (appRunning) {
            try {
                // Prompt for file to process (input)
                do {
                    System.out.print("Enter the name of the employee file to process (filename.txt): ");
                    fileToProcess = input.nextLine();
                } while (fileToProcess.isEmpty());

                // Prompt for file to create (output)
                do {
                    System.out.print("Enter the name of the payroll file to create (filename.txt): ");
                    fileToCreate = input.nextLine();
                } while (fileToCreate.isEmpty());

                // Set up readers and writers
                FileReader theFile = new FileReader("src/main/resources/" + fileToProcess);
                BufferedReader ourBufferedReader = new BufferedReader(theFile);

                FileWriter fileWriter = new FileWriter("src/main/resources/" + fileToCreate);
                BufferedWriter bufWriter = new BufferedWriter(fileWriter);

                String theLine;
                // Skip header line from input file
                ourBufferedReader.readLine();

                // Write header line to output file
                bufWriter.write("id|name|gross pay\n");

                while ((theLine = ourBufferedReader.readLine()) != null) {
                    // Split line by '|'
                    String[] employeeDetails = theLine.split("\\|");

                    if (employeeDetails[0].equalsIgnoreCase("id")) {
                        continue;
                    }

                    // Create Employee object with fields from the file
                    Employee employeeInfo = new Employee(
                            Integer.parseInt(employeeDetails[0]),    // id
                            employeeDetails[1],                     // name
                            Double.parseDouble(employeeDetails[2]), // hours-worked
                            Double.parseDouble(employeeDetails[3])  // pay-rate
                    );

                    // Prepare payroll line for output file
                    String payrollFile = employeeInfo.getEmployeeId() + "|" +
                            employeeInfo.getName() + "|" +
                            employeeInfo.getGrossPay() + "\n";

                    // Write the payroll info to the output file
                    bufWriter.write(payrollFile);
                }

                // Close readers and writers
                bufWriter.close();
                ourBufferedReader.close();

                System.out.println("Payroll file created successfully!");

                // Stop the loop if needed (or keep running)
                appRunning = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
