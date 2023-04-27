public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String description, int quantity, double price, boolean canBeGifted, TaxType taxType, double weight) {
        super(name, description, quantity, price, canBeGifted, taxType);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        String name = getName();
        String des = getDescription();
        int quantity = getQuantity();
        double weight = getWeight();
        double price = getPrice();
        // double price =getPrice();
        return "\n\t Physical - " + name + "\n\t Description: " + des + "\n\t " + quantity + " is in stock!\n\t The weight of your product is "+ weight+" kg\n The price for each is: "+ price + " VND\n" ;
              
      }
      static PhysicalProduct phys = new PhysicalProduct("Ford","This is a car",  2, 200000, true, TaxType.TAX_FREE, 2000);
}
