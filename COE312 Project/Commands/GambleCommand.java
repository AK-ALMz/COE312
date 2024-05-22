import java.util.Scanner;

public class GambleCommand implements Command {

	@Override
	public void execute(String[] splitInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute() {		
			Room rm = GameObjects.roomlist.get(GameObjects.pc.inRoom);	
			if (!GameObjects.roomlist.get(GameObjects.pc.inRoom).npcs.isEmpty() && GameObjects.roomlist.get(GameObjects.pc.inRoom).npcs.get(0).id.equalsIgnoreCase("dealer")){
				Dealer dealer = (Dealer) GameObjects.roomlist.get(GameObjects.pc.inRoom).npcs.get(0);
				//This assumes the shopOwner is alone in the room
				dealer.gamble();
			}	else
				System.out.println("Dealer is not present.");
				

	
	}

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub

	}

}
