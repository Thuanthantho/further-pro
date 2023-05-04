package assignment1;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.nio.file.*;


public class Main 
{
    public static String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public static void main( String[] args ) throws IOException {
        String filePath = "../assignment1/src/main/java/assignment1/product.txt";
        List<Product> productList = getProductList(filePath); // the list that will only contains products
        List<Coupon> couponList = getCouponList(filePath);
        List<TaxType> taxList = getTaxList(filePath);
    }

    public static List<Product> getProductList(String filePath) throws IOException{
        List<Product> tempproductList = new ArrayList<>();
        try {
            // read everything inside the file
            String[] currentProduct = readFile(filePath).split("\\r?\\n\\r?\\n"); // this will split up between items from the list
                                                                                // (the empty line) (2 times spacing)

            tempproductList = Arrays.stream(currentProduct)
            .map(line -> {
                String[] catandval = line.split("\\r?\\n"); // this will seperate each line of each item as an element inside the list into an array
                String type = catandval[0].split(":")[1].trim(); // taking each line and split them between its category and its value
                String name = catandval[1].split(":")[1].trim();
                String description = catandval[2].split(":")[1].trim();
                int available = Integer.parseInt(catandval[3].split(":")[1].trim());
                double price = Double.parseDouble(catandval[4].split(":")[1].trim().replace("%", "")); // avoid "%" of the coupon
                boolean CanBeGifted = false;
                double weight = 0;
                if (catandval.length > 5) { // these if else to ensure each array will be checked its number of elements
                    CanBeGifted = Boolean.parseBoolean(catandval[5].split(":")[1].trim()); 
                }
                if (catandval.length > 6 && type.equals("Physical") ) {
                    weight = Double.parseDouble(catandval[6].split(":")[1].trim());
                }
                if (type.equals("Physical")) {
                    return new PhysicalProduct(type, name, description, available, price, CanBeGifted, weight);
                } else if (type.equals("Digital")) {
                    return new DigitalProduct(type, name, description, available, price, CanBeGifted);
                } 
                return new Product(type, name, description, available, price, CanBeGifted);
            })
            .filter(product -> product.getType().equals("Physical") || product.getType().equals("Digital")) // filtering the product // careful of unrecognized product type 
            .collect(Collectors.toList());
            // productList.addAll(tempproductList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempproductList;
    }


    public static List<Coupon> getCouponList(String filePath) throws IOException{
        List<Coupon> tempcouponList = new ArrayList<>(); // the list that will only contains coupon
        try {
            String[] currentProduct = readFile(filePath).split("\\r?\\n\\r?\\n");
            tempcouponList = Arrays.stream(currentProduct)
            .filter(line -> !line.isEmpty())
            .filter(line -> line.startsWith("Type: Coupon"))
            .map(line -> {
                String[] catandval = line.split("\\r?\\n");
                String CouponName = catandval[1].split(":")[1].trim();
                String description = catandval[2].split(":")[1].trim();
                int quantity = Integer.parseInt(catandval[3].split(":")[1].trim());
                String price = catandval[3].split(":")[1].trim();
                if (price.contains("%")) {
                    double percentDiscount = Double.parseDouble(catandval[3].split(":")[1].trim().replace("%", "")) / 100;
                    return new Coupon(CouponName, description, quantity, 0, percentDiscount);
                } else {
                    double fixedDiscount = Double.parseDouble(catandval[3].split(":")[1].trim());
                    return new Coupon(CouponName, description, quantity, fixedDiscount, 0);
                }
            })
            .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempcouponList;
    }


    public static List<TaxType> getTaxList(String filePath) throws IOException{
        List<TaxType> temptaxList = new ArrayList<>(); // the list that will only contains coupon
        try {
            String[] currentProduct = readFile(filePath).split("\\r?\\n\\r?\\n");
            temptaxList = Arrays.stream(currentProduct)
            .filter(line -> !line.isEmpty())
            .filter(line -> line.startsWith("Type: Tax"))
            .map(line -> {
                String[] catandval = line.split("\\r?\\n");
                String taxName = catandval[1].split(":")[1].trim();
                String description = catandval[2].split(":")[1].trim();
                int quantity = Integer.parseInt(catandval[3].split(":")[1].trim());
                double percent = Double.parseDouble(catandval[3].split(":")[1].trim().replace("%", "")) / 100;
                return new TaxType(taxName, description, quantity, percent);
            })
            .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temptaxList;
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


