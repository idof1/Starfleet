package starfleet;

public class Officer extends CrewWoman {
	private OfficerRank rank;
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age,yearsInService,name);
		this.rank=rank;
	}
	
	public OfficerRank getRank(){
		return this.rank;
	}

	@Override
	public String toString() {
		String str=super.toString();
		return str+="\n\t Rank:"+this.rank;

	}
}
