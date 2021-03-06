package info.claytonschrumpf;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_abstract.entity.Entity;
import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_consoleIO.ConsoleUI;
import info.claytonschrumpf_entity.character.NPC;
import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_map.cave.Cave;
import info.claytonschrumpf_map.cave.Cave.CaveSize;
import info.claytonschrumpf_race.character_race.Dragonborn;
import info.claytonschrumpf_race.character_race.Dwarf;
import info.claytonschrumpf_race.character_race.Elf;
import info.claytonschrumpf_race.character_race.HalfOrc;
import info.claytonschrumpf_race.character_race.Human;

public class ConsoleGame {
	public void run() {
		final PlayableCharacter playableCharacter = new PlayableCharacter(8, 8, 8, 8, 8, 8, 8, null, null);
		final NPC npc = new NPC(8, 8, 8, 8, 8, 8, 8, null, null);

		PlayableCharacter playerCharacter = new PlayableCharacter(8, 8, 8, 8, 8, 8, 0, setName(),
				setRace(playableCharacter));

		Cave cave = new Cave("Base", CaveSize.SMALL, 1);

		for (CaveSquare[] e : cave.getCaveMap()) {
			for (CaveSquare s : e) {
				System.out.println(s.getArt());
			}
		}
	}

	private String setName() {
		return ConsoleUI.promptForInput("What is your name?", false);
	}

	private Race setRace(Entity entityType) {
		Race race = null;
		System.out.println("Choose a race: ");
		int selection = ConsoleUI.promptForMenuSelection(
				entityType.getRaceChoiceNames().toArray(new String[entityType.getRaceChoiceNames().size()]), false);
		switch (selection) {
		case 1:
			race = new Human();
			break;
		case 2:
			race = new Elf();
			break;
		case 3:
			race = new HalfOrc();
			break;
		case 4:
			race = new Dwarf();
			break;
		case 5:
			race = new Dragonborn();
			break;
		}
		return race.getRace();
	}
}
