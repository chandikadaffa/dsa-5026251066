package lw01.unguided;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int units = getUnits();
        int charge;

        if(days <= 3) {
            charge = (days*60000+20000)*units;
        }else {
            charge = (3*60000+20000)*units+((days-3)*45000)*units;
        }
        return charge;
    }

    @Override
    public String label() {
        return "Projector";
    }
    
}
