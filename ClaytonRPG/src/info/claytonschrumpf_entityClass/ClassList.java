package info.claytonschrumpf_entityClass;

import info.claytonschrumpf_abstract.entity.EntityClass;
import info.claytonschrumpf_abstract.entity.EntityClass.AttackType;
import info.claytonschrumpf_consoleIO.EnumMenuSelection;

public enum ClassList implements EnumMenuSelection {
  FIGHTER("Fighter", new Fighter(10, "Fighter", AttackType.PHYSICAL)),
  ROGUE("Rogue", new Rogue(8, "Rogue", AttackType.PHYSICAL)),
  WIZARD("Wizard", new Wizard(6, "Wizard", AttackType.MAGICAL));

  String name;
  EntityClass entityClass;

  private ClassList(String name, EntityClass entityClass) {
    this.name = name;
    this.entityClass = entityClass;
  }

  @Override
  public String getName() {
    return name;
  }
  
  public EntityClass getEntityClass() {
	  return entityClass;
  }
}
