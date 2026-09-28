package lw01.unguided;

public class LaptopRental extends Rental {
    private int units;

    public LaptopRental(String id, int days, int units) {
        super(id, days);

        if (units <= 0) {
            throw new IllegalArgumentException();
        }

        this.units = units;
    }

    @Override
    public int calculateCharge() {
        return (getDays() * 40000) + (units * 10000);
    }

    @Override
    public String label() {
        return "Laptop";
    }
}