import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
	static ControlPanel p = new ControlPanel();
	public static ArrayList<String> readLines(String filename) throws IOException {
	        FileInputStream fin = new FileInputStream(filename);
	        BufferedInputStream bin = new BufferedInputStream(fin);
	        ArrayList<String> lines = new ArrayList<String>(); 
	        StringBuilder stringBuilder = new StringBuilder();
	        int ch = 0;
	        String formedLine = "";
	        while (bin.available() > 0) {
	        	ch = bin.read();
	            if (ch == '\n') {
	                lines.add(formedLine);
	                formedLine = "";
	            } else {
	                formedLine += (char)ch;
	            }
	        }
	        if (stringBuilder.length() > 0) {
	            lines.add(stringBuilder.toString());
	        }
	        bin.close();
	        fin.close();
	        return lines;
	    }

	
	public static void waitForInput() {
		if (GameObjects.pc.inRoom == 0) { //if the character is not loaded into the game yet (START OF GAME)
			createCharacter();
		}
		System.out.print(">");
		Scanner scan = new Scanner(System.in);
		String cmd = scan.nextLine();
		// parse the command by spaces
		// read each word into an array valueString s = "This is a sample
		// sentence.";
		String[] splitInput = cmd.split(" ");
		processCMD(splitInput, scan);
		
	}
	
	public static void processCMD(String[] splitInput, Scanner scan) { 
		//This part has the call to the list of commands
		//To understand, check the "look" example. Add the new commands under here
		switch(splitInput[0]) {
		case("look"):
			//look(splitInput);
			p.buttonWasPressed(0, splitInput);
			break;
		case("move"):
			//move(splitInput);
		p.buttonWasPressed(1, splitInput);
			break;
		case("battle"):
			//battle(scan);
			p.buttonWasPressed(2, scan);
			break;
		case("pickup"):
			//pickup(splitInput);
			p.buttonWasPressed(3, splitInput);
			break;
		case("talk"):
			//talk(splitInput);
			p.buttonWasPressed(4, splitInput);
			break;
		case("buy"):
			//buy(splitInput);
			p.buttonWasPressed(5, splitInput);
			break;
		case("gamble"):
			//gamble();
			p.buttonWasPressed(6);
			break;
		default:
			System.out.println("Invalid Input...");
			break;
		}	
	}
	
	public static void createCharacter() {
		System.out.println("Welcome to Akira City, Japan. Who are you?");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		GameObjects.pc.name = name;
		GameObjects.pc.inRoom = 1; // for debugging purposes
		System.out.println("Default values of HP/accurary/room will be set.");		
	}

	}


