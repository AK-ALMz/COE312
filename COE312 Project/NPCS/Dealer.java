

public class Dealer extends GamblingShop {

	
	Dealer(){
		
		super();
		this.id = "dealer";
		this.name = "marcus";
		this.inRoom = 10;
		
	}
	
	@Override
	public void talk(String[] splitInput) {
		System.out.println("Dealer: If ya wanna test yer luck, ya hafta gimme 500 coins.");
		System.out.println("Dealer: If ya win? 10000 coins in your pocket. If ya lose? Half of your total coins is mine!! Think wisely, choom");
		System.out.println("Dealer: Do ya wanna gamble?");
		
	}
	
	@Override
	public String toString() {
		return "Marcus the dealer sits behind the table.";
	}
	

}

