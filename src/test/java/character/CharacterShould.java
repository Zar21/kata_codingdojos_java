package character;

import static org.junit.Assert.*; 

import org.junit.Test;

import example.BankAccount;
import fighter.Fighter;
import fighter.Melee;
import fighter.Ranged;

public class CharacterShould {

	@Test
	public void have_default_values() {

		Character character = new Character();
		assertEquals(1000, character.getHealth());
		assertEquals(1, character.getLevel());
	}
	
	@Test
	public void is_dead() {
		Character character = new Character();
		character.setHealth(0);
		assertEquals(false, character.isAlive());
	}

	@Test
	public void is_alive() {
		Character character = new Character();
		character.setHealth(10);
		assertEquals(true, character.isAlive());
	}
	
	@Test
	public void attack_other() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		character.attack(character2);
		assertEquals(990, character2.getHealth());
	}
	
	@Test
	public void heal_me() {
		Character character = new Character();
		character.setHealth(900);
		character.heal(10);
		assertEquals(910, character.getHealth());
	}
	
	@Test
	public void dont_pass_1000() {
		Character character = new Character();
		character.heal(10);
		assertEquals(1000, character.getHealth());
	}
	
	@Test
	public void dont_attack_me() {
		Character character = new Character();
		character.setAttack(10);
		character.attack(character);
		assertEquals(1000, character.getHealth());
	}
	
	@Test
	public void check_boosted_attack() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		character.setLevel(6);
		character.attack(character2);
		assertEquals(1000-15, character2.getHealth());
	}
	
	@Test
	public void check_reduced_attack() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		character2.setLevel(6);
		character.attack(character2);
		assertEquals(1000-5, character2.getHealth());
	}
	
	@Test
	public void check_attack_failed_melee() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		Coordinates coordinates = new Coordinates();
		coordinates.setX(2);
		Coordinates coordinates2 = new Coordinates();
		coordinates2.setX(5);
		Fighter fighter = new Melee();
		character.setType(fighter);
		character.setPosition(coordinates);
		character2.setPosition(coordinates2);
		character.attack(character2);
		assertEquals(1000, character2.getHealth());
	}
	
	@Test
	public void check_attack_success_melee() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		Coordinates coordinates = new Coordinates();
		coordinates.setX(2);
		Coordinates coordinates2 = new Coordinates();
		coordinates2.setX(4);
		Fighter fighter = new Melee();
		character.setType(fighter);
		character.setPosition(coordinates);
		character2.setPosition(coordinates2);
		character.attack(character2);
		assertEquals(990, character2.getHealth());
	}
	
	@Test
	public void check_attack_failed_ranged() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		Coordinates coordinates = new Coordinates();
		coordinates.setX(2);
		Coordinates coordinates2 = new Coordinates();
		coordinates2.setX(23);
		Fighter fighter = new Ranged();
		character.setType(fighter);
		character.setPosition(coordinates);
		character2.setPosition(coordinates2);
		character.attack(character2);
		assertEquals(1000, character2.getHealth());
	}
	
	@Test
	public void check_attack_success_ranged() {
		Character character = new Character();
		Character character2 = new Character();
		character.setAttack(10);
		Coordinates coordinates = new Coordinates();
		coordinates.setX(2);
		Coordinates coordinates2 = new Coordinates();
		coordinates2.setX(22);
		Fighter fighter = new Ranged();
		character.setType(fighter);
		character.setPosition(coordinates);
		character2.setPosition(coordinates2);
		character.attack(character2);
		assertEquals(990, character2.getHealth());
	}
	
	@Test
	public void dont_attack_your_friend() {
		Character character = new Character();
		Character character2 = new Character();
		character.addFaction("Combatientes");
		character.addFaction("Curadores");
		character2.addFaction("Combatientes");
		character.setAttack(10);
		Coordinates coordinates = new Coordinates();
		coordinates.setX(2);
		Coordinates coordinates2 = new Coordinates();
		coordinates2.setX(4);
		Fighter fighter = new Melee();
		character.setType(fighter);
		character.setPosition(coordinates);
		character2.setPosition(coordinates2);
		character.attack(character2);
		assertEquals(1000, character2.getHealth());
	}
	
	@Test
	public void attack_your_enemy() {
		Character character = new Character();
		Character character2 = new Character();
		character.addFaction("Combatientes");
		character.addFaction("Curadores");
		character2.addFaction("Magos");
		character.setAttack(10);
		Coordinates coordinates = new Coordinates();
		coordinates.setX(2);
		Coordinates coordinates2 = new Coordinates();
		coordinates2.setX(4);
		Fighter fighter = new Melee();
		character.setType(fighter);
		character.setPosition(coordinates);
		character2.setPosition(coordinates2);
		character.attack(character2);
		assertEquals(990, character2.getHealth());
	}
	
	@Test
	public void heal_your_friend() {
		Character character = new Character();
		Character character2 = new Character();
		character.addFaction("Combatientes");
		character.addFaction("Curadores");
		character2.addFaction("Combatientes");
		character2.setHealth(200);
		character.heal(character2, 100);
		assertEquals(300, character2.getHealth());
	}
	
	@Test
	public void dont_heal_your_enemy() {
		Character character = new Character();
		Character character2 = new Character();
		character.addFaction("Combatientes");
		character.addFaction("Curadores");
		character2.addFaction("Magos");
		character2.setHealth(200);
		character.heal(character2, 100);
		assertEquals(200, character2.getHealth());
	} 
}
