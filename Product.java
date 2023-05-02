public abstract class Product {
    private String name;
    private String description;
    private int quantity;
    private double price;
    private boolean canBeGifted;
    private TaxType taxType;

    public Product(String name, String description, int quantity, double price, boolean canBeGifted, TaxType taxType) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.canBeGifted = canBeGifted;
        this.taxType = taxType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean canBeGifted() {
        return canBeGifted;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public abstract String toString();

    public double getTaxAmount() {
        switch (taxType) {
            case TAX_FREE:
                return 0;
            case NORMAL_TAX:
                return price * 0.1;
            case LUXURY_TAX:
                return price * 0.2;
            default:
                return 0;
        }
    }
}

enum TaxType {
    TAX_FREE,
    NORMAL_TAX,
    LUXURY_TAX
}
