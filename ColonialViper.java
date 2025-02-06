package starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {

    public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);

    }

    @Override
    public int getAnnualMaintenanceCost() {
        return getWeaponCost() + 4000 + this.crewMembers.size() * 500 +  (int) Math.floor(500*this.maximalSpeed) ;
    }
}
