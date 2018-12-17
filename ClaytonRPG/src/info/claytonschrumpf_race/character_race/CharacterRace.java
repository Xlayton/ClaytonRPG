package info.claytonschrumpf_race.character_race;

import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_consoleIO.EnumMenuSelection;

public enum CharacterRace implements EnumMenuSelection {
  HUMAN("Human", new Human()),
  ELF("Elf", new Elf()),
  HALF_ORC("Half Orc", new HalfOrc()),
  DWARF("Dwarf", new Dwarf()),
  DRAGONBORN("Dragonborn", new Dragonborn());

  private String name;
  private Race race;

  private CharacterRace(String name, Race race) {
    this.name = name;
    this.race = race;
  }

  public String getName() {
    return name;
  }

  public Race getRace() {
    return race;
  }
}
