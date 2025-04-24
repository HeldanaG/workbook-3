package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class StoreApp {
    static ArrayList<Product> inventory = getInventory();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        mainManu();

    }

    public static void mainManu() {

        boolean appRunning = true;
        while (appRunning) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ MAIN MENU~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("What do you want to do?\n" +
                    "1- List all products\n" +
                    "2- Lookup a product by its id\n" +
                    "3- Find all products within a price range\n" +
                    "4- Add a new product\n" +
                    "5- Quit the application \n" +
                    "Enter your command:");

            try {
                int userChoice = input.nextInt();
                input.nextLine();

                switch (userChoice) {
                    case 1:
                        ListAllProducts();
                        break;
                    case 2:
                        LookProductByID();
                        break;
                    case 3:
                        LookProductByPrice();
                        break;
                    case 4:
                        AddNewProduct();
                        break;
                    case 5:
                        appRunning = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.print("Please enter a number 1 - 5.");
                        continue;
                }
                //return userChoice;
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input! Please enter a number.\n");
                input.nextLine();
                continue;
            }
        }
    }

    public static void ListAllProducts() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LIST ALL PRODUCTS ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("We carry the following inventory:\n");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);

            // sorting the output based on names
            Collections.sort(inventory, Comparator.comparing(Product::getName));

            System.out.printf("The product id is: %d, the product name is %s, the price is $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static void LookProductByID() {
        boolean appRunning = true;
        while (appRunning) {
            try {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LOOK PRODUCT BY ID ~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.print("Enter the Product ID: ");
                String lookProductID = input.nextLine().trim();

                // Check if input is empty or doesn't contain numbers
                while (lookProductID.isEmpty() || !lookProductID.matches("\\d+")) {
                    System.out.print("Invalid input. Please enter a valid Product ID: ");
                    lookProductID = input.nextLine().trim();
                }

                int productID = Integer.parseInt(lookProductID);
                boolean found = false;

                // Loop through each Product
                for (int i = 0; i < inventory.size(); i++) {
                    if (productID == inventory.get(i).getId()) {
                        System.out.println("Product ID: " + inventory.get(i).getId() +
                                ", Product Name: " + inventory.get(i).getName() +
                                ", Product Price " + inventory.get(i).getPrice());
                        found = true;
                    }
                }
                // ONLY after checking all cars, if no match found, show this message
                if (!found) {
                    System.out.println("Sorry! Product Is Not In Store.");
                }

                System.out.print("\nDo you want to look for another Product (y/n): ");
                String lookAnotherProduct = input.nextLine();

                if (lookAnotherProduct.equalsIgnoreCase("y")) {
                    continue;
                    // If user doesn't want to search again, stop the loop
                } else if (lookAnotherProduct.equalsIgnoreCase("n")) {
                    appRunning = false;
                } else {
                    System.out.print("Invalid Input! Please Enter y or n: ");
                    lookAnotherProduct = input.nextLine();

                    while (!(lookAnotherProduct.equalsIgnoreCase("y") || lookAnotherProduct.equalsIgnoreCase("n"))) {
                        System.out.print("Invalid Input! Please Enter y or n: ");
                        lookAnotherProduct = input.nextLine();

                        if (lookAnotherProduct.equalsIgnoreCase("y")) {
                            continue;
                            // If user doesn't want to search again, stop the loop
                        } else {
                            appRunning = false;
                        }
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again.");
                input.nextLine();
                continue;
            }
        }
    }

    public static void LookProductByPrice() {
        // Control variable to keep the program running until the user decides to exit
        boolean appRunning = true;

        // Start of the outer loop
        while (appRunning) {
            try {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRICE RANGE MENU~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Product Price range Includes:\n" +
                        "1. $0 -  $9.99\n" +
                        "2. $10 - $19.99\n" +
                        "3. $20 - $39.99\n" +
                        "4. $40 - $59.99\n" +
                        "5. >= $60");

                // Prompt the user to select a price range
                System.out.print("Please Enter Your Choice: ");
                int priceRangeChoice = input.nextInt(); // Capture user's choice

                //Validate the user's input to make sure it's within 1 to 5
                while (priceRangeChoice < 1 || priceRangeChoice > 5) {
                    System.out.print("Incorrect Input! Please Choose from option 1 - 5 : ");
                    priceRangeChoice = input.nextInt();// Re-enter if invalid

                }
                // Variable to track whether any Product matched the selected price range
                boolean found = false;

                for (int i = 0; i < inventory.size(); i++) {
                    float price = inventory.get(i).getPrice(); // Get the current vehicle's price

                    // Check if the price falls into the selected price range
                    if ((priceRangeChoice == 1 && price >= 0 && price <= 9.99) ||
                            (priceRangeChoice == 2 && price >= 10 && price <= 19.99) ||
                            (priceRangeChoice == 3 && price >= 20 && price <= 39.99) ||
                            (priceRangeChoice == 4 && price >= 40 && price <= 59.99) ||
                            (priceRangeChoice == 5 && price >= 60)) {

                        // Print Product details if it matches the selected range
                        System.out.println("Product ID: " + inventory.get(i).getId() +
                                ", Product Name: " + inventory.get(i).getName() +
                                ", Product Price " + inventory.get(i).getPrice());
                        found = true; // Set flag to true when a match is found
                    }
                }
                input.nextLine(); // clear buffer
                System.out.print("\nDo you want to look for another Product (y/n): ");
                String lookAnotherProduct = input.nextLine();

                if (lookAnotherProduct.equalsIgnoreCase("y")) {
                    continue;
                    // If user doesn't want to search again, stop the loop
                } else if (lookAnotherProduct.equalsIgnoreCase("n")) {
                    appRunning = false;
                } else {
                    System.out.print("Invalid Input! Please Enter y or n: ");
                    lookAnotherProduct = input.nextLine();

                    while (!(lookAnotherProduct.equalsIgnoreCase("y") || lookAnotherProduct.equalsIgnoreCase("n"))) {
                        System.out.print("Invalid Input! Please Enter y or n: ");
                        lookAnotherProduct = input.nextLine();

                        if (lookAnotherProduct.equalsIgnoreCase("y")) {
                            continue;
                            // If user doesn't want to search again, stop the loop
                        } else {
                            appRunning = false;
                        }
                    }
                }


            } catch (Exception e) {
                // Handle invalid input errors (like letters instead of numbers)
                System.out.print("Invalid Input! Please enter a number.\n");
                input.nextLine(); // Clear the input buffer
            }
        }
    }

    public static void AddNewProduct() {

        // Control variable to keep the program running until the user decides to exit
        boolean appRunning = true;
        // Start of the outer loop
        while (appRunning) {
            try {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADD NEW PRODUCT ~~~~~~~~~~~~~~~~~~~~~~~~~~");
                // create the buffered writer to write to the log file
                BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv", true));

                System.out.print("Enter Product Id: ");
                String addProductId = input.nextLine();

                // Check if input is empty or doesn't contain numbers
                while (addProductId.isEmpty() || !addProductId.matches("\\d+") || addProductId.length() < 4) {
                    System.out.print("Invalid input. Please enter a valid 4 digit Product ID : ");
                    addProductId = input.nextLine().trim();
                }

                System.out.print("Enter Product Name: ");
                String addProductName = input.nextLine().trim();

                // Check if input is empty
                while (addProductName.isEmpty() || addProductName.length() < 3) {
                    System.out.print("Product name cannot be empty or 2 digit ,Enter Product Name: ");
                    addProductName = input.nextLine().trim();
                }

                System.out.print("Enter Product Price: ");
                String addProductPrice = input.nextLine();

                // Check if input is empty or doesn't contain numbers
                while (addProductPrice.isEmpty()) {
                    System.out.print("Invalid input. Please enter a valid Product Price: ");
                    addProductPrice = input.nextLine().trim();
                }

                //make sure we have new line
                bufWriter.newLine();

                // write content to a file
                bufWriter.write(addProductId + "|" + addProductName + "|" + addProductPrice);

                //make sure we have new line
                bufWriter.newLine();

                // close the bufferwriter
                bufWriter.close();

                //input.nextLine(); // clear buffer
                System.out.print("\nDo you want to Add another Product (y/n): ");
                String lookAnotherProduct = input.nextLine();

                if (lookAnotherProduct.equalsIgnoreCase("y")) {
                    continue;
                    // If user doesn't want to add again, stop the loop
                } else if (lookAnotherProduct.equalsIgnoreCase("n")) {
                    appRunning = false;
                } else {
                    System.out.print("Invalid Input! Please Enter y or n: ");
                    lookAnotherProduct = input.nextLine();

                    while (!(lookAnotherProduct.equalsIgnoreCase("y") || lookAnotherProduct.equalsIgnoreCase("n"))) {
                        System.out.print("Invalid Input! Please Enter y or n: ");
                        lookAnotherProduct = input.nextLine();

                        if (lookAnotherProduct.equalsIgnoreCase("y")) {
                            continue;
                            // If user doesn't want to add again, stop the loop
                        } else {
                            appRunning = false;
                        }
                    }
                }

            } catch (Exception e) {
                // Handle invalid input errors (like letters instead of numbers)
                System.out.print("Invalid Input! Please enter a number.\n");
                input.nextLine(); // Clear the input buffer
            }
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            // this method loads product objects into inventory // and its details are not shown

            BufferedReader ourBufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            String theLine;
            while ((theLine = ourBufferedReader.readLine()) != null) {
                String[] productDetails = theLine.split("\\|");

                //generate a real product
                Product product = new Product(Integer.parseInt(productDetails[0]),
                        productDetails[1],
                        Float.parseFloat(productDetails[2]));


                inventory.add(product);// keeps the adding product details to the inventory until ourBufferedReader.readLine()=null

            }

            ourBufferedReader.close();  // close reader

        } catch (Exception e) {
            e.printStackTrace();
        }

        return inventory; // after read all the details from the file and created pproduct for each line , this will return the accumulated product detail of each line

    }
}
 