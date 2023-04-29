package Sepm_group;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Product> products;
    private List<ShoppingCart> shoppingCarts;

    public OnlineShoppingService() {
        this.products = new ArrayList<>();
        this.shoppingCarts = new ArrayList<>();
    }

    // Add a new product to the service
    public void addProduct(Product product) {
        this.products.add(product);
        Product.subtract();
    }

    // Get all products in the service
    public List<Product> getProducts() {
        return this.products;
    }

    // Get a product by its name
    public Product getProductByName(String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    // Remove a product from the service
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    // Create a new shopping cart
    public ShoppingCart createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        this.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }

    // Get all shopping carts in the service
    public List<ShoppingCart> getShoppingCarts() {
        return this.shoppingCarts;
    }

    // Get a shopping cart by its ID
    public ShoppingCart getShoppingCartById(int id) {
        for (ShoppingCart shoppingCart : this.shoppingCarts) {
            if (shoppingCart.getId() == id) {
                return shoppingCart;
            }
        }
        return null;
    }

    // Remove a shopping cart from the service
    public void removeShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCarts.remove(shoppingCart);
    }

    // Apply a coupon to a shopping cart
    public void applyCoupon(ShoppingCart shoppingCart, Coupon coupon) {
        shoppingCart.applyCoupon(coupon);
    }

    // Calculate the total amount a customer has to pay for a shopping cart
    public double calculateTotalAmount(ShoppingCart shoppingCart) {
        return shoppingCart.calculateTotalAmount();
    }

    // Print a purchase receipt for a shopping cart
    public void printPurchaseReceipt(ShoppingCart shoppingCart) {
        shoppingCart.printPurchaseReceipt();
    }

    public static void main(String[] args) {
        pro1 = DigitalProduct.dig1;
        addProduct(Product pro1)









        System.print.out("Show products");
        System.print.out(products);
        System.print.out(shoppingCarts);
    }
}