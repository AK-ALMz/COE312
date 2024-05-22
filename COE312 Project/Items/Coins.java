
public class Coins extends Item {
	
	int value;
	public Coins()
	{
		this.name = "Coins";
		this.desc = "coins that can be used to buy items";
		this.id = "coins";
	
	}
	@Override
	public void pickup()
	{
		GameObjects.pc.balance += 100;	
		System.out.println("Picked Up Coins. New balance: " + GameObjects.pc.balance);
	}
	
	public void use()
	{
		System.out.println(this.value+" was used! ");
	}
}
