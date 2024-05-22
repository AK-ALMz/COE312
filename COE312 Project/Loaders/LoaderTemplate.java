
public abstract class LoaderTemplate implements Runnable {
	Thread t;
	
	@Override
	public void run() {
		initializeAndLoad();
	}
	final public void initializeAndLoad() {
		initializeData();
		LoadData();
	}
	public abstract void initializeData();
	public abstract void LoadData();
	public Thread getThread() {
		return t;
	}
	
}
