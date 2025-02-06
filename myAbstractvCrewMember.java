package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myAbstractvCrewMember implements CrewMember {
    protected String name;
    protected int age;
    protected int yearsInService;

    public myAbstractvCrewMember(int age,int yearsInService,String name){
        this.name=name;
        this.age=age;
        this.yearsInService=yearsInService;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getYearsInService() {
        return yearsInService;
    }

    @Override
    public String toString() {
        String str="";
        str+=this.getClass().getSimpleName();
        str+= "\n\t Name="+this.name;
        str+= "\n\t Age="+this.age;
        str+= "\n\t Yeas in Service="+this.yearsInService;

        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractvCrewMember that = (myAbstractvCrewMember) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
