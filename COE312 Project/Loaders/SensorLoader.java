import java.io.IOException;

public class SensorLoader extends LoaderTemplate {
	public SensorLoader(){
		t = new Thread(this);
		t.start();
	}
	@Override
	public void initializeData() {
		try {
			System.out.println("Getting Sensors Up and Running...");
			TCPClient c1 = new TCPClient("192.168.0.131",63296, "gyroRotationY", 8);
			TCPClient c2 = new TCPClient("magnetometerY", 200);
			TCPClient c3 = new TCPClient("accelerometerAccelerationX", 1.4);
			ConcreteSensorSubject[] s = {c1,c2,c3};
			SensorReader reader = new SensorReader(s);
			System.out.println("Sensors Are Up.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void LoadData() {
	}

}
