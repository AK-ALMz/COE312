
public abstract class Item {
	
	String name;
	String id;
	String desc;
	int cost;
	boolean isEquipped;

	public abstract void pickup();
	
	public abstract void use();
	
	@Override
	public String toString() {
		return "you found " + name + " in the room.";
	}
}
