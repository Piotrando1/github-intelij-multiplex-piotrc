package multiplex;

public enum SeatStandard {

    DISABLED(15.00),
    SUPER_PROMO(19.90),
    PROMO(26.90),
    VIP(44.90),
    STANDARD(34.90);

    private final double basePrice;

    SeatStandard(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}