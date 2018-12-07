package info.claytonschrumpf_abstract.entity;

public abstract class EntityClass {
	private final int hitDie;
	private final String name;
	private final AttackType attackType;
	
	public EntityClass(int hitDie, String name, AttackType attackType) {
		this.hitDie = hitDie;
		this.name = name;
		this.attackType = attackType;
	}
	
	
	public enum AttackType {
	    MAGICAL("Magical"),
	    PHYSICAL("Physical");

	    String name;

	    private AttackType(String name) {
	      this.name = name;
	    }

	    public String getName() {
	      return name;
	    }
	}
	
	public int getHitDie() {
		return hitDie;
	}
	
	public String getName() {
		return name;
	}
	
	public AttackType getAttackType() {
		return attackType;
	}
	
}
