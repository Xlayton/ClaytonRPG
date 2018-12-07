package info.claytonschrumpf_abstract.cave;

import info.claytonschrumpf_entity.character.PlayableCharacter;

public abstract class CaveSquare {
  private final CaveSquareType type;
  private final int squareLevel;

  private boolean hasPlayer;

  public CaveSquare(CaveSquareType type, int squareLevel) {
    this.type = type;
    this.squareLevel = squareLevel;
  }

  public abstract void squareAction(PlayableCharacter toAffect);

  public CaveSquareType getType() {
    return type;
  }

  public int getLevel() {
    return squareLevel;
  }

  public void setPlayer() {
    hasPlayer = true;
  }

  public void removePlayer() {
    hasPlayer = false;
  }

  public String getArt() {
    return setArt();
  }

  private String setArt() {
    String art;
    if (hasPlayer) {
      art = " ___\n| O |\n|___|";
      return art;
    } else {
      art = " ___\n|   |\n|___|";
      return art;
    }
  }

  public enum CaveSquareType {
    TRAP,
    MONSTER_ROOM,
    TREASURE,
    EMPTY,
    WALL;
  }
}
