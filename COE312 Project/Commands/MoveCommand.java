import java.util.Scanner;

public class MoveCommand implements Command {

	@Override
	public void execute(String[] splitInput) {
		Room rm = GameObjects.roomlist.get(GameObjects.pc.inRoom);
		boolean noEnemies = true;
		for (Enemy en : rm.enemies) {
			if (en.isAlive) noEnemies = false;
		}
		if (!noEnemies) {
			 System.out.println("Cannot exit room. a threat is nearby");
			 return;
		}
				 if (splitInput.length == 1) {
					System.out.println("Where to?");
					return;
				} 
				else if (splitInput.length == 2) {
					String moveDirection = splitInput[1];
					
					if (rm.number == 12 && GameObjects.pc.hasKey && moveDirection.equalsIgnoreCase("up")) {
						GameObjects.pc.inRoom = 20;
						System.out.println("Used key to enter through the gate. \n");
						GameLogic.p.buttonWasPressed(0); //Runs the "look" function
					} else if (rm.number == 12 && !GameObjects.pc.hasKey && moveDirection.equalsIgnoreCase("up")) {
						System.out.println("Access denied. You do not have an entrance key.");
					} else {
						for (String ex : rm.exits) {
							String[] exitData= ex.split(" "); //note: format is " south 1", so there is a space before
							if(moveDirection.equalsIgnoreCase(exitData[1])) {
								GameObjects.pc.inRoom = Integer.parseInt(exitData[2].trim());
								System.out.println("You head " + moveDirection + ".\n");
								GameLogic.p.buttonWasPressed(0); //A call for the look command when moving between areas
								return;
								}
							}
						}
					}	
	}

	@Override
	public void execute() {}

	@Override
	public void execute(Scanner scan) {}

}
