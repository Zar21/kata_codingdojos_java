package fighter;

public class Melee implements Fighter{

	private int range=2;
	
	@Override
	public int getRange() {
		return this.range;
		
	}
}
