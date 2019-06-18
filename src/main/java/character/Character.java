package character;

import java.util.ArrayList;

import attacks.*;
import fighter.*;

public class Character {

	private int health;
	private int level;
	private int attack;
	private Coordinates position;
	private Fighter type;
	private ArrayList <String> factions;
	public static final int MAX_HEALTH = 1000;

	public Character() {
		this.health = MAX_HEALTH;
		this.level = 1;
		this.position = new Coordinates();
		this.type = new Melee();
		this.factions = new ArrayList<>();
	}

	
	public ArrayList<String> getFactions() {
		return factions;
	}

	public void addFaction(String faction) {
		factions.add(faction);
	}
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (this.health > 0) {
			if (health > MAX_HEALTH) {
				health = MAX_HEALTH;
			} else if (health < 0) {
				health = 0;
			}
			this.health = health;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isAlive() {
		return (health > 0);
	}

	public void attack(Character character) {
		Attack attack = new SameCharacterAttack();
		attack.linkWith(new IsAlliedAttack())
		.linkWith(new HaveRangeAttack())
		.linkWith(new HeHas5MoreLevelsAttack())
		.linkWith(new IHave5MoreLevelsAttack())
		.linkWith(new NormalAttack());
		
		attack.execute(this, character);
		/*if (this != character) {  //SameCharacter
			boolean haveEnoughRange = character.getPosition().getX() <= this.getPosition().getX() + this.getType().getRange();
			if (haveEnoughRange) { 
				boolean heHas5MoreLevels = (character.getLevel() - 5) >= this.getLevel();
				boolean IHave5MoreLevels = (this.getLevel() - 5) >= character.getLevel();

				if (heHas5MoreLevels) {
					character.setHealth(character.getHealth() - (this.attack / 2));
				} else if (IHave5MoreLevels) {
					character.setHealth(character.getHealth() - (this.attack + (this.attack / 2)));
				} else { //NormalAttack
					character.setHealth(character.getHealth() - this.attack);
				}
			}
		}*/
	}


	public void heal(int heal) {
		this.setHealth(this.getHealth() + heal);
	}

	public void heal(Character character, int heal) {
		for (String faction : this.getFactions()) {
			if (character.getFactions().contains(faction)) {
				character.setHealth(character.getHealth() + heal);
				break;
			}
		}	
	}
	
	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public Fighter getType() {
		return type;
	}

	public void setType(Fighter type) {
		this.type = type;
	}

}
