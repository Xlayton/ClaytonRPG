package info.claytonschrumpf;

import info.claytonschrumpf_abstract.cave.CaveSquare;
import info.claytonschrumpf_abstract.entity.Entity.Stat;
import info.claytonschrumpf_abstract.entity.EntityClass;
import info.claytonschrumpf_abstract.entity.Race;
import info.claytonschrumpf_consoleIO.ConsoleUI;
import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_entityClass.ClassList;
import info.claytonschrumpf_map.cave.Cave;
import info.claytonschrumpf_map.cave.Cave.CaveSize;
import info.claytonschrumpf_race.character_race.CharacterRace;

public class ConsoleGame {
  public void run() {
    int[] baseStats = new int[] {8, 8, 8, 8, 8, 8};

    PlayableCharacter playerCharacter =
        new PlayableCharacter(8, 8, 8, 8, 8, 8, 0, setName(), setRace(), setEntityClass());
    initPlayerStats(baseStats, playerCharacter);
    System.out.println(playerCharacter.getRace());
    for(int e : playerCharacter.getStatBlock()) {
    	System.out.println(e); 
    }
    System.out.println(playerCharacter.getHP());

    Cave cave = new Cave("TestSmall", CaveSize.SMALL, 1);

    for (CaveSquare[] e : cave.getCaveMap()) {
      for (CaveSquare s : e) {
        System.out.println(s.getArt());
        s.squareAction(playerCharacter);
      }
    }
  }

  private void initPlayerStats(int[] currentStats, PlayableCharacter curChar) {
	  int[] newStats = currentStats;
    while (curChar.getStatPoints() > 0) {
      displayPlayerStats(newStats);
      switch (ConsoleUI.promptForMenuSelection("Select a stat to increment", Stat.values())) {
        case STRENGTH:
          newStats[0]++;
          break;
        case DEXTERITY:
          newStats[1]++;
          break;
        case CONSTITUTION:
          newStats[2]++;
          break;
        case INTELLECT:
          newStats[3]++;
          break;
        case WISDOM:
          newStats[4]++;
          break;
        case CHARISMA:
          newStats[5]++;
          break;
      }
      curChar.subtractStatPoint();
    }
    curChar.setStats(newStats);
    }

  private void displayPlayerStats(int[] currentStats) {
    System.out.println("Strength:\t" + currentStats[0]);
    System.out.println("Dexterity:\t" + currentStats[1]);
    System.out.println("Constitution:\t" + currentStats[2]);
    System.out.println("Intellect:\t" + currentStats[3]);
    System.out.println("Wisdom:\t" + currentStats[4]);
    System.out.println("Charisma:\t" + currentStats[5]);
  }

  private EntityClass setEntityClass() {
    return (ConsoleUI.promptForMenuSelection("Select a Class", ClassList.values()))
        .getEntityClass();
  }

  private String setName() {
    return ConsoleUI.promptForInput("What is your name?", false);
  }

  private Race setRace() {
    return (ConsoleUI.promptForMenuSelection("Select a race", CharacterRace.values())).getRace();
  }
}
