
public class BossCyberware extends ConcreteObserver{
	//this is the work around because Boss cant extend the ConcreteObserver class
	//so the boss has some "cyberware"(Observer) which "targets" the player's vital signs to determine the Boss's AI
	Boss boss = new Boss(0, 0);
	public BossCyberware(Subject subject) {
		super(subject);
	}
	
	public void update(int hp, int arm) {
		System.out.println("Enemy cyberware is scanning your vitals... "+hp+" HP and "+arm+" ARM.");
		boss.scanHP=hp;
		boss.scanARM=arm;
	}
}