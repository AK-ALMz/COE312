import java.util.ArrayList;
import java.util.Scanner;

public class WeaponSmith extends NPC implements Shop {
	ArrayList<WeaponContext> Loot = new ArrayList<WeaponContext>();
	
	WeaponSmith(){
		super();
		this.id = "smith";
		this.name = "angelo";
		this.inRoom = 11;
		Loot.add(new Sniper()); //Change it
	}
	@Override
	public void buy(String[] splitInput) {
		WeaponContext weapToBuy = null;
		if(splitInput.length < 2) {
			System.out.println(name + ": \"Buy what?\"");
		} else {
			for(WeaponContext weapon: Loot) {
				if (weapon.name.equalsIgnoreCase(splitInput[1]))
					weapToBuy = weapon;
			}
			if (weapToBuy == null) {
				System.out.println("Item not available");
			} else {
				if(withdrawMoney(weapToBuy.price)) {
					System.out.println("Item Acquired");
					GameObjects.pc.Weapons.add(weapToBuy);
				}
			}
		}
	}
	@Override
	public boolean withdrawMoney(int cost) {
		if (hasMoney(cost)) {
			GameObjects.pc.balance -= cost;
			return true;
		} else {
			System.out.println("Cannot buy. Balance = " + GameObjects.pc.balance);
		}
		return false;
	}

	@Override
	public boolean hasMoney(int cost) {
		if (GameObjects.pc.balance >= cost) return true;
		return false;
	}

	@Override
	public void look() {
		System.out.println("The following is available for purchase:");
		for (WeaponContext weapon : Loot) {
			System.out.println(weapon.name + ", Price: " + weapon.price);
		}
	}
	@Override
	public void talk(String[] splitInput) {
		System.out.println("Weaponsmith: \"You are welcome to buy from us, but not welcome to speak for no reason.\"");
	}
	@Override
	public String toString() {
		return "Angelo the ominous Gunsmith sits behind the counter...";
	}
}
