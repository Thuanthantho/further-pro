package Sepm_group;
public abstract class Coupon {
    private String productCode;
    private String couponCode;

    public Coupon(String productCode, String couponCode) {
        this.productCode = productCode;
        this.couponCode = couponCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getCouponCode() {
        return couponCode;
    }
}
