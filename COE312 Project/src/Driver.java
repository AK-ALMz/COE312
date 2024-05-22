import java.io.IOException;

public class Driver {
	
	public static void main(String args[]) throws Exception {
		//NOTE: CHANGE IP/PORT FROM SensorLoader.java
		RoomLoader rl = new RoomLoader();
		rl.getThread().join(); //added Throws Exception to make code clearer (no try/catch)
		SensorLoader s = new SensorLoader();
		s.getThread().join();
		System.out.println("\n\n\n\n\n\n\n");
		while(GameObjects.pc.HP > 0 && !GameObjects.pc.hasWon) { //TODO death mechanic not tested yet
		game_loop();	
		}
		if (GameObjects.pc.hasWon) {
			System.out.println("Well Done soldier, you have successfully taken down Mika.");
			System.out.println("\n\n\n");
			System.out.println("Credits: \n"	
					+ "Abdalla Almarzooqi		b00091740\n"
					+ "Mohammed Alkatheeri		b00093619\n"
					+ "Jad Friej			b00093287\n"
					+ "Zayd Altirkawi			b00088514");
		} else
		System.out.println("You have flatlined. End of the road for you, choom...");
	}
	public static void game_loop() { //MAKE THIS IN ANOTHER THREAD, AND THE SENSOR IN ANOTHER
		GameLogic.waitForInput();
	}
}
