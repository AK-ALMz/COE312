
public class SensorReader extends ConcreteSensorObserver implements Runnable {
	public SensorReader(ConcreteSensorSubject[] subject) {
		super(subject);
		System.out.println("Activating sensors...");
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		//Do nothing, Messages printed through "update"
	}

}
