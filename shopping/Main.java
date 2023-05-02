package shopping;

public class Main {
    public static void main(String[] args) {
        // Create some products
        DigitalProduct product1 = new DigitalProduct("Ebook - Java for Beginners", "Learn Java programming from scratch", 100, 29.99, TaxType.NORMAL_TAX);
        PhysicalProduct product2 = new PhysicalProduct("T-Shirt - Java Duke", "Get your geek on with this stylish T-Shirt", 50, 19.99, TaxType.NORMAL_TAX, 0.3);
        PhysicalProduct product3 = new PhysicalProduct("Book - Head First Java", "A fun way to learn Java programming", 25, 49.99, TaxType.NORMAL_TAX, 1.0);
    
        // Create some product items
        ProductItem item1 = new ProductItem(product1, 1, false, "");
        ProductItem item2 = new ProductItem(product2, 2, true, "Happy Birthday!");
        ProductItem item3 = new ProductItem(product3, 1, false, "");
    
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();
    
        // Add items to the cart
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
    
        // Apply a coupon
        Coupon coupon = new Coupon("Ebook - Java for Beginners", CouponType.PERCENTAGE, 20.0);
        cart.applyCoupon(coupon);
    
        // Print the receipt
        cart.printReceipt();
    }
    
}
