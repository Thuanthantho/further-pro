package assignment1;

public class Coupon {
    public String CouponName;
    public double fixedDiscount;
    public double percentDiscount;

    public Coupon(String CouponName, double fixedDiscount, double percentDiscount){
        this.CouponName = CouponName;
        this.fixedDiscount = fixedDiscount;
        this.percentDiscount = percentDiscount;
    }
}
