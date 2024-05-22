public class Elite extends Enemy {
	public Elite() {
		HP = 25;
		maxHP = HP;
		ARM = 10;
		maxARM = ARM;
		AP = 17;
		DMG = 11;
		maxDMG = DMG;
		XP = 50;
		Name = "Elite";
		isAlive = true;
		isCharging = false;
		isBoss=false;
		id = "elite";
		desc = "A dangerous elite is present in this room...";
	}

	//elites are more strategic than fodder.
	//if they have max armor, they will always charge an attack, and attack in their next turn
	//if they charge an attack, they will ALWAYS attack in the next turn
	//if they have health and some armor they'll either attack(25%) or charge(75%)
	//if they have no armor, they'll either attack(25%), charge(25%), or block(50%)
	
	public int AI() {
		isBlocking = false;
		int atk = 0;
		int chance;
		if(isCharging==true) {
			this.setStrategy(new ChargedOffensiveStrategy());
			atk = attack();
			isCharging=false;
			DMG = maxDMG; //damage is reset back to normal after using their charged attack
		}
		else if(ARM == maxARM && isCharging==false) {
			charge();
		}
		else if(ARM>0 && ARM<maxARM && isCharging==false) {
			chance = r.nextInt(0, 4);
			if(chance<=2) {
				charge();
			}
			else {
				this.setStrategy(new OffensiveStrategy());
				atk = attack();
			}
		}
		else if(ARM<=0) {
			chance = r.nextInt(0, 4);
			if(chance<=1) {
				this.setStrategy(new DefensiveStrategy());
				block();
			}
			else if(chance==2){
				this.setStrategy(new OffensiveStrategy());
				atk = attack();
			}
			else {
				charge();
			}
		}
		return atk;
	}
}
