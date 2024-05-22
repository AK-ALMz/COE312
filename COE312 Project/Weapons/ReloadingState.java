
public class ReloadingState implements State{

	@Override
	public void next(WeaponContext context) {
		System.out.println("Starting Reload...");
		try {
			Thread.currentThread().sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Weapon Reloaded.");
		context.currentAmmo = context.maxAmmo;
		context.setState(new HasAmmoState());
	}

	@Override
	public String Status() {
		return "Reloading";
	}

}
