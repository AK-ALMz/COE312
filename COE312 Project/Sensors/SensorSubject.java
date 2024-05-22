
public interface SensorSubject {
		public void registerObserver(SensorObserver o);
		public void removeObsever(SensorObserver o);
		public void publishMessage(Message m);
		}
