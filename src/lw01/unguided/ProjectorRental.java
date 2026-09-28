package lw01.unguided;

public class ProjectorRental extends Rental {
    private int units;

    public ProjectorRental(String id, int days, int units) {
        super(id, days);

        if (units <= 0) {
            throw new IllegalArgumentException();
        }

        this.units = units;
    }

    @Override
    public int calculateCharge() {
        int charge;

        if (getDays() <= 3) {
            charge = getDays() * 60000;
        } else {
            charge = (3 * 60000) + ((getDays() - 3) * 45000);
        }

        return charge + (units * 20000);
    }

    @Override
    public String label() {
        return "Projector";
    }
}