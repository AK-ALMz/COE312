import java.util.ArrayList;

public class ConcreteSubject implements Subject{
private ArrayList<Observer> observers;

	public ConcreteSubject(){
		observers = new ArrayList <Observer>();
	}
	
	public void notifyObservers(int hp, int arm) {
		for (int i =0; i<observers.size(); i++){
			Observer observer = observers.get(i);
			observer.update(hp, arm);
		}
	}
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObsever(Observer o) {
		observers.remove(o);
	}
}