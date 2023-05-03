package assignment1;

public class Product{
    private String type;
    private String name;
    private String description;
    private int available;
    private double price;
    private boolean CanBeGifted;

    public Product(String type, String name, String description, int available, double price, boolean CanBeGifted) {
        this.type = type;
        this.name = name; 
        this.description = description;
        this.available = available;
        this.price = price;
        this.CanBeGifted = CanBeGifted;
    }

    public Product(String name) {
        this.name = name;
        String description = getDescription();
    }

    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getAvailable() {
        return available;
    } 
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isCanBeGifted() {
        return CanBeGifted;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String type, String name, String description, int available, double price, boolean CanBeGifted ,double weight) {
        super(type, name, description, available, price, CanBeGifted);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "PHYSICAL - " + this.getName();
    }

}

class DigitalProduct extends Product {



    public DigitalProduct(String type, String name, String description, int available, double price, boolean CanBeGifted) {
        super(type, name, description, available, price, CanBeGifted);
    }

    @Override
    public String toString() {
        return "DIGITAL - " + this.getName();
    }
}



