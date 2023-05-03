package assignment1;

public class TaxType {
    private String taxName;
    private String description;
    private int quantity;
    private double percent;

    public TaxType(String taxName, String description, int quantity, double percent) {
        this.taxName = taxName;
        this.description = description;
        this.quantity = quantity;
        this.percent = percent;
    }

    public String getTaxName() {
        return taxName;
    }
    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return this.getTaxName();
    }
}

// Type: Tax
// Name: Default tax
// Description: general case
// Quantity available: 15
// Price: 10%
