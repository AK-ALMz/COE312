import java.util.Scanner;

public interface Command {
	public void execute(String[] splitInput);
	public void execute();
	public void execute(Scanner scan);
}
