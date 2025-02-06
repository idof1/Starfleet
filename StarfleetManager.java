package starfleet;


import java.util.*;


public class StarfleetManager {

    /**
     * Returns a list containing string representation of all fleet ships, sorted in descending order by
     * fire power, and then in descending order by commission year, and finally in ascending order by
     * name
     */
    public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
        List<myAbstractSpaceship> lst = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (Spaceship spaceship : fleet) {
            lst.add((myAbstractSpaceship) spaceship);
        }
        Collections.sort(lst);
        for (Spaceship spaceship : lst) {
            String str = spaceship.toString();
            names.add(str);
        }
        return names;
    }

    /**
     * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
     */
    public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
        Map<String, Integer> catalog = new HashMap<>();
        for (Spaceship spaceship : fleet) {
            if (catalog.containsKey(spaceship.getClass().getSimpleName())) {
                catalog.put(spaceship.getClass().getSimpleName(), catalog.get(spaceship.getClass().getSimpleName()) + 1);
            } else {
                catalog.put(spaceship.getClass().getSimpleName(), 1);
            }
        }
        return catalog;
    }


    /**
     * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
     */
    public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
        int cnt = 0;
        for (Spaceship spaceship : fleet) {
            cnt += spaceship.getAnnualMaintenanceCost();
        }
        return cnt;

    }


    /**
     * Returns a set containing the names of all the fleet's weapons installed on any ship
     */
    public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
        Set<String> weapons = new HashSet<>();
        for (Spaceship spaceship : fleet) {
            if (spaceship instanceof Fighter)
                for (Weapon weapon : ((Fighter) spaceship).getWeapons()) {
                    weapons.add(weapon.getName());
                }
        }
        return weapons;
    }

    /*
     * Returns the total number of crew-members serving on board of the given fleet's ships.
     */
    public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
        int count = 0;
        for (Spaceship spaceship : fleet) {
            count += spaceship.getCrewMembers().size();
        }
        return count;

    }

    /*
     * Returns the average age of all officers serving on board of the given fleet's ships.
     */
    public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
        float cnt = 0, ages = 0;
        for (Spaceship spaceship : fleet) {
            for (CrewMember crewMember : spaceship.getCrewMembers()) {
                if (crewMember instanceof Officer) {
                    cnt++;
                    ages += ((Officer) crewMember).age;
                }
            }
        }
        return ages / cnt;
    }

    /*
     * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
     */
    public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
        Map<Officer, Spaceship> seniors = new HashMap<>();
        for (Spaceship spaceship : fleet) {
            Officer senior = null;
            for (CrewMember crewMember : spaceship.getCrewMembers()) {
                if (crewMember instanceof Officer s1) {
                    if (senior == null) {
                        senior = s1;
                    } else {
                        if (senior.getRank().compareTo(s1.getRank()) < 0) {
                            senior = s1;
                        }
                    }
                }
            }
            if (senior != null) {
                seniors.put(senior, spaceship);
            }
        }
        return seniors;
    }

        /*
         * Returns a List of entries representing ranks and their occurrences.
         * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
         * The returned list is sorted ascendingly based on the number of occurrences.
         */
        public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity
        (Collection < Spaceship > fleet) {
            HashMap<OfficerRank, Integer> ranks = new HashMap<>();
            for (Spaceship spaceship : fleet) {
                for (CrewMember crewMember : spaceship.getCrewMembers()) {
                    if (crewMember instanceof Officer) {
                        if (ranks.containsKey(((Officer) crewMember).getRank())) {
                            ranks.put(((Officer) crewMember).getRank(), ranks.get(((Officer) crewMember).getRank()) + 1);
                        } else {
                            ranks.put(((Officer) crewMember).getRank(), 1);
                        }
                    }
                }
            }

            List<Map.Entry<OfficerRank, Integer>> sort = new ArrayList<>(ranks.entrySet().stream().toList());
            sort.sort(new EntryCompere());
            return sort;
        }

        public static class EntryCompere implements Comparator<Map.Entry<OfficerRank, Integer>> {
            @Override
            public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        }
    }
