public class Boss extends Enemy{
	
	//this is the work around because we cant extend the ConcreteObserver class
	//so the boss has some "cyberware"(Observer) which "targets" the player's vital signs to determine the AI
	BossCyberware optics;
	public void setCyberwareTarget(Subject subject) { 
		optics = new BossCyberware(subject);
	}
	int scanHP;
	int maxScanHP;
	int scanARM;
	int maxScanARM;
	boolean isChargingARM;
	public Boss(int playerHP, int playerARM) {
		HP = 60;
		maxHP = HP;
		ARM = 20;
		maxARM = ARM;
		AP = 18;
		DMG = 13;
		maxDMG = DMG;
		XP = 150;
		Name = "Mika";
		isAlive = true;
		isCharging = false;
		isChargingARM = false;
		isBoss = true;
		this.scanHP = playerHP;
		this.maxScanHP = scanHP;
		this.scanARM = playerARM;
		this.maxScanARM = scanARM;
		id = "boss";
		desc = "Your target, Mika Takahashi, is here...";
	}
	
	 public void pierceCharge() {
	    	System.out.println(Name+" loads an armor piercing shot!");
	    	DMG = DMG*2;
	    	isChargingARM = true;
	    }
	public int pierceAttack() {
    	int chance;
    	int attack = 100;
				
		chance=r.nextInt(0,21);
    	if(chance>AP-10) { 
    		attack=0;
    		System.out.println(Name+" misses his shot!");
    	}
    	return attack;

    }

	public int AI() {
		isBlocking = false;
		int atk = 0;
		int chance;
		//if player has max health and any amount of armor, boss will either use armor piercing rounds(50%) or shoot normally(50%)
		//note that armor piercing rounds, have a high chance to miss
		//if player has >50% of health and no armor, boss charge attack(25%), or block(25%), or shoot normally(50%)
		//if player has <50% of health, boss will shoot normally(50%), or charge(50%)
		if(isCharging==true) {
			this.setStrategy(new ChargedOffensiveStrategy());
			atk = attack();
			isCharging=false;
			DMG = maxDMG; //damage is reset back to normal after using their charged attack
		}
		else if(isChargingARM==true) {
			this.setStrategy(new ArmorPiercingStrategy());
			atk = pierceAttack();
			isChargingARM=false;
			DMG = maxDMG;
		}
		else if(scanHP==maxScanHP && scanARM>0) {//first
			chance = r.nextInt(0, 4);
			if(chance<=1) {//shoot normally
				this.setStrategy(new OffensiveStrategy());
				atk = attack();
			}
			else {
				//use armor piercing shot
				pierceCharge();
			}
		}
		else if(scanHP>(maxScanHP/2) && scanARM<=0) {//second
			chance = r.nextInt(0, 4);
			if(chance==0) {//charge
				charge();
			}
			else if (chance==1){//block
				this.setStrategy(new DefensiveStrategy());
				block();
			}
			else {//shoot normally
				this.setStrategy(new OffensiveStrategy());
				atk = attack();
			}
		}
		else if(scanHP<(maxScanHP/2)) {//third
			chance = r.nextInt(0, 4);
			if(chance<=1) {//charge
				charge();
			}
			else{//shoot normally
				this.setStrategy(new OffensiveStrategy());
				atk = attack();
			}
		}
		return atk;
	}
}
