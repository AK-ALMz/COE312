import java.util.Random;

public class Fodder extends Enemy {
	Random r = new Random();
	public Fodder() {
		HP = 20;
		maxHP = HP;
		ARM = 5;
		maxARM = ARM;
		AP = 13;
		DMG = 7;
		maxDMG = DMG;
		XP = 25;
		Name = "Fodder";
		isBlocking = false;
		isAlive = true;
		isCharging = false;
		isBoss=false;
		id = "fodder";
		desc = "A Fodder is present in this room...";
	}
	//they only have two available actions: attacking and defending
	//they will always attack as long as they have armor
	//if no armor, there is a 50% chance they'll guard
	public int AI() {
		isBlocking = false;
		int atk = 0;
		int chance;
		if(ARM>0) {
			this.setStrategy(new OffensiveStrategy());
			atk = attack();
		}
		else if(ARM==0 && HP>0) {
			chance = r.nextInt(0, 4);
			if(chance<=1) {
				this.setStrategy(new DefensiveStrategy());
				block();
			}
			else {
				this.setStrategy(new OffensiveStrategy());
				atk = attack();
			}
		}
		return atk;
	}
}
