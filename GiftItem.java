package Sepm_group;
public class GiftItem extends Item {
    private String message;

    public GiftItem(Product product, int quantity, String message) {
        super(product, quantity);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
