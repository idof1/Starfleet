package starfleet;

public class Cylon extends myAbstractvCrewMember {

	private int modelNumber;
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age,yearsInService,name);
		this.modelNumber=modelNumber;
	}

	public int getModelNumber() {
		return this.modelNumber;
	}

	@Override
	public String toString() {
		String str=super.toString();
		return str+="\n\t Model Number="+this.modelNumber;

	}
}
