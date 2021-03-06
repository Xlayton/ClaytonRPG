package info.claytonschrumpf_entity.character;

import java.util.ArrayList;
import info.claytonschrumpf_abstract.entity.Character;
import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_abstract.item.Item;

public class PlayableCharacter extends Character {

	private ArrayList<Item> inventory;
	private int balance;
	private int hp;
	private int xp;
	private int xpForNextLevel;
	private int xpToNextLevel;
	private int statPoints;

	public PlayableCharacter(int strength, int dexterity, int constitution, int intellect, int wisdom, int charisma,
			int level, String name, Race race) {
		super(strength, dexterity, constitution, intellect, wisdom, charisma, level, name, race);
		inventory = new ArrayList<>();
		statPoints = 27;
		xpForNextLevel = 100;
	}

	public int getStatPoints() {
		return statPoints;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int toSet) {
		balance = toSet;
	}

	public void subtractBalance(int toSubtract) throws ArithmeticException {
		if (this.getBalance() < toSubtract) {
			throw new ArithmeticException("Insufficient funds");
		} else {
			this.balance -= toSubtract;
		}
	}

	public void addBalance(int toAdd) {
		this.balance += toAdd;
	}

	public void addInventory(Item toAdd) {
		inventory.add(toAdd);
	}

	public void removeInventory(Item toRemove) {
		inventory.remove(toRemove);
	}

	public void buyItem(int cost, Item toBuy) throws ArithmeticException {
		subtractBalance(cost);
		addInventory(toBuy);
	}

	public void sellItem(int cost, Item toSell) {
		addBalance(cost / 2);
		removeInventory(toSell);
	}
	
	public void takeDamage(int amtToTake) {
		if(amtToTake > this.hp) {
			throw new IllegalArgumentException("Your dead");
		} else {
			this.hp -= amtToTake;
		}
	}

	public void checkLevelUp() {
		xpToNextLevel = xpForNextLevel - xp;
		if (xpToNextLevel <= 0) {
			addLevel();
			xp -= xpForNextLevel;
			xpToNextLevel *= 2;
		}
	}
}
