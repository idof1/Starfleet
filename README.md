# Starfleet Management System

This project implements an **Object-Oriented Java system** for managing a fleet of spaceships and crew members. It showcases principles such as **inheritance, polymorphism, and encapsulation**.

## Features
- 🚀 **Manage multiple spaceship types** (e.g., Fighters, Bombers, Transport Ships, Stealth Cruisers).
- 👩‍🚀 **Crew member hierarchy** (Officers, Crew Members, Cylons, etc.).
- 🔫 **Weapon and firepower calculations**.
- 📊 **Fleet-wide statistics processing** using `StarfleetManager`.
- ✅ **Automated testing via `StarfleetManagerTester.java`**.

## Project Structure
```
src/
│── riddles/               # Other exercises (not directly related to the fleet system)
│── starfleet/             # Core fleet management system
│   ├── Bomber.java       # Spaceship subclass
│   ├── ColonialViper.java
│   ├── CylonRaider.java
│   ├── Fighter.java
│   ├── StealthCruiser.java
│   ├── TransportShip.java
│   ├── Spaceship.java    # Main spaceship superclass
│   ├── myAbstractSpaceship.java
│   ├── CrewMember.java   # Abstract crew hierarchy
│   ├── CrewWoman.java
│   ├── Cylon.java
│   ├── myAbstractCrewMember.java
│   ├── Officer.java
│   ├── OfficerRank.java  # Enum defining officer ranks
│   ├── Weapon.java       # Weapon class
│   ├── StarfleetManager.java  # Central fleet manager
│   ├── StarfleetManagerTester.java # Test cases
```

## Installation & Compilation
1. **Clone the repository**
```bash
git clone https://github.com/yourusername/starfleet-management.git
cd starfleet-management
```

2. **Compile the project**
```bash
javac -d out -sourcepath src src/starfleet/*.java
```

3. **Run the test suite**
```bash
java -cp out starfleet.StarfleetManagerTester
```

## Example Usage
The `StarfleetManager` class provides utilities to analyze and manage the fleet. Example:

```java
List<Spaceship> fleet = new ArrayList<>();
fleet.add(new Fighter("X-Wing", 2, 100));
fleet.add(new Bomber("B-2", 4, 300));

StarfleetManager manager = new StarfleetManager();
int totalFirepower = manager.getTotalFirepower(fleet);
System.out.println("Total fleet firepower: " + totalFirepower);
```

## License
This project is licensed under the MIT License. See `LICENSE` for details.

---
🚀 **Happy coding and may the force be with you!**

