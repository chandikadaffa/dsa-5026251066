package lw01.unguided;

public class LaptopRental extends Rental {

    public LaptopRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int units = getUnits();
        return ((days*40000)+20000)*units;
    }

    @Override
    public String label() {
        return "Laptop";
    }
} 