package info.claytonschrumpf_abstract.item;

public abstract class Item {
	private final String name;
	private final ItemType itemType;

	public Item(String name, ItemType itemType) {
		this.name = name;
		this.itemType = itemType;
	}

	protected enum ItemType {
		WEAPON,
		POTION,
		ARMOR,
		CONSUMABLE,
		TREASURE;
	}

	public String getName() {
		return name;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public String getItemTypeString() {
		return itemType.toString();
	}
}
