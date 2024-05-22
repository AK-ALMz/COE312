

public abstract class WeaponContext {
	 private State state = new HasAmmoState(); //TODO - Change later
	 int maxAmmo;
	 int currentAmmo;
	 int damage; 
	 int price;
	 String name;
	 public WeaponContext(int maxAmmo, int damage, String name) {
		super();
		this.maxAmmo = maxAmmo;
		this.currentAmmo = maxAmmo; //Weapon is loaded at the start
		this.damage = damage;
		this.name = name;
	}
	public void nextState() {
	 state.next(this);
	 }
	 public void checkStatus() { //prints and checks status, makes the call to next state if necessary
		 if (currentAmmo == 0 && state.Status().equals("Loaded")) {
			 //moves from hasAmmo to noAmmo, but not from noAmmo to Reloading.
			 nextState();
		 }
		 //System.out.println(name +" status: " + state.Status()); "Zayd: i commented this line cuz it makes the combat text look cluttered"
		 if (state.Status().equals("Loaded") || state.Status().equals("No Ammo")) {
			 System.out.println("Current Ammo: " + currentAmmo + "/" + maxAmmo);  
			 }
	 
	 }
	public void setState(State state) {
	this.state = state;
	}
	public int Shoot() {
		if (currentAmmo > 0) {
			currentAmmo--;
			checkStatus();
			return damage;
		}
		//System.out.println(currentAmmo);
		System.out.println("You try to shoot, but you're out of ammo!");
		return 0;
	}
	public synchronized void Reload() {
		if(currentAmmo <= 0) {
			setState(new ReloadingState());
			nextState(); //To start transitioning into "HasAmmo"
		} else {
			//System.out.println(currentAmmo);
			System.out.println("Magazine isn't empty");
		}
		
	}
		
	}
	

