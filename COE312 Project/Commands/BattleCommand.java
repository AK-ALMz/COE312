import java.util.Scanner;

public class BattleCommand implements Command {

	@Override
	public void execute(String[] splitInput) {
	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(Scanner scan) {
		if (GameObjects.roomlist.get(GameObjects.pc.inRoom).enemies.isEmpty()) 
			System.out.println("No enemies to battle...");
		else
			for (Enemy enemy : GameObjects.roomlist.get(GameObjects.pc.inRoom).enemies) {
				Encounter En = new Encounter(GameObjects.pc, enemy);
			}
	}

}
