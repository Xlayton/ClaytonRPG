package info.claytonschrumpf_abstract.entity;

public abstract class Monster extends Entity {

  private final Race race;
  private final int level;

  private int[] stats;

  public Monster(
      int strength,
      int dexterity,
      int constitution,
      int intellect,
      int wisdom,
      int charisma,
      int level,
      String name,
      Race race) {
    super(strength, dexterity, constitution, intellect, wisdom, charisma, name);
    this.race = race;
    this.stats = makeStatBlock();
    this.level = level;
  }

  public int[] getStatBlock() {
    return stats;
  }

  public Race getRace() {
    return race;
  }

  public int getLevel() {
    return level;
  }
  
  public abstract int attack();
}
