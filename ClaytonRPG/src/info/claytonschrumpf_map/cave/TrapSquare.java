package info.claytonschrumpf_map.cave;

import java.util.Random;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_consoleIO.ConsoleUI;
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
		SPIKE(12, 5), FIRE(15, 8), POISON_DART(20, 12);

		int difficultyCheck;
		int damage;

		private TrapType(int dif, int dam) {
			this.difficultyCheck = dif;
			this.damage = dam;
		}

		public int getDC() {
			return difficultyCheck;
		}

		public int getDamage() {
			return damage;
		}
	}

	public enum TrapSolution {
		DISARM, AVOID
	}

	@Override
	public void squareAction(PlayableCharacter toApply) {
		switch (getAttemptType()) {
		case DISARM:
			disarmTrap(toApply);
			break;
		case AVOID:
			skrrtTrap(toApply);
			break;
		}
	}

	private TrapSolution getAttemptType() {
		String[] choices = new String[] { "Disarm", "Avoid" };
		System.out.println("The room is trapped!");
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
		int roll = rand.nextInt(20) + 1 + toApply.getStatBlock()[3];
		System.out.println("You rolled a " + roll + " with modifiers");
		if (roll > type.getDC()) {
			System.out.println("You sucessfully disarmed the trap!");
			isDisarmed = true;
		} else {
			System.out.println("You triggered the trap! You made it through but sustained " + type.getDamage()
					+ " points of damage.");
			trapDamage(toApply);
		}
	}

	private void trapDamage(PlayableCharacter toApply) {
		toApply.takeDamage(type.getDamage());
	}

	private void skrrtTrap(PlayableCharacter toApply) {
		int roll = rand.nextInt(20) + 1 + toApply.getStatBlock()[1];
		System.out.println("You rolled a " + roll + " with modifiers");

		if (roll > type.getDC()) {
			return;
		}
	}

}
