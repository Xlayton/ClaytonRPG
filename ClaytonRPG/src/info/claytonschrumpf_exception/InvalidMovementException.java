package info.claytonschrumpf_exception;

import info.claytonschrumpf_entity.character.PlayableCharacter.Direction;

public class InvalidMovementException extends Exception {

  /** */
  private static final long serialVersionUID = 2417364973647736729L;

  private final Direction directionAttempted;

  public InvalidMovementException(Direction directionAttempted) {
    this.directionAttempted = directionAttempted;
  }

  @Override
  public String getMessage() {
    return ("You cannot move " + directionAttempted.toString());
  }
}
