
public class Aquarium_b_main {

	public static void main(String[] args) throws InterruptedException {
		
		/* Initialgrösse des Beckens */
		int x = 60;
		int y = 6;


//		1. Gegnerierung des Beckens mit festen Parametern

		Aquarium meinAquarium = new Aquarium(x, y);

//		2. Fische generieren anhand der Beckenhöhe mit fixen Parametern 

		meinAquarium.fuellen();
//			
//		3. alles anzeigen

		meinAquarium.anzeigen();
		
//		4. Schleife mit 3 Durchgängen duchs Becken

		meinAquarium.fischeBewegen();
//				- Fische bewegen um einen Schritt


		meinAquarium.anzeigen();
		meinAquarium.fischeBewegen();
//			- Fische bewegen um einen Schritt
//	 		- alles anzeigen

		
//		Iterationsschleife, um die Fische 2m zu bewegen
		
		for (int i = 0; i < (x * 2); i++) {
			
//			for (int j = 0; j < 20; j++) {				// Schleife zur Initialisierung einer "freien" Ausgabenkonsole
//				System.out.println();				
//				}
			
			meinAquarium.anzeigen();
			meinAquarium.fischeBewegen();
			Thread.sleep(200);							
			}

	}

}