package info.claytonschrumpf_abstract.entity;

import java.util.ArrayList;

import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_race.character_race.CharacterRace;

public abstract class Character extends Entity {

  private final Race race;
  private int level;
  private final ArrayList<String> raceChoiceNames;
  private final EntityClass entityClass;

  private int[] stats;

  public Character(
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
    super(strength, dexterity, constitution, intellect, wisdom, charisma, name);

    this.race = race;
    this.stats = makeStatBlock();
    this.level = level;
    this.raceChoiceNames = new ArrayList<>();
    initRaceNames();
    this.entityClass = entityClass;
  }

  public int[] getStatBlock() {
    return stats;
  }
  
  public EntityClass getEntityClass() {
	  return entityClass;
  }

  public Race getRace() {
    return race;
  }

  public int getLevel() {
    return level;
  }

  public void addLevel() {
    level++;
  }

  @Override
  public ArrayList<String> getRaceChoiceNames() {
    return raceChoiceNames;
  }

  @Override
  protected void initRaceNames() {
    for (CharacterRace r : CharacterRace.values()) {
      raceChoiceNames.add(r.getName());
    }
  }

}
