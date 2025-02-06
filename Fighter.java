package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractSpaceship {

    protected List<Weapon> weapons;

    public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
        for (Weapon weapon : this.weapons) {
            this.firePower += weapon.getFirePower();
        }
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }
    @Override
    public int getAnnualMaintenanceCost() {
        return this.getWeaponCost() + (int) Math.floor(1000 * this.maximalSpeed) + 2500;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tWeapons=" + weapons;
    }

    protected int getWeaponCost() {
        int cost = 0;
        for (Weapon weapon : this.weapons) {
            cost += weapon.getAnnualMaintenanceCost();
        }
        return cost;
    }
}
