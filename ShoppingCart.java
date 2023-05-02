package assignment1;

import java.io.*;
import java.util.*;

public class ShoppingCart {
    private List<ProductItem> currentCart;
    private Coupon coupon;

    public ShoppingCart(List<ProductItem> currentCart, Coupon coupon){
        this.currentCart = currentCart;
        this.coupon = coupon;
    }

    public void setCurrentCart(List<ProductItem> currentCart) {
        this.currentCart = currentCart;
    }
    public List<ProductItem> getCurrentCart() {
        return currentCart;
    }
    public Coupon getCoupon() {
        return coupon;
    }

    public void addItem() throws IOException {
        
    }

    public void removeItem() {

    }

    public void EditItem() throws IOException {
        
    } 

    public void applyCoupon() {

    }

    public double calculateTotalAmount() {
        return;
    }

    public void printReceipt() {

    }

    public double shippingfee() {
        return;
    }

    public void sortCart() {
        
    }
}
