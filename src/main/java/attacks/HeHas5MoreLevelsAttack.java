package attacks;

import character.Character;

public class HeHas5MoreLevelsAttack extends Attack{

	@Override
	public boolean execute(Character character, Character enemy) {
		// TODO Auto-generated method stub
		if ((enemy.getLevel() - 5) >= character.getLevel()) {
			enemy.setHealth(enemy.getHealth() - (character.getAttack() / 2));
			return true;
		}
		return attackNext(character, enemy);
	}

}
