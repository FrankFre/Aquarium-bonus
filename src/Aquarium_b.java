import java.util.Random;

public class Aquarium_b {

	private int breite;
	public int hoehe;
	int a, b, c, d, i = 0;

	private Fisch[] fische; /* Array von typ Fisch mit dem Namen fische */

	public char[] reihe;
	
	

	/* Konstruktor für das Becken, Masse müssen bei Aufruf angegeben werden */

	public Aquarium_b(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
	}

	/* getter und setter-Methoden entsprechend nach späterem Bedarf */

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getHoehe() {
		return this.hoehe;
	}

	public int getBreite() {
		return this.breite;
	}

	/*
	 * Methode füllen füllt das Becken entsprechend seiner Höhe mit einer
	 * entsprechenden Anzahl von Fischen
	 */

	public void fuellen() {

		// Aufruf des Konstruktors der Methode Zufall
		Random zufall = new Random();

		int xzuf1, xzuf2;

		// Array vom Typ Fisch namens fische in der Grösse hoehe wird angelegt
		this.fische = new Fisch[this.hoehe];

		// Es werden Fisch-Elemente pro Zeile angelegt
		for (int i = 0; i < this.hoehe; i++) {

			// Generieren eines zufälligen Fisch-Typs
			xzuf1 = zufall.nextInt(3);
			// System.out.println(this.hoehe+1);
			switch (xzuf1) {

			case 0:
				// generieren eines Zufalls-Wertes im Bereich Beckenbreite ohne die Länge Fisch
				xzuf2 = zufall.nextInt((breite - 9));
				fische[i] = new Haie(xzuf2, i, true);
//					System.out.println("xxx");
				break;

			case 1:
				xzuf2 = zufall.nextInt((breite - 5));
				fische[i] = new Kugelf(xzuf2, i, true);
				break;

			case 2:
				xzuf2 = zufall.nextInt((breite - 4));
				fische[i] = new Schwertf(xzuf2, i, true);
				break;
			}
		}
	}
	//

	public void anzeigen() {

		// Schleife so oft wie Aquariumhöhe:

		for (int i = 0; i < this.hoehe; i++) {

			// Gibt linken Rand vom Becken aus
			this.gibRandAus();

											// Gib eine Zeile Wasser mit Fisch aus
			this.gibZeileAus(i);

			// Gib rechten Rand vom Becken aus
			this.gibRandAus();

			System.out.println();
		}
		// Gib eine Zeile Aquariumboden aus
		this.gibBodenAus();
	}

	private void gibBodenAus() {

		System.out.print('+');

		for (int c = 0; c < this.breite; c++) {
			System.out.print('-');
		}
		System.out.println('+');
	}

	private void gibRandAus() {
		System.out.print('|');
	}
	
	
	

	/* Hier wird eine Fisch Zeile aufgebaut für die String-Ausgabe */

	private void gibZeileAus(int zeile) {

//		for (d = 0; d < 40; d++) { 			// Array wird mit Leerzeichen gefüllt
//			reihe[0] = 'x';
//		}

		for (a = 0; a < this.hoehe; a++) { 	// Iteration zur Suche der Fische in Höhe betreffender Zeile

			if (fische[zeile].ypos == zeile) {

				// Einsetzen des Strings des Fisch-Shapes
				if (this.fische[zeile].getDir()) {

					for (b = 0; b < this.fische[zeile].laenge; b++) {
						System.out.println(fische[zeile].ypos);
						
						reihe[b + fische[a].xpos] = fische[zeile].getShape().charAt(b);
					}

				} else {

					for (b = 0; b < this.fische[zeile].laenge; b++) {
						reihe[b + fische[a].xpos - fische[zeile].laenge] = fische[zeile].getShape().charAt(b);
					}

				}
			}
		for (i = 0; i > this.breite; i++ )   {
			System.out.print(reihe[i]);
			
		}
			
		}
		
		
		

//			int xwert = this.fische[zeile].getXpos();
//			
//			// erster Teil Wasser mit Leerzeichen linke Seite
//			for (int i = 0; i < (xwert); i++) {
//				System.out.print(' ');
//			}
//
//			// Einsetzen des Strings des Fisch-Shapes
//			if (this.fische[zeile].getDir()) {
//
//				System.out.print(fische[zeile].getShape());
//				
//
//			} else {
//				System.out.print(fische[zeile].getShape());
//			}
//
//			// zweiter Teil Wasser mit Berücksichtung der Shape_länge
//			for (int i = (xwert); i < (this.breite - fische[zeile].laenge); i++) {    
//				System.out.print(' ');
//			}

	}

	// Bewegen aller Fisch-Objekte entsprechend ihres konkreten Zustandes
	public void fischeBewegen() {

		for (int i = 0; i < this.hoehe; i++) {
			fische[i].bewegen(this.breite);
		}
	}

}
