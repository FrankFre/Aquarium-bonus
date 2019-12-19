
public abstract class Fisch {
	
	
	/* Instanzvariablen */

	int ypos; 				// Ebene der Schwimmrichtung
	int xpos; 				// Position x-Achse
	boolean dir; 			// Schwimmrichtung rechts ist true
    int laenge=0; 			// Länge des Fisches
//	String shape;			// Umriss des Fisches
	

	/* Konstruktor */

	public Fisch(int xpos, int ypos, boolean dir) {

		this.xpos = xpos;
		this.ypos = ypos;
		this.dir = dir;
//		this.shape = shape;
//		this.laenge = laenge;
	}

	
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
	


	// Bewegen der Fisch-Koordinate - linkes Ende vom Fisch ist der Bezugsapunkt 
	
	public void bewegen(int breite) { 			// Aquarium-Breite

		if (this.dir == true) {

			if (this.xpos < (breite-this.laenge)) {

				this.xpos += 1;
			} else {
				this.dir = false;
				this.xpos -= 1;
			}
			
		} else {

			if (this.xpos > 0) {

				this.xpos -= 1;
			} else {
				this.dir = true;
				this.xpos += 1;
			}	
	
		}
	}


	public String getShape() {
		// TODO Auto-generated method stub
		return null;
	}


}



