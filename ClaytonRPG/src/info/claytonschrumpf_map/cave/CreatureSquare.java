package info.claytonschrumpf_map.cave;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_abstract.entity.Monster;
import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_race.monster_race.MonsterRace;

public class CreatureSquare extends CaveSquare {
	
	private MonsterRace monsterRace;

  public CreatureSquare(int squareLevel, MonsterRace monsterRace) {
    super(CaveSquareType.MONSTER_ROOM, squareLevel);
    this.monsterRace = monsterRace;
    
  }

  @Override
  public void squareAction(PlayableCharacter toApply) {
	  Monster monster = monsterRace.getMonsterType();
	  monster.attack();
  }
}
