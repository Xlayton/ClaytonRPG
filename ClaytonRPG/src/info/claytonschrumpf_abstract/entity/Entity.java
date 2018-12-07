package info.claytonschrumpf_abstract.entity;

import java.util.ArrayList;

import info.claytonschrumpf_consoleIO.EnumMenuSelection;
import info.claytonschrumpf_entity.character.PlayableCharacter;
import info.claytonschrumpf_exception.DeathException;
import info.claytonschrumpf_map.cave.TrapSquare.TrapType;

public abstract class Entity {
	private final String name;

	private int strength;
	private int dexterity;
	private int constitution;
	private int intellect;
	private int wisdom;
	private int charisma;
	private int hp;
	private boolean isAlive;

	public Entity(int strength, int dexterity, int constitution, int intellect, int wisdom, int charisma, String name) {
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intellect = intellect;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.isAlive = true;
		this.hp = initHP();
	}

	public int getStatModifier(Stat stat) {
		double rawStat;
		switch (stat) {
		case Charisma:
			rawStat = charisma;
			break;
		case Constitution:
			rawStat = constitution;
			break;
		case Dexterity:
			rawStat = dexterity;
			break;
		case Intellect:
			rawStat = intellect;
			break;
		case Strength:
			rawStat = strength;
			break;
		case Wisdom:
			rawStat = wisdom;
			break;
		default:
			throw new IllegalArgumentException("That isnt a valid stat type");
		}
		rawStat = (rawStat - 10) / 2;
		return (int) Math.round(rawStat);
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
	
public void setStats(int[] statBlock) {
		strength = statBlock[0];
		dexterity = statBlock[1];
		constitution = statBlock[2];
		intellect = statBlock[3];
		wisdom = statBlock[4];
		charisma = statBlock[5];

	}


	public enum Stat implements EnumMenuSelection {
		Strength("Strength"), Dexterity("Dexterity"), Constitution("Constitution"), Intellect("Intellect"),
		Wisdom("Wisdom"), Charisma("Charisma");

		String name;

		private Stat(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	public void takeDamage(int amtToTake, Entity doingDamage) {
		try {
			if (amtToTake > this.hp) {
				throw new DeathException(this.getName(), doingDamage);
			} else {
				this.hp -= amtToTake;
			}
		} catch (DeathException ex) {
			if (this instanceof PlayableCharacter) {
				System.out.println(ex.getMessage());
			}
			this.isAlive = false;
		}
	}

	public void takeDamage(int amtToTake, TrapType doingDamage) {
		try {
			if (amtToTake > this.hp) {
				throw new DeathException(this.getName(), doingDamage);
			} else {
				this.hp -= amtToTake;
			}
		} catch (DeathException ex) {
			if (this instanceof PlayableCharacter) {
				System.out.println(ex.getMessage());
			}
			this.isAlive = false;
		}
	}

	public String getName() {
		return name;
	}

	public abstract int initHP();

	public abstract ArrayList<String> getRaceChoiceNames();

	protected abstract void initRaceNames();
}
