
import java.util.Random;

public abstract class GamblingShop extends NPC implements ShopG {
	
	
	@Override
	public void gamble() {
		// TODO Auto-generated method stub
		Random i = new Random();
		int b=0;
		int half = (GameObjects.pc.balance)/2;
		if(hasMoney(500)) {
			withdrawMoney(half);
			b=i.nextInt(10);
			
			if(b<4)
			{
				
				GameObjects.pc.balance+= 10000 + half;
				
				System.out.println("You got 10000 coins!!! Now you can buy a weapon from the Weaponsmith in the Arm Dealer room.");
				
			}
			
			else {
			System.out.println("You lost half of your total coins :(");
			
		}
		} else {
			System.out.println("Insufficient funds.");
		}
	}

	@Override
	public boolean withdrawMoney(int cost) {
		if (hasMoney(cost)) {
			GameObjects.pc.balance-=cost;
			return true;
		} else {
			System.out.println("You need to have more than 500 coins to gamble!!");
		}
		return false;
	}
	@Override
	public boolean hasMoney(int cost) {
		if (GameObjects.pc.balance > cost) return true;
		return false;
	}

	@Override
	public void look() {
		
		System.out.println("It's written in the rules behind the dealer that If I win I'll get 10000 coins,"
				+ " if I lose, half of my total coins will be taken.");
		
		
	}

	
}