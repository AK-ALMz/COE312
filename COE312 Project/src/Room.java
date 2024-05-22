import java.util.ArrayList;
import java.util.List;

public class Room {
int number;
String name;
ArrayList<String> descriptions = new ArrayList<String>();
ArrayList<String> exits = new ArrayList<String>();
ArrayList<NPC> npcs = new ArrayList<NPC>();
ArrayList<Enemy> enemies = new ArrayList<Enemy>();
ArrayList<Item> items = new ArrayList<Item>();
public Room(String name, int num) {
	this.name = name;
	this.number = num;
}

}
