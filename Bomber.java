package starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Fighter {

    private int numberOfTechnicians;

    public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians) {
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);
        this.numberOfTechnicians = numberOfTechnicians;
    }

    public int getNumberOfTechnicians() {
        return numberOfTechnicians;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        int cost = 0;
        return (int) Math.round((this.numberOfTechnicians * 0.1) * this.getWeaponCost()) + 5000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tNumberOfTechnicians=" + numberOfTechnicians;
    }

}
