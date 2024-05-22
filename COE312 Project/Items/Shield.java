
public class Shield extends Item {
	
	public void Shield()
	{
		this.name = "Shield";
		this.desc = "A shield made of rare material";
		this.isEquipped = false;
		this.cost = 100;
		
	}
	
	@Override
	public void pickup()
	{
		this.isEquipped=true;
		System.out.println("Pistol is equpped! ");
	}
	
	@Override
	public void use()
	{
		System.out.println("Damage against the user is halved! ");
		
	}
	

}
