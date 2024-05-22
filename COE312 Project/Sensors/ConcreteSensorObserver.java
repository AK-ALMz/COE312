

public class ConcreteSensorObserver implements SensorObserver {

	ConcreteSensorSubject [] subject = null;
	//Sensors are: gyroRotationY, magnetometerY, accelerometerAccelerationX
	public ConcreteSensorObserver(ConcreteSensorSubject[] subject) {
		
		this.subject = subject;
	
		for(int i = 0; i<subject.length; i++) {
			subject[i].registerObserver(this);
		}

	}

	@Override
	public synchronized void update(Message m) {
		switch(m.topic) {
		case "gyroRotationY":
			System.out.println("Switching weapon...");
			//function call
			GameObjects.pc.switchWeapon();
			//CombatTest.p.WeaponIndex = (CombatTest.p.WeaponIndex + 1) % CombatTest.p.Weapons.size();
			//System.out.println(CombatTest.p.Weapons.get(CombatTest.p.WeaponIndex).name + " Equipped");
			//^^ this line is for testing in CombatTest.java
			break;
		case "magnetometerY":
			System.out.println("Picking up items...");
			GameLogic.p.buttonWasPressed(3, new String[1]);
			break;
		case "accelerometerAccelerationX":
			System.out.println("Reloading weapon...");
			//function call
			GameObjects.pc.Weapons.get(GameObjects.pc.WeaponIndex).Reload();
			//CombatTest.p.Weapons.get(GameObjects.pc.WeaponIndex).Reload();
			//^^ this line is for testing in CombatTest.java
			break;
		}
			
			
	}
	
	public void update() {
		System.out.println("no input arguments");
	}
	
	
}