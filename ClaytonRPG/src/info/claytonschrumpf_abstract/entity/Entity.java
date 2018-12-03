package info.claytonschrumpf_abstract.entity;

import java.util.ArrayList;

public abstract class Entity {
	private int strength;
	private int dexterity;
	private int constitution;
	private int intellect;
	private int wisdom;
	private int charisma;

	public Entity(int strength, int dexterity, int constitution, int intellect, int wisdom,
			int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intellect = intellect;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}

	protected int[] makeStatBlock() {
		int[] statBlock = new int[6];
		statBlock[0] = strength;
		statBlock[1] = dexterity;
		statBlock[2] = constitution;
		statBlock[3] = intellect;
		statBlock[4] = wisdom;
		statBlock[5] = charisma;
		return statBlock;
	}

	public abstract ArrayList<String> getRaceChoiceNames();

	protected abstract void initRaceNames();
}
