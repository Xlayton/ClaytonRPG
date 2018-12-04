package info.claytonschrumpf_map.cave;

import java.util.Random;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_consoleIO.ConsoleUI;
import info.claytonschrumpf_entity.character.PlayableCharacter;

public class TrapSquare extends CaveSquare {
	private final Random rand;
	private final TrapType type;

	public TrapSquare(int squareLevel) {
		super(CaveSquareType.TRAP, squareLevel);
		this.rand = new Random();
		this.type = decideType();
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
		SPIKE, FIRE, POISON_DART;
	}

	public enum TrapSolution {
		DISARM, AVOID
	}

	@Override
	public void squareAction(PlayableCharacter toApply) {
		switch(getAttemptType()) {
		case DISARM:
			disarmTrap();
			break;
		case AVOID:
			skrrtTrap();
			break;
		}
	}

	private TrapSolution getAttemptType() {
		String[] choices = new String[] { "Disarm", "Avoid" };
		switch (ConsoleUI.promptForMenuSelection(choices, false)) {
		case 1:
			return TrapSolution.DISARM;
		case 2:
			return TrapSolution.AVOID;
		default:
			throw new IllegalArgumentException("You're clapped");
		}
	}

	private void disarmTrap(PlayableCharacter toApply) {
		int roll = rand.nextInt();
	}

	private void skrrtTrap(PlayableCharacter toApply) {

	}

}
