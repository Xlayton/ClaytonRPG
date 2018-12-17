package info.claytonschrumpf_race.monster_race;

import info.claytonschrumpf_abstract.entity.Race;

public class GoblinRace extends Race {

  @Override
  public void raceEffect() {
	  
  }

  @Override
  public Race getRace() {
    return this;
  }

  @Override
  public String toString() {
    return "Goblin";
  }
}
