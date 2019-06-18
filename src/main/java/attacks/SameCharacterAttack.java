package attacks;
import character.Character;
public class SameCharacterAttack extends Attack{


	public SameCharacterAttack() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Character character,Character enemy) {
		// TODO Auto-generated method stub
		 if (character == enemy) {
			 return true;
		 }
		 return attackNext(character, enemy);
	}

}