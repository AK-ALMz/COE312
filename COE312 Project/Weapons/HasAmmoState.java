
public class HasAmmoState implements State {

	@Override
	public void next(WeaponContext context) {
		context.setState(new noAmmoState());
	}

	@Override
	public String Status() {
		return "Loaded";
	}

}
