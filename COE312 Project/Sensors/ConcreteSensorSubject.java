
import java.util.ArrayList;

public class ConcreteSensorSubject implements SensorSubject {
	private ArrayList<SensorObserver> observers;

	public ConcreteSensorSubject() {
		observers = new ArrayList<SensorObserver>();
	}

	// change notify observer to send message
	public void publishMessage(Message m) {
		for (int i = 0; i < observers.size(); i++) {
			SensorObserver observer = (SensorObserver) observers.get(i);
			//observer.update();
			observer.update(m);
		}
	}

	public void registerObserver(SensorObserver o) {
		observers.add(o);
	}

	public void removeObsever(SensorObserver o) {
		observers.remove(o);
	}

	
}