public class HeldenApp{
	
	private Held shaggy;
	private Held frank; 
	
	public void kampfVorbeiten()
	{
		shaggy = new Held("Shaggy", 2500, 700, 40, false, new Waffe("Ashbringer", 150, "Zweihand-Schwert"), 1);
		frank = new Held("Frank White", 2000, 850, 40, true, new Waffe("Blutschrei", 350, "Zweihand-Axt"), 1);
	}
		
	public void kampf(int speed) {
		kampf(frank, shaggy, speed);
	}
	
	public void kampf(Held angreifer, Held verteidiger, int speed) {
		
		String nameAngreifer = angreifer.getName();
		String nameVerteidiger = verteidiger.getName();
		
		// Text des Kampfgeschehen
		System.out.println( nameAngreifer + " greift " + nameVerteidiger + " an! \n\n");
		
		//Die Helden begrüßen sich
		System.out.println(angreifer.vorstellen() + "\n" + verteidiger.vorstellen());
		
		//Die Helden kämpfen
		while (angreifer.getLifepoints() > 0 && verteidiger.getLifepoints() > 0) {
				
			verzoegere(speed);
			
			System.out.println(nameAngreifer + " greift mit " + angreifer.getWaffe().getWaffenName() 
								+ " (" + angreifer.getWaffe().getWaffenArt() + ") an."); 

			System.out.print(nameAngreifer + " schlägt " + nameVerteidiger + "!\n"
					+ nameVerteidiger + " erleidet Schaden von " 
					+ angreifer.schlagen(verteidiger) + " und hat noch "
					+ verteidiger.getLifepoints() + " Lebenspunkte. \n\n");
			
			speed = 3500;
			verzoegere(speed);
			if (verteidiger.getLifepoints() < 500 && verteidiger.getHealpot() > 0) {
				verteidiger.getHealpot();
				verteidiger.setLifepoints(+500);
				System.out.println(nameVerteidiger + ": Ich brauche schnell einen Trank");
				verteidiger.setHealpot(0);
			}
			
			if (verteidiger.getLifepoints() > 0) {
				
				System.out.println(nameVerteidiger + " greift mit " + verteidiger.getWaffe().getWaffenName() 
									+ " (" + verteidiger.getWaffe().getWaffenArt() + ") an."); 
			// Verteidiger schlägt zurück
				System.out.println(nameVerteidiger + " schlägt " + nameAngreifer + "!\n"
						+ nameAngreifer + " erleidet Schaden von " 
						+ verteidiger.schlagen(angreifer) + " und hat noch "
						+ angreifer.getLifepoints() + " Lebenspunkte. \n\n");
			}
			 if (angreifer.getLifepoints() < 500 && angreifer.getHealpot() > 0) {
				angreifer.getHealpot();
				angreifer.setLifepoints(+500);
				System.out.println(nameAngreifer + ": Ich brauche schnell einen Trank");
				angreifer.setHealpot(0);
			}	
	}
		
		//Ein Held stirbt
		if (angreifer.getLifepoints() > 0) {
			System.out.println( verteidiger.sterben());
		}else{
			System.out.println(angreifer.sterben());
		}
	}
	public void verzoegere(int millisekunden){
		try {
			Thread.sleep(millisekunden);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
