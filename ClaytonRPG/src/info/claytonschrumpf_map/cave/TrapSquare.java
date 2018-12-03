package info.claytonschrumpf_map.cave;

import java.util.Random;
import info.claytonschrumpf_abstract.cave.CaveSquare;

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
		SPIKE,
		FIRE,
		POISON_DART;

	}

	@Override
	public void squareAction() {
		// TODO Auto-generated method stub

	}



}