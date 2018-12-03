package info.claytonschrumpf_abstract.entity;

public abstract class Monster extends Entity {

	private final String name;
	private final Race race;
	private final int level;

	private int[] stats;

	public Monster(int strength, int dexterity, int constitution, int intellect, int wisdom,
			int charisma, int level, String name, Race race) {
		super(strength, dexterity, constitution, intellect, wisdom, charisma);
		this.name = name;
		this.race = race;
		this.stats = makeStatBlock();
		this.level = level;
	}

	public int[] getStatBlock() {
		return stats;
	}

	public String getName() {
		return name;
	}

	public Race getRace() {
		return race;
	}

	public int getLevel() {
		return level;
	}

}

