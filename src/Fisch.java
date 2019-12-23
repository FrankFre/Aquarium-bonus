import java.util.Random;

public abstract class Fisch {
	
	/* Instanzvariablen */

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
		zuf2 = (int) (1/this.getSprung()); 		// Faktor 2 erzeugt Ergebnis 0 und 1 jeweils für auf und ab-Sprung
//		System.out.println(this.getSprung());
//		zuf3 = zuf.nextInt(zuf2);
		zuf3 = 1;
		
			
		if ((this.ypos < this.getHoehe()) && (zuf3 == 1))   {
		
			this.ypos +=1;
			
		} else if ((this.ypos > 0) && (zuf3 == 0))   {
				
			this.ypos -=1;
			}
		
			
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



