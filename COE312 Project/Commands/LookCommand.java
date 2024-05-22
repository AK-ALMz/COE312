import java.util.Scanner;

public class LookCommand implements Command {
	//IND = 0;
	@Override
	public void execute(String[] splitInput) {
			if (splitInput.length == 1) { //only "Look" typed
				Room rm = GameObjects.roomlist.get(GameObjects.pc.inRoom); //gets the room from the roomlist
						System.out.println("Location:" + rm.name);
						for (String desc : rm.descriptions) { //prints out the description of the room
							System.out.println(desc);
						}
						System.out.println("Exits: ");
						for (String exit : rm.exits) { //exit is in form: "North 3". (action) (newRoom)
							String[] exitName = exit.split(" ");
							System.out.println(exitName[1]); //prints (action)
						}
						for (NPC npc : rm.npcs) {
							System.out.println(npc);
						}
						for (Enemy enemy : rm.enemies) {
							if (enemy.isAlive)
							System.out.println(enemy.desc); //the toString function of enemy is used to display its stats
						}
						for (Item item: rm.items) {
							System.out.println(item);
						}
					}
			if (splitInput.length == 2) {
				if(splitInput[1].equals("self"))
					GameObjects.pc.look();
				else {
					for (NPC npc : GameObjects.roomlist.get(GameObjects.pc.inRoom).npcs) {
						if (splitInput[1].equalsIgnoreCase(npc.name)) {
							npc.look();
						}
					}
					for (Enemy enemy: GameObjects.roomlist.get(GameObjects.pc.inRoom).enemies) {
						if (splitInput[1].equalsIgnoreCase(enemy.Name)) {
							enemy.look();
						}
					}
				}
			}
		}

	@Override
	public void execute() {
		execute(new String[1]);
	}

	@Override
	public void execute(Scanner scan) {
	}

}
