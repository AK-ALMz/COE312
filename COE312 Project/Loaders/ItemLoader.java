import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemLoader extends LoaderTemplate {
	public ItemLoader() {
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void initializeData() {
		System.out.println("Initializing Items database...");
        GameObjects.DataBaseItems.add(new Coins());
        GameObjects.DataBaseItems.add(new Key());
        System.out.println("added coins");
        System.out.println(" Items Database initialized.");
	}
	
	@Override
	public void LoadData() {
		System.out.println("Loading Items...");
		ArrayList<String> itemData = new ArrayList<String>();
		try {
		itemData = GameLogic.readLines("GameFiles/ItemLocations.txt");
		} catch (IOException e) {
		e.printStackTrace();
		}
		for (String line: itemData) {
			String[] words = line.split(" ");
			int roomNum = Integer.parseInt(words[2].trim());
			for (Item item: GameObjects.DataBaseItems) {
				//System.out.println(words[1] + "   " + item.id + "    " + roomNum); 		//For debugging
				if (words[1].equalsIgnoreCase(item.id)) {
					synchronized (GameObjects.roomlist.get(roomNum).items) {
					GameObjects.roomlist.get(roomNum).items.add(item);
					}
				}
			}
		}
		System.out.println("Item Loading Completed.");
	}

}
