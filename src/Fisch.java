import java.util.Random;

public abstract class Fisch {
	
	/* Instanzvariablen */

	public static char[] getShape;					// unklar char-Array ?
	
	int xpos; 				// Position x-Achse
	int ypos; 				// Ebene der Schwimmrichtung
	boolean dir; 			// Schwimmrichtung rechts ist true
    int laenge=0; 			// Länge des Fisches
//	String shape;			// Umriss des Fisches
	
    int zuf2, zuf3;
    
    

	/* Konstruktor */

	public Fisch(int xpos, int ypos, boolean dir) {

		this.xpos = xpos;
		this.ypos = ypos;
		this.dir = dir;
//		this.shape = shape;
//		this.laenge = laenge;
	}
	
	
	Random zuf = new Random();
	

	
	/* getter und setter Methoden */
	
	public int getXpos() {

		return xpos;
	}
	
	public int getYpos() {

		return ypos;
	}

	public boolean getDir() {

		return dir;
	}
	


	// Bewegen der Fisch-Koordinate - linkes Ende vom Fisch ist der Bezugspunkt 
	
	public void bewegen(int breite) { 			// breite ist Aquarium-Breite
		
		/* Berechnung des Wechsel-Ereignisses für den Etagenwechsel */
		zuf2 = (int) (1/this.getSprung()); 			// Faktor 2 erzeugt Ergebnis 0 und 1 jeweils für auf- und ab-Sprung
//		System.out.println(this.getSprung());
//		zuf3 = zuf.nextInt(zuf2);
		zuf3 = 1;									// Test-Wertzuweisung - 1 setzte den y-Wert um eins höher
		
			
		if ((this.ypos < this.getHoehe()) && (zuf3 == 1))   {		// Fisch schwimmt eine Ebene höher
		
			this.ypos +=1;
			
		} else if ((this.ypos > 0) && (zuf3 == 0))   {				// y-Koordinate um eine Ebene tiefer
				
			this.ypos -=1;
			}
		
		
		
		if (this.dir == true) {										// x-Koordinate um einen Wert nach rechts, falls Rand noch nicht errreicht

			if (this.xpos < (breite - this.laenge - 1)) {
				this.xpos += 1;
	
			} else {												// x-Koordinate um einen Wert nach links
				this.dir = false;									// Wert-Zuweisung nach Erreichen rechter Rand
				this.xpos -= 1;										// Bewegung nach links
			}
			
			
		} else {													// Bedingung für links-Bewegung

			if (this.xpos > 0) {									// Bewegung vor Erreichen Beckenrand
				this.xpos -= 1;
			
				
			} else {												// x-Position erreicht linken Rand
				this.dir = true;									// Bewegungsumkehr nach rechts
				this.xpos += 1;
			}	
	
		}
	}


	protected abstract int getHoehe();

	public String getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getSprung() {
		// TODO Auto-generated method stub
		return 0;
	}

}



