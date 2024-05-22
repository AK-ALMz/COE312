
public abstract class NPC {
	String name;
	String id;
	int inRoom = 0;
	@Override
	public String toString() {
		return "a friendly " + name + " is present in the room";
	}
	public abstract void look();
	public abstract void talk(String[] splitInput);
	
}

