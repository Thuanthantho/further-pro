package assignment1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Coupon {
    private String CouponName;
    private String description;
    private int quantity;
    private double discount;
    

    public Coupon(String CouponName, String description, int quantity, double discount){
        this.CouponName = CouponName;
        this.description = description;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Coupon() {
        this.CouponName = "";
        this.description = "";
        this.quantity = 0;
        this.discount = 0;
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
    public double getDiscount() {
        return discount;
    }

    public void applyProductCoupon(List<Coupon> couponList) {

        List<Coupon> productCoupons = couponList.stream()
        .filter(coupon -> !coupon.getCouponName().contains("Shipping"))
        .collect(Collectors.toList()); // filter Product Coupons

        System.out.println("These are currently coupons you can apply: ");
        IntStream.range(0, productCoupons.size())
        .forEach(i -> System.out.println((i + 1) + ". " + productCoupons.get(i)));

        System.out.println("Which coupon would you like to apply? (Pick by its number)");
        Scanner scanner = new Scanner(System.in);
        try {
            int choose = scanner.nextInt();
            if (choose > 0 && choose <= productCoupons.size()) {
                

                
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!!");
            applyProductCoupon(couponList);
        }
    }

    public void applyShippingCoupon(List<Coupon> couponList) {
        List<Coupon> shippingCoupons = couponList.stream()
        .filter(coupon -> coupon.getCouponName().contains("Shipping"))
        .collect(Collectors.toList()); // filter Shipping Coupons

        System.out.println("These are currently coupons you can apply: ");
        IntStream.range(0, shippingCoupons.size())
        .forEach(i -> System.out.println((i + 1) + ". " + shippingCoupons.get(i)));

        System.out.println("Which coupon would you like to apply? (Pick by its number)");
        Scanner scanner = new Scanner(System.in);
        try {
            int choose = scanner.nextInt();
            if (choose > 0 && choose <= shippingCoupons.size()) {
                


            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!!");
            applyShippingCoupon(couponList);
        }
    }

    @Override
    public String toString() {
        return this.getCouponName() + " - Quantity: " + this.getQuantity();
    }
    
}
