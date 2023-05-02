package assignment1;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.nio.file.*;


public class Main 
{
    public static void main( String[] args ) throws IOException {
        // List<Product> productlist = new ArrayList<>();
    
        // try (FileInputStream fis = new FileInputStream("../assignment1/src/main/java/assignment1/product.txt")) { //reading the data file and auto close it after finished
        //     BufferedReader reader = new BufferedReader(new InputStreamReader(fis)); // transfer from byte to char
            
        //     String line;

        //     String type = "";
        //     String name = "";
        //     String description = "";
        //     int available = 0;
        //     double price = 0;

        //     boolean isProduct = true;

        //     while ((line = reader.readLine()) != null ) { // read until there's no line left
        //         if(!line.isEmpty()) { // reading the lines containing data
        //             String[] catandval = line.split(":"); // split between "cat"egory and "val"ue
        //             if (catandval.length == 2) { 
        //                 String key = catandval[0].trim(); // ex: Type
        //                 String value = catandval[1].trim(); // ex: Digital
        //                 switch (key) { // retrieving each data and assign it as parameter for the Product instances
        //                                 // at this point all of the data will be read before being filtered
        //                     case "Type":
        //                         if (value.equals("Physical") || value.equals("Digital") || value.equals("Gift")) {
        //                             type = value;
        //                         } else {
        //                             isProduct = false;
        //                         }
        //                         // type = value;
        //                         break;
        //                     case "Name":
        //                         name = value;
        //                         break;
        //                     case "Description":
        //                         description = value;
        //                         break;
        //                     case "Quantity available":
        //                         available = Integer.parseInt(value);
        //                         break;
        //                     case "Price":
        //                         price = Double.parseDouble(value.replace("%", ""));
        //                         break;
        //                     default:
        //                         System.err.println("Unknown key: " + key);
        //                 }
        //             } else {
        //                 System.out.println("Insufficient format!!!");
        //             } 
        //         } else { // when face an empty line
        //             if (!isProduct) { // skip iteration where it's not a product
        //                 continue;
        //             } else {
        //                 Product product = new Product(type, name, description, available, price); 
        //                 productlist.add(product); // adding the instance into the arraylist and then clear the variables containing the product properties
        //                 type = "";
        //                 name = "";
        //                 description = "";
        //                 available = 0;
        //                 price = 0;
        //             }
        //         }
        //     }
            
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // for (Product product : productlist) {
        //     System.out.println(product.getName() + "\n");
        // }



        List<Product> productlist = new ArrayList<>();
        try {
            String FileContent = Files.readString(Paths.get("../assignment1/src/main/java/assignment1/product.txt"));
            String[] currentProduct = FileContent.split("\\r?\\n\\r?\\n");

            // productlist = Files.lines(Paths.get("../assignment1/src/main/java/assignment1/product.txt"))
            productlist = Arrays.stream(currentProduct)
            .map(line -> {
                String[] catandval = line.split("\\r?\\n");
                String type = catandval[0].split(":")[1].trim();
                String name = catandval[1].split(":")[1].trim();
                String description = catandval[2].split(":")[1].trim();
                int available = Integer.parseInt(catandval[3].split(":")[1].trim());
                double price = Double.parseDouble(catandval[4].split(":")[1].trim().replace("%", ""));
                return new Product(type, name, description, available, price);
            })
            .filter(product -> product.getType().equals("Physical") || product.getType().equals("Digital"))
            .collect(Collectors.toList());
            System.out.println(productlist);


        } catch (IOException e) {
            e.printStackTrace();
        }


    
        // try (FileInputStream fis = new FileInputStream("../assignment1/src/main/java/assignment1/product.txt")) {
        //     BufferedReader reader = new BufferedReader(new InputStreamReader(fis)); // transfer from byte to char
            
        //     String line;

        //     while ((line = reader.readLine()) != null ) { // read until there's no line left
        //         if(!line.isEmpty()) { // reading the lines containing data
                
        //         } else { // when face an empty line

        //         }
        //     }


        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


        // public void ProductInstances(String key, String value, String type, boolean isProduct, String name, String description, int available, double price) {
        //     switch (key) { // retrieving each data and assign it as parameter for the Product instances
        //                     // at this point all of the data will be read before being filtered
        //         case "Type":
        //             if (value.equals("Physical") || value.equals("Digital") || value.equals("Gift")) {
        //                 type = value;
        //             } else {
        //                 isProduct = false;
        //             }
        //             // type = value;
        //             break;
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
        //             price = Double.parseDouble(value.replace("%", ""));
        //             break;
        //         default:
        //             System.err.println("Unknown key: " + key);
        //     }
        // }
    
    
    
    
    }


   



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


