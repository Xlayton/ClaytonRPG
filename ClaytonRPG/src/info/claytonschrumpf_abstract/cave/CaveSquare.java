package info.claytonschrumpf_abstract.cave;

public abstract class CaveSquare {
	private final CaveSquareType type;
	private final int squareLevel;

	public CaveSquare(CaveSquareType type, int squareLevel) {
		this.type = type;
		this.squareLevel = squareLevel;
	}

	public abstract void squareAction();

	public CaveSquareType getType() {
		return type;
	}

	public int getLevel() {
		return squareLevel;
	}

	public enum CaveSquareType {
		TRAP,
		MONSTER_ROOM,
		TREASURE,
		EMPTY,
		WALL;
	}

}
