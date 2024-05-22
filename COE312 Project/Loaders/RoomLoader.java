import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomLoader extends LoaderTemplate {
	public RoomLoader() {
		t = new Thread(this);
		t.start();
	}
	@Override
	public void initializeData() {
		System.out.println("Initializing Areas...");
		GameObjects.roomlist.add(new Room("None", 0)); //to keep the numbers aligned
		List<String> roomInfo = new ArrayList<String>(); //check
		try {
		roomInfo = GameLogic.readLines("GameFiles/RoomDescriptions.txt");
		} catch (IOException e) {
		e.printStackTrace();
		}
		int currentSize = 1;
		for(String line: roomInfo) { //Loop 1 will create all the rooms
			String[] category = line.split(" "); //Will hold stuff like "RoomName:" in index 0
			String[] data = line.split(":"); //will contain the data in index 1
			if (category[0].equals("RoomName:")) {
				currentSize = GameObjects.roomlist.size();
				GameObjects.roomlist.add(new Room(data[1], currentSize)); 
				//creating a room with currentSize means new size = currentSize + 1
				//can use currentSize as index now, since Room(0) is ignored
				//Changed format a little
				//original GameObjects.roomlist.get(GameObjects.room.size() - 1).number = currentSize;
			} else if (category[0].equals("Desc:")) {
				GameObjects.roomlist.get(currentSize).descriptions.add(data[1].trim());
			} else if (category[0].equals("Exit:")) {
				GameObjects.roomlist.get(currentSize).exits.add(data[1]);
				
			}
		}
		System.out.println("Area Initialization Completed.");

	}

	@Override
	public void LoadData() {
		NPCLoader nl = new NPCLoader();
		ItemLoader il = new ItemLoader();
		EnemyLoader el = new EnemyLoader();
		
		try {
			nl.getThread().join();
			il.getThread().join();
			el.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
