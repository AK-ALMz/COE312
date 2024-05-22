import java.util.Random;

public abstract class Enemy{

	int HP;        		//HP, or Health Points, determines how much an entity can sustain getting damaged.
    int maxHP;
    int ARM;    		//ARM, or Armor, acts as a sort of extra health bar
    					//that must be depleted in order to target the enemy's HP.
    int maxARM;
    int AP;        		//AP, or Agility Points, determines order of turns, and dodge chance.
    int DMG;			//DMG, or Damage, determines the base damage of an enemy type
    int maxDMG;
    int XP;				//XP, or Experience Points, determine how much the player will gain upon beating the enemy
    String Name;   		//Names are used to distinguish between types of enemies
    boolean isBlocking; //indicates whether the enemy is blocking or not
    boolean isAlive;	//indicates whether an enemy is alive or not
    boolean isCharging; //indicates whether an enemy is charging or not
    boolean isBoss;
    BattleStrategy strategy;
    String desc;
    String id;
    Random r = new Random();

    public abstract int AI();
    
    public void execute() {
		strategy.execute();
	}
	
	public void setStrategy(BattleStrategy strategy) {
		this.strategy=strategy;
		System.out.print(Name);
		this.execute();
	}

    public int attack() {
    	int chance;
    	int attack = r.nextInt(-1, 3) + DMG;
				
		chance=r.nextInt(0,21);
    	if(chance>AP) { 
    		attack=0;
    		if(this.isBoss) System.out.println(Name+ " misses his shot!");
    		else System.out.println(Name+" misses their shot!");
    	}
    	return attack;

    }
    
    public void charge() {
    	System.out.println(Name+" charges a shot!");
    	DMG = DMG*2;
    	isCharging = true;
    }
    
    public void block() {
    	isBlocking = true;
    }
    
    public void receiveDMG(int x) {
		if (ARM>0) {
			if(isBlocking) x = x/2;
			ARM -=(x/2);
			if (ARM<0) ARM = 0;
			if(x>0)System.out.println(Name + " received " + (x/2) + " DMG to their ARM.");
			}
		else {
			if(isBlocking) x = x/2;
			if(x>0)System.out.println(Name + " received " + x + " DMG to their HP.");
			HP -=x;
		}
	}
    
    public void heal(int x) {
    	if(HP>0) HP +=x;
    	if(HP>maxHP) HP = maxHP;
    	System.out.println(Name + " healed for " + x + "HP.");
    }
    
    public void status() {
    	System.out.println(Name + " has " + HP + " HP and " + ARM + " ARM.");
    }
    
    
    public String toString(){
    	if(HP<=0) return Name + " is dead.";
    	else return Name + " has " + HP + " HP, " + ARM + " ARM, and " + AP + " AP!";
    }
    public void look() {
    	System.out.println(this);
    }
}