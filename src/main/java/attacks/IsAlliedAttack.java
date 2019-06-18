package attacks;

import character.Character;

public class IsAlliedAttack extends Attack {

	@Override
	public boolean execute(Character character, Character enemy) {
		// TODO Auto-generated method stub

		for (String faction : character.getFactions()) {
			if (enemy.getFactions().contains(faction)) {
				return true;
			}
		}

		return attackNext(character, enemy);

	}

}
