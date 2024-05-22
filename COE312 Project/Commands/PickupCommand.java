import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PickupCommand implements Command {

	@Override
	public void execute(String[] splitInput) {
			Room rm = GameObjects.roomlist.get(GameObjects.pc.inRoom);
			List<Item> toBeRemoved = new ArrayList();
			if (rm.items.isEmpty()) {
				System.out.println("Nothing to pickup..");
				return;
			} else if (splitInput.length == 1) { //checks if sent from the sensor or not
				if (rm.items.size() > 0)
				for (Item item : rm.items) {
				item.pickup();
				toBeRemoved.add(item);	
				}
			} else
			for (Item item : rm.items) {
				if (item.id.equalsIgnoreCase(splitInput[1])) {
					item.pickup();
					toBeRemoved.add(item);	
				}
			}
			rm.items.removeAll(toBeRemoved);
		

	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(Scanner scan) {
	}

}
