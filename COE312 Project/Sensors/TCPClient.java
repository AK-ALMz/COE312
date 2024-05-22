
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class TCPClient extends ConcreteSensorSubject implements Runnable { 
	//gyroRotationY, magnetometerY, accelerometerAccelerationX
   static String host;
   static int port;
   static Socket socket;
   static InputStream input;
   InputStreamReader reader; 	
   BufferedReader br; 
   //reader is not static so all sensors can read the same line instead of each taking a separate line.
   String sensorName;
   double threshold;
   JSONParser parser = new JSONParser(); 
   TCPClient(String host, int port, String sensorName, double threshold) throws UnknownHostException, IOException{
	   TCPClient.host = host;
	   TCPClient.port = port;
	   this.sensorName = sensorName;
	   socket = new Socket(host,port);
	   input = socket.getInputStream();
	   reader = new InputStreamReader(input);  
	   br = new BufferedReader(reader); 
	   this.threshold = threshold;
	   Thread t = new Thread(this);
	   t.start();
   }
   TCPClient(String sensorName, double threshold) throws IOException{ 
	   this.sensorName = sensorName;   
	   reader = new InputStreamReader(input);  
	   br = new BufferedReader(reader);
	   this.threshold = threshold; 
	   Thread t = new Thread(this);
	   t.start(); 
   }
@Override
	public void run() {  
	double sensorReading;
		while (true) {
			sensorReading = readSensor(sensorName); 
			processReading(sensorReading, threshold);
		}
	}

  
	public double readSensor(String sensorName) {
		
		String line = ""; 
		double double_Value = 0;
		try {
			if ((line = br.readLine()) != null) {//read line by line 
				//System.out.println(line);
				JSONObject jsonObject = (JSONObject) parser.parse(line); 
				//System.out.println(jsonObject);
				String value = (String) jsonObject.get(sensorName); 
				//System.out.println( sensorName + " "+ value);
				double_Value = Double.parseDouble(value);	
				return double_Value;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void processReading(double reading, double threshold) {
		
		if (reading > threshold) {
			//System.out.println("Reading = " + reading);
			publishMessage(new Message(this,sensorName,"Threshold passed"));
		}
		try {
			Thread.currentThread().sleep(100); //small delay to not read a lot of values consecutively
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
