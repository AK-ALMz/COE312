import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyLoader extends LoaderTemplate {
	public EnemyLoader() {
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void initializeData() {
			System.out.println("Initializing Enemies database...");
		        GameObjects.DataBaseEnemies.add(new Fodder());
		        GameObjects.DataBaseEnemies.add(new Elite());
		        GameObjects.DataBaseEnemies.add(new Boss(GameObjects.pc.HP,GameObjects.pc.ARM));
		        System.out.println(" Enemies Database initialized.");
		        //Due to time Constraints, the Database was not used in loadData as errors occured.
		        //Another approach was used.
	}
	@Override
	public void LoadData() {
		System.out.println("Loading Enemies...");
		ArrayList<String> enemyData = new ArrayList<String>();
		try {
		enemyData = GameLogic.readLines("GameFiles/EnemyLocations.txt");
		} catch (IOException e) {
		e.printStackTrace();
		}
		for (String line: enemyData) {
			String[] words = line.split(" ");
			int roomNum = Integer.parseInt(words[2].trim());
			boolean addedtoRoom = false;
				synchronized (GameObjects.roomlist.get(roomNum).enemies) {		
					switch(words[1]) {
					case("fodder"):
						GameObjects.roomlist.get(roomNum).enemies.add(new Fodder());
					break;
					case("elite"):
						GameObjects.roomlist.get(roomNum).enemies.add(new Elite());	
					break;
					case("boss"):
						GameObjects.roomlist.get(roomNum).enemies.add(new Boss(GameObjects.pc.HP,GameObjects.pc.ARM));
					break;
					}
					
				//System.out.println(words[1] + "   " + enemy.id + "    " + roomNum); 		//For debugging
			
			//	if (words[1].equalsIgnoreCase(enemy.id)) {
			//		synchronized (GameObjects.roomlist.get(roomNum).enemies) {
					
					//GameObjects.roomlist.get(roomNum).enemies.add(new Enemy());
					//}
				//}
			}
			}
		System.out.println("Enemy Loading Completed.");
		
	}

}
