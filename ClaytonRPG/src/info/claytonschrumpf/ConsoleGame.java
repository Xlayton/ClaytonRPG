package info.claytonschrumpf;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_abstract.entity.Entity.Stat;
import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_consoleIO.ConsoleUI;
import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_map.cave.Cave;
import info.claytonschrumpf_map.cave.Cave.CaveSize;
import info.claytonschrumpf_race.character_race.CharacterRace;

public class ConsoleGame {
	public void run() {
		int[] baseStats = new int[] { 8, 8, 8, 8, 8, 8 };

		PlayableCharacter playerCharacter = new PlayableCharacter(8, 8, 8, 8, 8, 8, 0, setName(), setRace());
		int[] playerStats = initPlayerStats(baseStats, playerCharacter);
		playerCharacter.setStats(playerStats);
		System.out.println(playerCharacter.getRace());

		Cave cave = new Cave("TestSmall", CaveSize.SMALL, 1);

		for (CaveSquare[] e : cave.getCaveMap()) {
			for (CaveSquare s : e) {
				System.out.println(s.getArt());
				s.squareAction(playerCharacter);
			}
		}
	}

	private int[] initPlayerStats(int[] currentStats, PlayableCharacter curChar) {
		while(curChar.getStatPoints() > 0) {
			displayPlayerStats(currentStats);
			switch(ConsoleUI.promptForMenuSelection("Select a stat to increment" , Stat.values())) {
			case Strength:
				currentStats[0]++;
				break;
			case Dexterity:
				currentStats[1]++;
				break;
			case Constitution:
				currentStats[2]++;
				break;
			case Intellect:
				currentStats[3]++;
				break;
			case Wisdom:
				currentStats[4]++;
				break;
			case Charisma:
				currentStats[5]++;
				break;
			
			}
			curChar.subtractStatPoint();
		}
		return currentStats;
	}
	
	private void displayPlayerStats(int[] currentStats) {
		System.out.println("Strength:\t" + currentStats[0]);
		System.out.println("Dexterity:\t" + currentStats[1]);
		System.out.println("Constitution:\t" + currentStats[2]);
		System.out.println("Intellect:\t" + currentStats[3]);
		System.out.println("Wisdom:\t" + currentStats[4]);
		System.out.println("Charisma:\t" + currentStats[5]);

	}

	private String setName() {
		return ConsoleUI.promptForInput("What is your name?", false);
	}

	private Race setRace() {
		return (ConsoleUI.promptForMenuSelection("Select a race", CharacterRace.values())).getRace();
	}
}
