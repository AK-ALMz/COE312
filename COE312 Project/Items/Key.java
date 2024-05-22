
public class Key extends Item {
	
	public Key()
	{
		this.name = "Key";
		this.desc = "Key that gives access to the building.";
		this.id = "key";
	
	}
	@Override
	public void pickup() {
		use();
		System.out.println("Picked up a Key.");

	}

	@Override
	public void use() {
		GameObjects.pc.hasKey = true;

	}

}
