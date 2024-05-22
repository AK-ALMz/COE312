
import java.util.Scanner;

public class Encounter {
	static PC player;
	static Enemy enemy;
	Scanner s = new Scanner(System.in);

	public Encounter(PC player, Enemy enemy) {
		Encounter.player = player;
		Encounter.enemy = enemy;
		this.Loop();
	}
	
	public void playerTurn() {
		player.isBlocking = false;
		try { 
			Thread.sleep(1500);
		} catch(InterruptedException ex){ 
			System.exit(0); 
		}
		System.out.println("\nIt is your turn.");
		System.out.print("> ");
		String action = s.nextLine();
		action.toLowerCase();
		if(action.startsWith("attack")||action.startsWith("shoot")||action.startsWith("hit")) {
			try { 
				Thread.sleep(1000);
			} catch(InterruptedException ex){ 
				System.exit(0); 
			} 
			System.out.println("You attack "+enemy.Name+"...");
			int atk = player.attack();
	    	player.Weapons.get(player.WeaponIndex).Shoot();
			enemy.receiveDMG(atk);
			if(enemy.HP<=0) enemy.isAlive = false;
			else enemy.status();
		}
		else if(action.startsWith("guard")||action.startsWith("block")||action.startsWith("defend")) {
			player.isBlocking = true;
			System.out.println("You defend yourself...");
		}
		else if(action.startsWith("heal")||action.startsWith("replenish")||action.startsWith("drink")) {
			player.heal(10);
		}
		else if(action.startsWith("check")||action.startsWith("scan")||action.startsWith("look")) {
			System.out.println(enemy);
		}
		else if(action.startsWith("reload")||action.startsWith("refill")) {
			player.Weapons.get(player.WeaponIndex).Reload();
		}
		else if(action.startsWith("obliterate")||action.startsWith("curse")) {
			System.out.println("\033[3mHidden command used...\033[0m");
			System.out.println(enemy.Name + "\033[3m is cast away to an obscure realm, never to be seen again...\033[0m");
			enemy.isAlive = false;
		} else if (action.startsWith("switch")) {
			player.switchWeapon();
		}
		else System.out.println("Invalid input! Turn wasted.");
	}
	
	public void enemyTurn() {
		try { 
			Thread.sleep(3000);
		} catch(InterruptedException ex){ 
			System.exit(0); 
		}
		System.out.println("\nIt is "+enemy.Name+"'s turn.");
		if(enemy.isBoss)player.notifyObservers(player.HP, player.ARM);
		try { 
			Thread.sleep(1500);
		} catch(InterruptedException ex){ 
			System.exit(0); 
		} 
		if(enemy.isAlive) {
			int atk = enemy.AI();
			if(atk>0) {
				player.receiveDMG(atk);
				if(player.HP<=0) player.isAlive = false;
				else if(atk!=0) player.status();
			}
		}
	}
	
	public static void start() {
		System.out.println("\nYou encounter "+enemy.Name + ".");
		
	}
	public static void end() {
		if(player.isAlive) {
			System.out.println("\nYou zeroed "+enemy.Name + " and gained 100 coins!");
			GameObjects.pc.balance += 100;
			
		}
		if (player.inRoom == 22 && !enemy.isAlive)
			player.hasWon = true;
		/*if(!player.isAlive) { 		dont need this because the program already prints the player dies.
			System.out.println("\nYou flatlined in battle!");
		}*/

	}
	
	public void Loop() {
		Encounter.start();
		while(player.isAlive && enemy.isAlive) {
			if(player.AP>=enemy.AP) {
				if(player.isAlive) playerTurn();
				if(enemy.isAlive) enemyTurn();
			}
			else if(player.AP<enemy.AP) {
				if(enemy.isAlive) enemyTurn();
				if(player.isAlive) playerTurn();
			}
		}
		Encounter.end();
	}
}
