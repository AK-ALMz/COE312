import java.util.ArrayList;

public abstract class Shopkeep extends NPC implements Shop {
	ArrayList<Item> Loot = new ArrayList<Item>();
	@Override
	public void buy(String[] splitInput) {
		Item itemToBuy = null;
		if(splitInput.length < 2) {
			System.out.println(name + ": \"Buy what?\"");
		} else {
			for(Item item : Loot) {
				if (item.name.equalsIgnoreCase(splitInput[1]))
					itemToBuy = item;
			}
			if (itemToBuy == null) {
				System.out.println("Item not available");
			} else {
				if(withdrawMoney(itemToBuy.cost)) {
					System.out.println("Item Acquired");
					//TODO - Add to inventory funciton
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
			System.out.println("Not enough funds");
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
		for (Item item : Loot) {
			System.out.println(item.name);
		}
	}

}
