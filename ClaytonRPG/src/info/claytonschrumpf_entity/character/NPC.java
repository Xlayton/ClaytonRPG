package info.claytonschrumpf_entity.character;

import info.claytonschrumpf_abstract.entity.Character;
import info.claytonschrumpf_abstract.entity.Race;

public class NPC extends Character {

  public NPC(
      int strength,
      int dexterity,
      int constitution,
      int intellect,
      int wisdom,
      int charisma,
      int level,
      String name,
      Race race) {
    super(strength, dexterity, constitution, intellect, wisdom, charisma, level, name, race, null);
  }

  @Override
  public int initHP() {
    // TODO Auto-generated method stub
    return 0;
  }
}
