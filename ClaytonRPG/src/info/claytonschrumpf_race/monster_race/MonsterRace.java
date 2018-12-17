package info.claytonschrumpf_race.monster_race;

import info.claytonschrumpf_abstract.entity.Monster;
import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_entity.monster.Goblin;

public enum MonsterRace {
	GOBLIN("Goblin", new GoblinRace(), new Goblin(8, 14, 10, 10, 8, 8, 1, "Goblin", new GoblinRace()));
	
	private String name;
	private Race race;
	private Monster monsterType;
	
	private MonsterRace(String name, Race race, Monster monsterType) {
		this.name = name;
		this.race = race;
		this.monsterType = monsterType;
	}
	
	public String getName() {
		return name;
	}
	
	public Race getRace() {
		return race;
	}
	
	public Monster getMonsterType() {
		return monsterType;
	}
}

