public interface State {
	public void next(WeaponContext context);
	public String Status(); //String because will be used later as state identifier.
}