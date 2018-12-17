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
    PlayableCharacter playerCharacter =
        new PlayableCharacter(initPlayerStats(), 0, setName(), setRace(), setEntityClass());
    Cave cave = new Cave("TestSmall", CaveSize.SMALL, 1);

    for (CaveSquare[] e : cave.getCaveMap()) {
      for (CaveSquare s : e) {
        ConsoleUI.printLine(s.getArt());
        s.squareAction(playerCharacter);
      }
    }
  }

  private int[] initPlayerStats() {
    int[] baseStats = new int[] {8, 8, 8, 8, 8, 8};
    int[] newStats = baseStats;
    for (int i = 0; i < 37; i++) {
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
    }
    return newStats;
  }

  private void displayPlayerStats(int[] currentStats) {
    ConsoleUI.printLine("Strength:\t" + currentStats[0]);
    ConsoleUI.printLine("Dexterity:\t" + currentStats[1]);
    ConsoleUI.printLine("Constitution:\t" + currentStats[2]);
    ConsoleUI.printLine("Intellect:\t" + currentStats[3]);
    ConsoleUI.printLine("Wisdom:\t" + currentStats[4]);
    ConsoleUI.printLine("Charisma:\t" + currentStats[5]);
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
