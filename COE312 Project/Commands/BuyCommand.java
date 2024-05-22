import java.util.Scanner;

public class BuyCommand implements Command {

	@Override
	public void execute(String[] splitInput) {
			Room rm = GameObjects.roomlist.get(GameObjects.pc.inRoom);	
				WeaponSmith shopOwner = (WeaponSmith) GameObjects.roomlist.get(GameObjects.pc.inRoom).npcs.get(0);
				//This assumes the shopOwner is alone in the room
				shopOwner.buy(splitInput);
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub

	}

}
