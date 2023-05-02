package shopping;

public class ProductItem {

    private Product product;
    private int quantity;
    private boolean isGift;
    private String giftMessage;

    public ProductItem(Product product, int quantity, boolean isGift, String giftMessage) {
        this.product = product;
        this.quantity = quantity;
        this.isGift = isGift;
        this.giftMessage = giftMessage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage;
    }
}