package info.claytonschrumpf_exception;

import info.claytonschrumpf_abstract.entity.Entity;
import info.claytonschrumpf_map.cave.TrapSquare.TrapType;

public class DeathException extends Exception {
  /** */
  private static final long serialVersionUID = -1072978832861211985L;

  private final String deadCharacterName;
  private final Entity killedPlayer;
  private final TrapType trapType;

  public DeathException(String deadCharacterName, Entity killedPlayer) {
    this.deadCharacterName = deadCharacterName;
    this.killedPlayer = killedPlayer;
    this.trapType = null;
  }

  public DeathException(String deadCharacterName, TrapType trapType) {
    this.deadCharacterName = deadCharacterName;
    this.trapType = trapType;
    this.killedPlayer = null;
  }

  @Override
  public String getMessage() {
    String killedByName = (killedPlayer == null) ? trapType.getName() : killedPlayer.getName();
    return ("Your character " + deadCharacterName + " died by a " + killedByName + ".");
  }
}
