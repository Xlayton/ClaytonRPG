package info.claytonschrumpf_abstract.entity;

import java.util.ArrayList;
import info.claytonschrumpf_consoleIO.ConsoleUI;
import info.claytonschrumpf_race.character_race.CharacterRace;
import info.claytonschrumpf_race.character_race.Dragonborn;
import info.claytonschrumpf_race.character_race.Dwarf;
import info.claytonschrumpf_race.character_race.Elf;
import info.claytonschrumpf_race.character_race.HalfOrc;
import info.claytonschrumpf_race.character_race.Human;

public abstract class Character extends Entity {

	private final String name;
	private final Race race;
	private int level;
	private final ArrayList<String> raceChoiceNames;

	private int[] stats;

	public Character(int strength, int dexterity, int constitution, int intellect, int wisdom, int charisma, int level,
			String name, Race race) {
		super(strength, dexterity, constitution, intellect, wisdom, charisma);
		this.name = name;
		this.race = race;
		this.stats = makeStatBlock();
		this.level = level;
		this.raceChoiceNames = new ArrayList<>();
		initRaceNames();
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

	public void addLevel() {
		level++;
	}

	@Override
	public ArrayList<String> getRaceChoiceNames() {
		return raceChoiceNames;
	}

	@Override
	protected void initRaceNames() {
		for (CharacterRace r : CharacterRace.values()) {
			raceChoiceNames.add(r.name());
		}
	}
}
