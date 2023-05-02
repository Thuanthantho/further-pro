package shopping;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ShoppingCart {

    private List<ProductItem> items;
    private Coupon coupon;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(ProductItem item) {
        int quantityAvailable = item.getProduct().getQuantityAvailable();
        if (quantityAvailable < item.getQuantity()) {
            return false;
        }
        item.getProduct().setQuantityAvailable(quantityAvailable - item.getQuantity());
        items.add(item);
        return true;
    }

    public boolean removeItem(ProductItem item) {
        boolean result = items.remove(item);
        if (result) {
            int quantityAvailable = item.getProduct().getQuantityAvailable();
            item.getProduct().setQuantityAvailable(quantityAvailable + item.getQuantity());
        }
        return result;
    }

    public double getTotalCost() {
        double total = 0.0;
        for (ProductItem item : items) {
            double tax = item.getProduct().getPrice() * item.getQuantity() * item.getProduct().getTaxType().getRate();
            total += item.getProduct().getPrice() * item.getQuantity() + tax;
        }
        if (coupon != null) {
            switch (coupon.getType()) {
                case PRICE:
                    total -= coupon.getValue();
                    break;
                case PERCENTAGE:
                    total *= 1 - (coupon.getValue() / 100);
                    break;
            }
        }
        double weight = 0.0;
        for (ProductItem item : items) {
            if (item.getProduct() instanceof PhysicalProduct) {
                weight += ((PhysicalProduct)item.getProduct()).getWeight() * item.getQuantity();
            }
        }
        total += weight * 0.1;
        return total;
    }

    public void applyCoupon(Coupon coupon) {
        if (coupon == null) {
            this.coupon = null;
            return;
        }
        for (ProductItem item : items) {
            if (item.getProduct().getName().equals(coupon.getIdentifier())) {
                this.coupon = coupon;
                return;
            }
        }
        throw new IllegalArgumentException("Coupon cannot be applied");
    }

    public void printReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("---------------------PURCHASE RECEIPT---------------------");
        System.out.printf("| %-30s | %10s | %10s | %10s | %10s |\n", "ITEM", "PRICE", "QUANTITY", "TAX", "TOTAL");
        for (ProductItem item : items) {
            double tax = item.getProduct().getPrice() * item.getQuantity() * item.getProduct().getTaxType().getRate();
            double total = item.getProduct().getPrice() * item.getQuantity() + tax;
            if (coupon != null && item.getProduct().getName().equals(coupon.getIdentifier())) {
                switch (coupon.getType()) {
                    case PRICE:
                        total -= coupon.getValue();
                        break;
                    case PERCENTAGE:
                        total *= 1 - (coupon.getValue() / 100);
                        break;
                }
            }
            System.out.printf("| %-30s | %,10.2f | %10d | %,10.2f | %,10.2f |\n",
                    item.getProduct().getName(), item.getProduct().getPrice(),
                    item.getQuantity(), tax, total);
        }
        double weight = 0.0;
        for (ProductItem item : items) {
            if (item.getProduct() instanceof PhysicalProduct) {
                weight += ((PhysicalProduct)item.getProduct()).getWeight() * item.getQuantity();
            }
        }
        double shippingFee = weight * 0.1;
        System.out.printf("| %-30s | %10s |\n", "SHIPPING FEE", String.format("%,10.2f", shippingFee));
        System.out.printf("| %-30s | %10s |\n", "", "");
        double totalCost = getTotalCost();
        System.out.printf("| %-30s | %10s |\n", "TOTAL COST", String.format("%,10.2f", totalCost));
        System.out.printf("| %-30s | %10s |\n", "", "");
        System.out.printf("| %-30s | %-30s |\n", "PURCHASE DATE", dateFormat.format(new Date()));
        System.out.println("-----------------------------------------------------------");
    }
}
