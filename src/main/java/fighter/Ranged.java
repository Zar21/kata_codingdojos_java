package fighter;

public class Ranged implements Fighter{

	private int range=20;
	
	
	@Override
	public int getRange() {
		return this.range;
		
	}

}
