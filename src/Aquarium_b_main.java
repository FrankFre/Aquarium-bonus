
public class Aquarium_b_main {

	public static void main(String[] args) throws InterruptedException {
		
		/* Initialgrösse des Beckens */
		int x = 60;
		int y = 10;

//		1. Gegnerierung des Beckens mit festen Parametern
		Aquarium_b meinAquarium = new Aquarium_b(x, y);

//		2. Fische generieren anhand der Beckenhöhe mit fixen Parametern 
		meinAquarium.fuellen();
		
//			- Fische bewegen um einen Schritt
//	 		- alles anzeigen
	//		Iterationsschleife, um die Fische 2x zu bewegen
		for (int i = 0; i < x; i++) {
//			// Schleife zur Initialisierung einer "freien" Ausgabenkonsole
			for (int j = 0; j < 20; j++) {	
				System.out.println();				
				}
					
			meinAquarium.anzeigen();
			meinAquarium.fischeBewegen();
			Thread.sleep(600);							
			}	
		
	}

}
