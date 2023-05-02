package assignment1;

import java.util.Scanner;


public class Product{
    private String type;
    private String name;
    private String description;
    private int available;
    private double price;

    public Product(String type, String name, String description, int available, double price) {
        this.type = type;
        this.name = name; 
        this.description = description;
        this.available = available;
        this.price = price;
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

    @Override
    public String toString() {
        return this.name;
    }

}

class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String description, int available, double price, double weight) {
        super(name, description, available, price);
        this.weight = weight;
    }

    @Override
    public String toString() {
        Product currentProduct = new Product(getName());
        return "PHYSICAL - " + currentProduct.getName();
    }
}

class DigitalProduct extends Product {



    public DigitalProduct(String name, String description, int available, double price) {
        super(name, description, available, price);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        Product currentProduct = new Product(getName());
        return "DIGITAL - " + currentProduct.getName();
    }
}


