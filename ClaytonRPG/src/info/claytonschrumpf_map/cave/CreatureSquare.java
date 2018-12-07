package info.claytonschrumpf_map.cave;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_entity.character.PlayableCharacter;

public class CreatureSquare extends CaveSquare {

  public CreatureSquare(int squareLevel) {
    super(CaveSquareType.MONSTER_ROOM, squareLevel);
  }

  @Override
  public void squareAction(PlayableCharacter toApply) {
    // TODO Auto-generated method stub

  }
}
