
public class noAmmoState implements State {

	@Override
	public void next(WeaponContext context) {
		context.setState(new ReloadingState());
		//System.out.println("Empty mag, will begin reloading");
		//context.nextState();
	}

	@Override
	public String Status() {
		return "No Ammo";
	}

}
