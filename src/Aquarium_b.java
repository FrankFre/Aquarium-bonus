import java.util.Random;

public class Aquarium_b {

	// Klassenvariablen
	private static int breite;
	public static int hoehe;
	int a = 0; // Zählvariable
	int b = 0; // mit Wasser füllen
	int c = 0;
	int i = 0; // Zählvariable


	private Fisch[] fische;


	// Konstruktor für das Becken
	public Aquarium_b(int breite, int hoehe) {
		Aquarium_b.breite = breite;
		Aquarium_b.hoehe = hoehe;
	}

	/* getter und setter-Methoden */
	public static int getHoehe() {
		return Aquarium_b.hoehe;
	}

	public int getBreite() {
		return Aquarium_b.breite;
	}

//	Methode füllen füllt das Becken entsprechend seiner Höhe mit einer
//	entsprechenden Anzahl von Fischen
	public void fuellen() {
		
		Random zufall = new Random();

		int xzuf1, xzuf2; 
		
		this.fische = new Fisch[Aquarium_b.hoehe];
			
		// Es werden Fisch-Elemente jeweils eines pro Zeile angelegt
		for (int i = 0; i < Aquarium_b.hoehe; i++) {

			// Generieren eines zufälligen von 3 Fisch-Typen
			xzuf1 = zufall.nextInt(3);

			switch (xzuf1) {

			case 0:
				// generieren eines Zufalls-Wertes im Bereich Beckenbreite ohne die Länge Fisch
				xzuf2 = zufall.nextInt(Aquarium_b.breite - 11);
				fische[i] = new Haie(xzuf2, i, true);
				break;

			case 1:
				xzuf2 = zufall.nextInt(Aquarium_b.breite - 6);
				fische[i] = new Kugelf(xzuf2, i, true);
				break;

			case 2:
				xzuf2 = zufall.nextInt(Aquarium_b.breite - 5);
				fische[i] = new Schwertf(xzuf2, i, true);
				break;
			}
		}
	}

	public void anzeigen() {

		// Schleife so oft wie Aquariumhöhe:
		for (int i = 0; i < Aquarium_b.hoehe; i++) {

			Aquarium_b.gibRandAus();

			this.gibZeileAus(i);

			Aquarium_b.gibRandAus();

			System.out.println();
		}

		this.gibBodenAus();
	}

	private void gibBodenAus() {

		System.out.print('+');

		for (int c = 0; c < Aquarium_b.breite; c++) {
			System.out.print('-');
		}

		System.out.println('+');
	}

	private static void gibRandAus() {
		System.out.print('|');
	}

	
	
	
	// Hier wird eine Fisch Zeile aufgebaut für die String-Ausgabe

	private void gibZeileAus(int zeile) {
		
		
		//  UNSCHÖN WO DEKLARIEREN ??? immer wieder neu ?
		char[] reihe = new char[Aquarium_b.breite];
		
		
		for (b = 0; b < Aquarium_b.breite; b++) {
			reihe[b] = ' ';
		}

		// Iteration zur Suche der Fische in der Höhe der aktuell betrachteten Zeile
		for (a = 0; a < Aquarium_b.hoehe; a++) {

			if (fische[a].ypos == zeile) {
				
					// in das Ausgabe-Array schreiben
					for (b = 0; b < this.fische[a].laenge; b++) {

						reihe[fische[a].xpos + b] = fische[a].getShape().charAt(b);
					}
			}
		}

		
		for (i = 0; i <= Aquarium_b.breite - 1; i++) {

			System.out.print(reihe[i]);
		}

	}

//	Bewegen aller Fisch-Objekte entsprechend ihres konkreten Zustandes
	public void fischeBewegen() {

		for (int i = 0; i < Aquarium_b.hoehe; i++) {
			fische[i].bewegen(Aquarium_b.breite);
			System.out.println("Fisch " + i + ' ' + fische[i].getHoehe());
			
		}
	}
}
