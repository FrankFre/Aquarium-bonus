import java.util.Random;

public class Aquarium_b {

	// Klassenvariablen
	private static int breite;
	public static int hoehe;
	int a = 0; // Zählvariable
	int b = 0;
	int c = 0;
	int d = 0; // Breite
	int i = 0; // Zählvariable

	private Fisch[] fische;
	

	// Konstruktor für das Becken
	public Aquarium_b(int breite, int hoehe) {
		Aquarium_b.breite = breite;
		Aquarium_b.hoehe = hoehe;
	}

	/* getter und setter-Methoden */
	public int getHoehe() {
		return Aquarium_b.hoehe;
	}

	public int getBreite() {
		return Aquarium_b.breite;
	}

//	Methode füllen füllt das Becken entsprechend seiner Höhe mit einer
//	entsprechenden Anzahl von Fischen
	public void fuellen() {

		Random zufall = new Random();

		int xzuf1, xzuf2;  // Zufallswert Fischtyp und x-Koordinate

		// Array vom Typ Fisch namens fische entsprechend der hoehe wird angelegt (10)
		this.fische = new Fisch[Aquarium_b.hoehe];

		// Es werden Fisch-Elemente jeweils eines pro Zeile angelegt (10)
		for (int i = 0; i < Aquarium_b.hoehe; i++) {

			// Generieren eines zufälligen von 3 Fisch-Typen
			xzuf1 = zufall.nextInt(3);

			switch (xzuf1) {

			case 0:
				// generieren eines Zufalls-Wertes im Bereich Beckenbreite ohne die Länge Fisch
				xzuf2 = zufall.nextInt(Aquarium_b.breite -1);
				fische[i] = new Haie(xzuf2, i, true);
				break;

			case 1:
				xzuf2 = zufall.nextInt(Aquarium_b.breite -1);
				fische[i] = new Kugelf(xzuf2, i, true);
				break;

			case 2:
				xzuf2 = zufall.nextInt(Aquarium_b.breite -1);
				fische[i] = new Schwertf(xzuf2, i, true);
				break;
			}
		}
	}

	public void anzeigen() {

		// Schleife so oft wie Aquariumhöhe:
		for (int i = 0; i < Aquarium_b.hoehe; i++) {

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

		for (int c = 0; c < Aquarium_b.breite; c++) {
			System.out.print('-');
		}

		System.out.println('+');
	}

	private void gibRandAus() {
		System.out.print('|');
	}

	
	
	
	
	
	// Hier wird eine Fisch Zeile aufgebaut für die String-Ausgabe
	// es muss die Möglichkeit geschaffen werden, mehrere Fische in einer Zeile
	// darzustellen
	private void gibZeileAus(int zeile) {
		
		char[] reihe = new char[Aquarium_b.breite];

		// das Array für Ausgabezeile wird mit mit Wasser gefüllt
		for (d = 0; d < Aquarium_b.breite; d++) {

			reihe[d] = ' ';
		}

		// Iteration zur Suche der Fische in der Höhe der aktuell betrachteten Zeile
		for (a = 0; a < Aquarium_b.hoehe; a++) {
	
			if (fische[zeile].ypos == a) {
//
//				// Einsetzen des Shapes des Fisch-Objekts, das in der betrachteten Zeile
//				// unterwegs ist
//				// Fisch mit Richtung nach rechts

				if (this.fische[zeile].getDir()) { // Fisch mit dir = rechts true
//					// für die Länge des Strings des Fisches wird der String char 
//					// in das Ausgabe-Array geschrieben


					for (b = 0; b < this.fische[zeile].laenge; b++) {

						// Im reihe-Array wird an den entsprechenden x-Indizes der gewandelte
//						// String-Char eingesetzt
						reihe[b + fische[zeile].xpos] = fische[zeile].getShape().charAt(b);
					}
//
//				} else {
////
//					// für die Länge des Strings des Fisch wird der String char shape char für char
//					// in das Ausgabe-Array geschrieben

//					for (b = 0; b < this.fische[zeile].laenge - 2; b++) {

					// Im reihe-Array wird an den entsprechenden x-Indizes der gewandelte
//						// String-Char eingesetzt
//
//						reihe[b + fische[a].xpos - fische[zeile].laenge] = fische[zeile].getShape().charAt(b);
//					}
				}
			}
		}

		for (i = 0; i <= Aquarium_b.breite - 1; i++) {

			System.out.print(reihe[i]);
		}


//
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
//			} else {
//				System.out.print(fische[zeile].getShape());
//			}
//
//			// zweiter Teil Wasser mit Berücksichtung der Shape_länge
//			for (int i = (xwert); i < (this.breite - fische[zeile].laenge); i++) {
//				System.out.print(' ');
//			}

	}

	
	
	
	
	
//	Bewegen aller Fisch-Objekte entsprechend ihres konkreten Zustandes

	public void fischeBewegen() {

		for (int i = 0; i < Aquarium_b.hoehe; i++) {
			fische[i].bewegen(Aquarium_b.breite);
		}
	}
}
