package shopping;

public abstract class Product {
    protected String name;
    protected String description;
    protected int quantityAvailable;
    protected double price;
    protected TaxType taxType;

    public Product(String name, String description, int quantityAvailable, double price, TaxType taxType) {
        this.name = name;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.taxType = taxType;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getQuantityAvailable() {
        return this.quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TaxType getTaxType() {
        return this.taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public abstract String toString();
}
