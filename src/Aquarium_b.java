import java.util.Random;

public class Aquarium_b {

	private static int breite;
	public int hoehe;
	int a =0;
	int b = 0;
	int c = 0;
	int d = 0; 		// breite
	int i = 0;

	private Fisch[] fische;

	// Konstruktor für das Becken, Masse müssen bei Aufruf angegeben werden
	public Aquarium_b(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
	}

	/* getter und setter-Methoden entsprechend späterem Bedarf */

	public int getHoehe() {
		return this.hoehe;
	}

	public int getBreite() {
		return this.breite;
	}

//	Methode füllen füllt das Becken entsprechend seiner Höhe mit einer
//	entsprechenden Anzahl von Fischen

	public void fuellen() {

		Random zufall = new Random();

		int xzuf1, xzuf2;

		// Array vom Typ Fisch namens fische in der Eigenschaft hoehe wird angelegt (40)
		this.fische = new Fisch[this.hoehe];

		// Es werden Fisch-Elemente jeweils eines pro Zeile angelegt
		for (int i = 0; i < this.hoehe; i++) {

			// Generieren eines zufälligen Fisch-Typs
			xzuf1 = zufall.nextInt(3);

			// System.out.println(this.hoehe+1);

			switch (xzuf1) {

			case 0:
				// generieren eines Zufalls-Wertes im Bereich Beckenbreite ohne die Länge Fisch
				xzuf2 = zufall.nextInt((breite - 9));
				fische[i] = new Haie(xzuf2, i, true);
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

	// Hier wird eine Fisch Zeile aufgebaut für die String-Ausgabe
	// es muss die Möglichkeit geschaffen werden, mehrere Fische in einer Zeile darzustellen
	private void gibZeileAus(int zeile) {

		char[] reihe = new char[Aquarium_b.breite];

//		// Array für Ausgabezeile wird mit Leerzeichen initialisiert - mit Wasser gefüllt
		for (d = 0; d < this.getBreite() - 2; d++) {

			reihe[d] = 'x';
		}
		

		for (a = 0; a < this.hoehe - 1; a++) { // Iteration zur Suche der Fische in Höhe der akuell betrachteten Zeile

			if (fische[zeile].ypos == zeile) {
//
//				// Einsetzen des Shapes des Fisch-Objekts, das in der betrachteten Zeile
//				// unterwegs ist
//
//				// Fisch mit Richtung nach rechts
//
				if (this.fische[zeile].getDir()) { // Fisch mit dir = rechts
//
//					// für die Länge des Strings des Fisches wird der String char für char in das
//					// Ausgabe-Array geschrieben
//
					for (b = 0; b < this.fische[zeile].laenge - 2; b++) {

//						System.out.println(fische[zeile].ypos);

						// Im reihe-Array wird an den entsprechenden x-Indizes der gewandelte
//						// String-Char eingesetzt
						reihe[b + fische[a].xpos] = fische[zeile].getShape().charAt(b);
					}

				} else {
//
//					// für die Länge des Strings des Fisch wird der String char shape char für char
//					// in das Ausgabe-Array geschrieben

					for (b = 0; b < this.fische[zeile].laenge - 2; b++) {

						// Im reihe-Array wird an den entsprechenden x-Indizes der gewandelte
//						// String-Char eingesetzt
//
						reihe[b + fische[a].xpos - fische[zeile].laenge] = fische[zeile].getShape().charAt(b);
					}
				}
			}
//
//			for (i = 0; i > this.breite - 2; i++) {
//
//				System.out.print(reihe[i]);
//			}
//
//			System.out.println();
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
	}

//	Bewegen aller Fisch-Objekte entsprechend ihres konkreten Zustandes

	public void fischeBewegen() {

		for (int i = 0; i < this.hoehe; i++) {
			fische[i].bewegen(this.breite);
		}
	}
}
