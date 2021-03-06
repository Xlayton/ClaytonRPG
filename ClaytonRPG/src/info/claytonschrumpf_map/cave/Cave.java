package info.claytonschrumpf_map.cave;

import info.claytonschrumpf_abstract.cave.CaveSquare;

public class Cave {
	private final String name;
	private final CaveSize size;
	private final int caveLevel;

	private boolean isCleared;
	private CaveSquare[][] caveMap;

	public Cave(String name, CaveSize size, int caveLevel) {
		this.name = name;
		this.size = size;
		this.caveLevel = caveLevel;
		initCave();
	}

	public void initCave() {
		switch (size) {
		case SMALL:
			caveMap = new CaveSquare[3][1];
			(caveMap[0][0] = new TrapSquare(caveLevel)).setPlayer();
			caveMap[1][0] = new CreatureSquare(caveLevel);
			caveMap[2][0] = new TreasureSquare(CaveSize.SMALL, caveLevel);
			break;
		}
	}

	public CaveSquare[][] getCaveMap() {
		return caveMap;
	}

	public enum CaveSize {
		SMALL, MEDIUM, LARGE
	}
}
