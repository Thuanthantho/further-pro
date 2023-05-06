package assignment1;

import java.io.IOException;
import java.util.Scanner;

public class ProductItem extends Product{
    private int amount;
    private String message;


    public ProductItem(String type, String name, String description, int available, double price, boolean CanBeGifted) {
        super(type, name, description, available, price, CanBeGifted);
    }

    public ProductItem(String name, int amount, String message) {
        super(name);
        this.amount = amount;
        this.message = message;
    }

    public ProductItem(String name) {
        super(name);
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void GiftMessage(ProductItem currentProductItem) throws IOException{ // find the Product first and then check if want a message or not
                                                                                // maybe leave it for the shopping cart to pick the index
        if (currentProductItem.getMessage() == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What message would you like to send?");
            String message = scanner.nextLine();
            System.out.println("Your current message is: " + message);
            System.out.println("Are you sure? (Yes/No)");
            Scanner scanner2 = new Scanner(System.in);
            String confirmation = scanner2.nextLine();
            if (confirmation.trim().equalsIgnoreCase("Yes")) {
                currentProductItem.setMessage(message);
            } else if (confirmation.trim().equalsIgnoreCase("No")) {
                scanner.close();
                scanner2.close();
                GiftMessage(currentProductItem);
            } else {
                System.out.println("Invalid input!!");
                scanner.close();
                scanner2.close();
                GiftMessage(currentProductItem);
            }
        } else {
            System.out.println("This item is currently attached with a message: " + currentProductItem.getMessage());
            System.out.println("Would you like to change or remove the message (enter \"no\" if you don't want to change)?");
            Scanner scanner = new Scanner(System.in);
            String change = scanner.nextLine();
            if (change.trim().equalsIgnoreCase("change")) {
                System.out.println("What is your new message?");
                Scanner newmessage = new Scanner(System.in);
                newmessage.nextLine();
                String message = "" + newmessage;
                currentProductItem.setMessage(message);
                newmessage.close();
                GiftMessage(currentProductItem);
            } else if (change.trim().equalsIgnoreCase("remove")) {
                String message = null;
                currentProductItem.setMessage(message);
                scanner.close();
                GiftMessage(currentProductItem);
            } else if (change.trim().equalsIgnoreCase("no")) {
                scanner.close();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAmount();
    }

}