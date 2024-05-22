
public class CombatTest {
	 static PC p= new PC();
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Fodder f = new Fodder();
		Elite el = new Elite();
		Boss b = new Boss(p.HP,p.ARM);
		b.setCyberwareTarget(p);
		SensorLoader s = new SensorLoader();
		s.getThread().join();

		
		//uncomment the kind of fight you want to test, then comment the others.
		//Encounter e = new Encounter(p,f); //fodder fight 
		//Encounter e = new Encounter(p,el); //elite fight
		Encounter e = new Encounter(p,b); //boss fight

	}
}