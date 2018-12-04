package info.claytonschrumpf_map.cave;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_map.cave.Cave.CaveSize;

public class TreasureSquare extends CaveSquare {

	public TreasureSquare(CaveSize size, int squareLevel) {
		super(CaveSquareType.TREASURE, squareLevel);
	}

	@Override
	public void squareAction(PlayableCharacter toApply) {
		// TODO Auto-generated method stub

	}

}
