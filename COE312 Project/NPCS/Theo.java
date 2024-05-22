
public class Theo extends NPC {
	public Theo() {
		this.name = "Theo";
		this.id = "theo";
		this.inRoom = 1;
	}
	@Override
	public void look() {
		System.out.println("Theo appears to be reading a book titled 'Was Neuralink a Mistake?'. ");
	}
	@Override
	public void talk(String[] splitInput) {
		//System.out.println("reached");
		if(splitInput.length < 3) {
			System.out.println("Theo: \"Need anything?\"");
		} else
		switch(splitInput[2]) {
		case ("family"):
			System.out.println("Theo: \"My family is none of your business...\"");
		break;
		case ("train"):
			System.out.println("Theo: \"Why were we given such awful seats. The stench from the bathroom is gonna make me vomit!\"");
		break;
		case ("mission"):
			System.out.println("Theo: \"Mika Takahashi, Leader of RejuveTech inc., was found to be guilty of producing "
					+ "and distributing TechTranq, the world's first Class-X drug.\" \n");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(" Theo: \"His company is well known for producing the powerful healing serum, NanoRejuve. However, "
				+ "investigations showed links to the ZeroZone, where TechTranq is the latest buzz.. \" \n");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Theo: \"Your mission is confront Mika Takahashi and take down his empire. Prepare yourself.\" \n");
		break;
		default:
			System.out.println("Theo: \"I don't get what you mean.\"");
			break;
		}
		
	}
	
	
}

