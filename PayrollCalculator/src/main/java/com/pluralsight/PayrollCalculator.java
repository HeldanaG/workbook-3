package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {

    public static void main(String[] args) {

        try {
            // File name
            String fileName = "employees.csv";

            // Open the file
            FileReader theFile = new FileReader("src/main/resources/" + fileName);
            BufferedReader ourBufferedReader = new BufferedReader(theFile);

            String theLine;

            // Skip the header line
            ourBufferedReader.readLine();

            // Read each data line
            while ((theLine = ourBufferedReader.readLine()) != null) {
                // Split line by '|'
                String[] employeeDetails = theLine.split("\\|");

                // Create Employee object with corrected field order
                Employee employeeInfo = new Employee(
                        Integer.parseInt(employeeDetails[0]),    // id
                        employeeDetails[1],                     // name
                        Double.parseDouble(employeeDetails[2]), // hours-worked
                        Double.parseDouble(employeeDetails[3])  // pay-rate
                );

                 //Print employee payroll info
                System.out.printf(
                        "Employee ID: %d | Name: %s | Hours Worked: %.2f | Pay Rate: $%.2f | Gross Pay: $%.2f\n",
                        employeeInfo.getEmployeeId(),
                        employeeInfo.getName(),
                        employeeInfo.getHoursWorked(),
                        employeeInfo.getPayRate(),
                        employeeInfo.getGrossPay());
            }
            // Close the file reader
            ourBufferedReader.close();

        } catch (Exception e) {
           e.printStackTrace();

        }
    }
}
