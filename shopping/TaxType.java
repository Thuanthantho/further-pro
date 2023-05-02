package shopping;

public enum TaxType {
    TAX_FREE(0.0), NORMAL_TAX(0.10), LUXURY_TAX(0.20);

    private final double rate;

    private TaxType(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
