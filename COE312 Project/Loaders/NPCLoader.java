
public class NPCLoader extends LoaderTemplate {
	public NPCLoader() {
		t = new Thread(this);
		t.start();
	}

	@Override
	public void initializeData() {
		System.out.println("Initializing NPC database...");
        GameObjects.DataBaseNPCs.add(new Theo());
        GameObjects.DataBaseNPCs.add(new WeaponSmith());
        GameObjects.DataBaseNPCs.add(new Dealer());
        System.out.println(" NPC Database initialized.");
	}
	@Override
	public void LoadData() {
		for (NPC npc : GameObjects.DataBaseNPCs) {
			synchronized (GameObjects.roomlist.get(npc.inRoom).npcs) {
				/*Note: only Syncing the npcs list within a specific room instead 
				of the whole room/the whole roomlist, because doing so is unnecessary */
				GameObjects.roomlist.get(npc.inRoom).npcs.add(npc);	
			}
		}
		System.out.println("NPC Loading Complete");
	}

}
