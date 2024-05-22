import java.util.Scanner;

public class TalkCommand implements Command {

	@Override
	public void execute(String[] splitInput) {
			Room rm = GameObjects.roomlist.get(GameObjects.pc.inRoom);
			for (NPC npc : rm.npcs) {
				//System.out.println(npc.id + "     " + splitInput[1]);			//for debugging
				if (splitInput.length < 2) {
					System.out.println("To who?");
				} else{
					if (npc.name.equalsIgnoreCase(splitInput[1]))
					npc.talk(splitInput);
				}
			}
		
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
