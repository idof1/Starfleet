package starfleet;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

    private static int counter;

    public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);
        counter++;
    }
    public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers) {
        super(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon("Laser Cannons", 10, 100)));
        counter++;
    }


    @Override
    public int getAnnualMaintenanceCost() {
        return super.getAnnualMaintenanceCost() +50*counter;
    }
}
