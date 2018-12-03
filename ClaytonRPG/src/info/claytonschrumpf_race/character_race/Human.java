package info.claytonschrumpf_race.character_race;

import info.claytonschrumpf_abstract.entity.Race;

public class Human extends Race {


	@Override
	public void raceEffect() {
		return;
	}

	@Override
	public Race getRace() {
		return this;
	}

	@Override
	public String toString() {
		return "Human";
	}
}
