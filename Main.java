package assignment1;

import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

import java.nio.file.*;


public class Main 
{
    public static void main( String[] args ) throws IOException {
    // menu();
    // Product product1 = new Product("Phone", "new", 2 , 4.5, "physical");
    // System.out.println(product1);
        List<Product> productlist = new ArrayList<>();
    
        try (FileInputStream fis = new FileInputStream("../assignment1/src/main/java/assignment1/product.txt")) { //reading the data file and auto close it after finished
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis)); // transfer from byte to char
            
            String line;
            String type = "";
            String name = "";
            String description = "";
            int available = 0;
            double price = 0;

            while ((line = reader.readLine()) != null ) { // read until there's no line left
                if(!line.isEmpty()) { // reading the data lines
                    String[] catandval = line.split(":"); // split between "cat"egory and "val"ue
                    if (catandval.length == 2) { 
                        String key = catandval[0].trim(); // ex: Type
                        String value = catandval[1].trim(); // ex: Digital
                        System.out.println(key + "\n" + value + "\n");
                        // need to find a way that this only read the Product category

                        // if (key.equals("Type") && !value.equals("(Physical||Digital||Gift)")) {
                        //     continue;
                        // }
                        switch (key) { // retrieving each data and assign it as parameter for the Product instances
                            case "Type":
                                // if (!value.matches("Physical") && !value.equals("Digital") && !value.equals("Gift")) {
                                //     continue; // this "continue" will skip this iteration and move onto the next one
                                // }
                                if (value.equals("Physical") || value.equals("Digital") || value.equals("Gift")) {
                                    type = value;
                                } else if (!value.equals("Tax") || !value.equals("Coupon")) {
                                    continue;
                                } else {
                                    continue;
                                }
                                // type = value;
                                break;
                            case "Name":
                                name = value;
                                break;
                            case "Description":
                                description = value;
                                break;
                            case "Quantity available":
                                available = Integer.parseInt(value);
                                break;
                            case "Price":
                                price = Double.parseDouble(value.replace("%", ""));
                                break;
                            default:
                                System.err.println("Unknown key: " + key);
                        }
                    } else {
                        System.out.println("Insufficient format!!!");
                    } 
                } else { // when face an empty line
                    Product product = new Product(type, name, description, available, price); 
                    productlist.add(product); // adding the instance into the arraylist and then clear the variables containing the product properties
                    type = "";
                    name = "";
                    description = "";
                    available = 0;
                    price = 0;
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Product product : productlist) {
            System.out.println(product.getName() + "\n");
        }
    }

    // public void validatingProduct(String key, String value) {
    //     String type = "";
    //     String name = "";
    //     String description = "";
    //     int available = 0;
    //     double price = 0;
    //     switch (key) { // retrieving each data and assign it as parameter for the Product instances
    //         case "Type":
    //             if ("Digital".equals(value) || "Physical".equals(value) || "Gift".equals(value)) {
    //                 type = value;
    //                 break;
    //             } else {
    //                 return; 
    //             }
    //         case "Name":
    //             name = value;
    //             break;
    //         case "Description":
    //             description = value;
    //             break;
    //         case "Quantity available":
    //             available = Integer.parseInt(value);
    //             break;
    //         case "Price":
    //             price = Double.parseDouble(value);
    //             break;
    //         default:
    //             System.err.println("Unknown key: " + key);
    //         }
    // }

    



    public static void menu() throws IOException {
        System.out.println( "-------------Welcome to our store-------------" + "\n       Please enter your desired option" + 
        "\n1. Create new products" +
        "\n2. Edit products" +
        "\n3. Create a new shopping cart" +
        "\n4. Add products to the current shopping cart" + 
        "\n5. Remove products from the current shopping cart" + 
        "\n6. Display cart amount" + 
        "\n7. Display all shopping carts based on their total weight" +
        "\nPlease enter your choice: " );
        Scanner scanner = new Scanner(System.in); 
        try {
            int input = scanner.nextInt();
            switch(input) {
                case 1:
                    addItem();
                    return;
                case 2:
                    Edititem();
                    return;
                case 3:
                    createCart();
                    return;
                case 4:
                    addintocart();
                    return;
                case 5:
                    removefromcart();
                    return;
                case 6:
                    displayamount();
                    return;
                case 7:
                    displayonweight();
                    return;
                default:
                System.out.println("===============================" + "\n====Invalid Input, re-enter====" + "\n=============================== \n");
                menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("===============================" + "\n====Invalid Input, re-enter====" + "\n=============================== \n");
            menu();
        }
    }
    
}


