package info.claytonschrumpf_entity.character;

import java.util.ArrayList;
import java.util.Random;

import info.claytonschrumpf_abstract.entity.Character;
import info.claytonschrumpf_abstract.entity.EntityClass;
import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_abstract.item.Item;

public class PlayableCharacter extends Character {

  private final Random rand;
  private final ArrayList<Item> inventory;

  private int balance;
  private int xp;
  private int xpForNextLevel;
  private int xpToNextLevel;
  private int statPoints;
  

  public PlayableCharacter(
      int strength,
      int dexterity,
      int constitution,
      int intellect,
      int wisdom,
      int charisma,
      int level,
      String name,
      Race race,
      EntityClass entityClass) {
    super(
        strength,
        dexterity,
        constitution,
        intellect,
        wisdom,
        charisma,
        level,
        name,
        race,
        entityClass);
    statPoints = 27;
    xpForNextLevel = 100;
    rand = new Random();
    inventory = new ArrayList<>();
    this.setHP(initHP());
  }

  public int getStatPoints() {
    return statPoints;
  }

  public void subtractStatPoint() {
    statPoints--;
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

  public void moveCharacter() {}

  public void checkLevelUp() {
    xpToNextLevel = xpForNextLevel - xp;
    if (xpToNextLevel <= 0) {
      addLevel();
      xp -= xpForNextLevel;
      xpToNextLevel *= 2;
    }
  }

  public enum Direction {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West");

    String str;

    private Direction(String str) {
      this.str = str;
    }

    @Override
    public String toString() {
      return str;
    }
  }

  @Override
  public int initHP() {
	 return this.getEntityClass().getHitDie() + getStatModifier(Stat.CONSTITUTION);
  }
}
