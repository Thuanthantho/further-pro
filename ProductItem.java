package assignment1;

import java.util.Scanner;

public class ProductItem extends Product{
    private int amount;
    private boolean isGift;
    private String message;


    public ProductItem(String name, String description, int available, double price) {
        super(name, description, available, price);
    }

    public ProductItem(String message) {
        super(message);
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setGift(boolean isGift) {
        this.isGift = isGift;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String GiftMessage(String message){
        ProductItem currentProductItem = new ProductItem(message);
        if (message == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What would you like to send?");
            String newmessage = scanner.nextLine();
            System.out.println("Your current message is: " + newmessage);
            System.out.println("Are you sure with your message?");
            Scanner scanner2 = new Scanner(System.in);
            String confirmation = scanner.nextLine();
            scanner.flush();
            System.out.println("");
            message = newmessage;
            return message;
        } else {
            return message;
        }
    }

}