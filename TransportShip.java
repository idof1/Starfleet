package starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship {

    private int cargoCapacity, passengerCapacity;

    public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tCargoCapacity=" + cargoCapacity +
                "\n\tpassengerCapacity=" + passengerCapacity;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return 3000 + 5 * this.cargoCapacity + 3 * this.passengerCapacity;
    }
}
