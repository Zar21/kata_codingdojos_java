package attacks;

import character.Character;

public class NormalAttack extends Attack{

	@Override
	public boolean execute(Character character, Character enemy) {
		// TODO Auto-generated method stub
		enemy.setHealth(enemy.getHealth() - character.getAttack());
		return attackNext(character, enemy);
	}

}
