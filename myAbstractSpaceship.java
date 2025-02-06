package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship, Comparable<Spaceship> {

    protected String name;
    protected int commissionYear, firePower;
    protected float maximalSpeed;
    protected Set<? extends CrewMember> crewMembers;

    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
        this.name = name;
        this.commissionYear = commissionYear;
        this.firePower = 10;
        this.crewMembers = crewMembers;
        this.maximalSpeed = maximalSpeed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCommissionYear() {
        return commissionYear;
    }

    @Override
    public int getFirePower() {
        return firePower;
    }

    @Override
    public abstract int getAnnualMaintenanceCost();

    @Override
    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\n\tName=" + name +
                "\n\tCommissionYear=" + commissionYear +
                "\n\tMaximalSpeed=" + maximalSpeed +
                "\n\tFirePower=" + firePower +
                "\n\tCrewMembers=" + crewMembers.size() +
                "\n\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractSpaceship that = (myAbstractSpaceship) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Spaceship o2) {
        if (this.getFirePower() < o2.getFirePower()) {
            return 1;
        } else if (this.getFirePower() > o2.getFirePower()) {
            return -1;
        } else {
            if (this.getCommissionYear() < o2.getCommissionYear()) {
                return 1;
            } else if (this.getCommissionYear() > o2.getCommissionYear()) {
                return -1;
            } else {
                return this.getName().compareTo(o2.getName());
            }
        }
    }
}


