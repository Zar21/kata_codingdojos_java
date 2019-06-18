package attacks;
import character.Character;
public class HaveRangeAttack extends Attack {

	@Override
	public boolean execute(Character character, Character enemy) {
		// TODO Auto-generated method stub
		if (enemy.getPosition().getX() <= character.getPosition().getX() + character.getType().getRange()) {
			return attackNext(character, enemy);
		}
		return true;
	}
	
}
