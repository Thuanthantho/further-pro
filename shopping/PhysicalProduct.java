package shopping;

public class PhysicalProduct extends Product {

    private double weight;

    public PhysicalProduct(String name, String description, int quantityAvailable, double price, TaxType taxType, double weight) {
        super(name, description, quantityAvailable, price, taxType);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PHYSICAL - " + this.name;
    }
}