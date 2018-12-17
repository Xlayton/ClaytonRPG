package info.claytonschrumpf_map.cave;

import java.util.Random;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_abstract.entity.Entity.Stat;
import info.claytonschrumpf_consoleIO.ConsoleUI;
import info.claytonschrumpf_consoleIO.EnumMenuSelection;
import info.claytonschrumpf_entity.character.PlayableCharacter;

public class TrapSquare extends CaveSquare {
  private final Random rand;
  private final TrapType type;

  private boolean isDisarmed;

  public TrapSquare(int squareLevel) {
    super(CaveSquareType.TRAP, squareLevel);
    this.rand = new Random();
    this.type = decideType();
    isDisarmed = false;
  }

  public boolean isDisarmed() {
    return isDisarmed;
  }

  private TrapType decideType() {
    int roll = rand.nextInt(100) + 1 + (getLevel() * 5);
    if (roll <= 50) {
      return TrapType.SPIKE;
    } else if (roll <= 80) {
      return TrapType.FIRE;
    } else {
      return TrapType.POISON_DART;
    }
  }

  public enum TrapType {
    SPIKE("Spike trap", 12, 5),
    FIRE("Fire trap", 15, 8),
    POISON_DART("Posion dart trap", 20, 12);

    int difficultyCheck;
    int damage;
    String name;

    private TrapType(String name, int dif, int dam) {
      this.name = name;
      this.difficultyCheck = dif;
      this.damage = dam;
    }

    public int getDC() {
      return difficultyCheck;
    }

    public int getDamage() {
      return damage;
    }

    public String getName() {
      return name;
    }
  }

  public enum TrapSolution implements EnumMenuSelection {
    DISARM("Disarm"),
    AVOID("Avoid");

    String name;

    private TrapSolution(String name) {
      this.name = name;
    }

    @Override
    public String getName() {
      return name;
    }
  }

  @Override
  public void squareAction(PlayableCharacter toApply) {
    switch (ConsoleUI.promptForMenuSelection("What do you want to do", TrapSolution.values())) {
      case DISARM:
        disarmTrap(toApply);
        break;
      case AVOID:
        skrrtTrap(toApply);
        break;
    }
  }

  private void disarmTrap(PlayableCharacter toApply) {
    int roll = rand.nextInt(20) + 1;
    int rollAndMod = roll + toApply.getStatModifier(Stat.INTELLECT);
    if (roll != 1 && roll != 20) {
      if (rollAndMod > type.getDC()) {
        isDisarmed = true;
      } else {
        trapDamage(toApply);
        if (toApply.isAlive()) {}
      }
    }
  }

  private void trapDamage(PlayableCharacter toApply) {
    toApply.takeDamage(type.getDamage(), type);
  }

  private void skrrtTrap(PlayableCharacter toApply) {
    int roll = rand.nextInt(20) + 1;
    int rollAndMod = roll + toApply.getStatModifier(Stat.DEXTERITY);
    if (roll != 1 && roll != 20) {
      if (rollAndMod > type.getDC()) {
        isDisarmed = true;
      } else {
        trapDamage(toApply);
        if (toApply.isAlive()) {}
      }
    }
  }
}
