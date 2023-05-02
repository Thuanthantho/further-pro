public class DigitalProduct extends Product {

    public DigitalProduct(String name, String description, int quantity, double price, boolean canBeGifted, TaxType taxType) {
        super(name, description, quantity, price, canBeGifted, taxType);
    }

    @Override
    public String toString() {
        String name = getName();
        String des = getDescription();
        int quantity = getQuantity();
        double price = getPrice();
        // double price = getPrice();
        return " DIGITAL - " + name + "\n\t Description: " + des + "\n\t " + quantity + " is in stock!\n THe price or each is: " + price + "VND\n"; 
              
      }

      static  DigitalProduct dig1 = new DigitalProduct("Galaxy","this is a drawing of a galaxy",  1, 100000, true, TaxType.TAX_FREE);
      static  DigitalProduct dig2 = new DigitalProduct("XiaoMi","this is a drawing of a XiaoMi",  2, 200000, false,TaxType.TAX_FREE);
}
