import java.util.ArrayList;
import java.util.Random;

public class PC extends ConcreteSubject implements Runnable{ 
	String name;
	int inRoom = 0;
	int HP;        		//HP, or Health Points, determines how much an entity can sustain getting damaged.
	int ARM;    		//ARM, or Armor, acts as a sort of extra health bar that must be depleted in order to target the enemy's HP.
	int AP;        		//AP, or Agility Points, determines order of turns, and dodge chance.
	int DMG;			//DMG, or Damage, determines the base damage of an enemy type
	//Names are used to distinguish between types of enemies
	boolean isBlocking; //indicates whether the player is blocking or not
	boolean isAlive;	//indicates whether the player is alive or not
	private Random r = new Random();  
	int balance = 1000;
	ArrayList<WeaponContext> Weapons = new ArrayList<WeaponContext>();
	int WeaponIndex;
	boolean hasKey;
	boolean hasWon;
	    public PC() {
			HP = 30;
			ARM = 20;
			AP = 16;
			DMG = 5;
			isBlocking = false;
			isAlive = true;
			Weapons.add(new Pistol()); //Start with a pistol + rifle
			Weapons.add(new  Rifle());
			WeaponIndex = 0; 
			hasKey = false;
			hasWon = false;
		}
	    
	    public int attack() {
	    	int chance;
	    	if(this.Weapons.get(WeaponIndex).currentAmmo==0) {
	    		return 0;
	    	}
	    	int attack = r.nextInt(-1, 4) + DMG + this.Weapons.get(WeaponIndex).damage;
	    	
	    	//chance to miss your attack. a number is chosen from 0-20, if the number chosen is HIGHER than your AP, you will miss.
	    	//basically having higher AP means you have a less chance to miss.
	    	chance=r.nextInt(0,21);
	    	if(chance>AP) { 
	    		attack=0;
	    		System.out.println("You miss your shot!");
	    	}
	    	
			return attack;
	    }

		public void receiveDMG(int x) {
			if(x==100) {//armor piercing round does flat damage to HP, bypassing ARM
				HP -=15;
				System.out.println("You received 15 DMG to your HP.");
			}
			else if (ARM>0 && x>0) {
				if(isBlocking==true) x = x/2;
				ARM -=(x/2);
				if (ARM<0) ARM = 0;
				if(x>0)System.out.println("You received " + (x/2) + " DMG to your ARM.");
				}
			else if(ARM<=0 && x>0) {
				if(isBlocking==true) x = x/2;
				HP -=x;
				if(x>0)System.out.println("You received " + x + " DMG to your HP.");
			}
			//if (HP<0) System.out.println("You died.");
		}
	    
	    public void heal(int x) {
	    	if(HP>0) HP +=x;
	    	System.out.println("You healed for " + x + "HP.");
	    }
	    
	    public void status() {
	    	System.out.println("You have " + HP + " HP and " + ARM + " ARM.");
	    }
	    
	    public String toString(){
	    	if(HP<=0) return name + " is dead.";
	    	else return "You have " + HP + " HP, " + ARM + " ARM, and " + AP + " AP!";
	    }
	public void look() {
		System.out.println(this);
		System.out.println("Current balance: " + balance);
		System.out.println("Weapons Held:");
		for (WeaponContext wp : Weapons)
			System.out.println(wp.name + ", Ammo: (" + wp.currentAmmo + "/" + wp.maxAmmo + ")" );
	}
	public void switchWeapon() {
		GameObjects.pc.WeaponIndex = (GameObjects.pc.WeaponIndex + 1) % GameObjects.pc.Weapons.size();
		System.out.println(GameObjects.pc.Weapons.get(GameObjects.pc.WeaponIndex).name + " Equipped");
	}
	@Override
	public void run() {
	}
	
}
