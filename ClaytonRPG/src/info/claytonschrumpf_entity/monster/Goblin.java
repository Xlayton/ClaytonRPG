package info.claytonschrumpf_entity.monster;

import java.util.ArrayList;

import info.claytonschrumpf_abstract.entity.Monster;
import info.claytonschrumpf_abstract.entity.Race;

public class Goblin extends Monster {

  public Goblin(
      int strength,
      int dexterity,
      int constitution,
      int intellect,
      int wisdom,
      int charisma,
      int level,
      String name,
      Race race) {
    super(strength, dexterity, constitution, intellect, wisdom, charisma, level, name, race);
  }

  public Goblin(int[] statArray, int level, String name, Race race) {
    super(
        statArray[0],
        statArray[1],
        statArray[2],
        statArray[3],
        statArray[4],
        statArray[5],
        level,
        name,
        race);
    if (statArray.length != 5) {
      throw new IllegalArgumentException("statArray must have 5 values!");
    }
  }

  @Override
  public int initHP() {
    return (8 + this.getStatModifier(Stat.CONSTITUTION));
  }

  @Override
  public ArrayList<String> getRaceChoiceNames() {
    return null;
  }

  @Override
  protected void initRaceNames() {
    return;
  }

  @Override
  public int attack() {
	  return(roll(8) + this.getStatModifier(Stat.STRENGTH));
  }
}
