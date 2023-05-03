package assignment1;

public class Coupon {
    private String CouponName;
    private String description;
    private int quantity;
    private double fixedDiscount;
    private double percentDiscount;
    

    public Coupon(String CouponName, String description, int quantity, double fixedDiscount, double percentDiscount){
        this.CouponName = CouponName;
        this.description = description;
        this.quantity = quantity;
        this.fixedDiscount = fixedDiscount;
        this.percentDiscount = percentDiscount;
    }

    public String getCouponName() {
        return CouponName;
    }
    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getFixedDiscount() {
        return fixedDiscount;
    }
    public double getPercentDiscount() {
        return percentDiscount;
    }

    @Override
    public String toString() {
        return this.getCouponName();
    }
    
}
