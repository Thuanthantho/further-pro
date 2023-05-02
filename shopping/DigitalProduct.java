package shopping;

public class DigitalProduct extends Product {

    public DigitalProduct(String name, String description, int quantityAvailable, double price, TaxType taxType) {
        super(name, description, quantityAvailable, price, taxType);
    }

    @Override
    public String toString() {
        return "DIGITAL - " + this.name;
    }
}