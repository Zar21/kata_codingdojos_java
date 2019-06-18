package attacks;

import character.Character;

public class IHave5MoreLevelsAttack extends Attack {
	
	@Override
	public boolean execute(Character character, Character enemy) {
		// TODO Auto-generated method stub
		if ((character.getLevel() - 5) >= enemy.getLevel()) {
			enemy.setHealth(enemy.getHealth() - (character.getAttack() + (character.getAttack() / 2)));
			return true;
		}
		return attackNext(character, enemy);
	}

}
