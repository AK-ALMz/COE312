import java.util.Scanner;

public class ControlPanel {
	 Command[] slots;	
	  public ControlPanel() { 
		LookCommand c0 = new LookCommand();
		MoveCommand c1 = new MoveCommand();
		BattleCommand c2 = new BattleCommand();
		PickupCommand c3 = new PickupCommand();
		TalkCommand c4 = new TalkCommand();
		BuyCommand c5 = new BuyCommand();
		GambleCommand c6 = new GambleCommand();
		Command[] s = {c0, c1, c2,c3,c4,c5,c6};
		slots = s;
	  }
	  public void buttonWasPressed(int index, String[] splitInput){ 
			  slots[index].execute(splitInput);
		  }
	  public void buttonWasPressed(int index) {
		  slots[index].execute();
	  }
	  public void buttonWasPressed(int index, Scanner scan) {
		  slots[index].execute(scan);
	  }
}