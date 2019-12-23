
public class Aquarium {

	private int breite;
	private int hoehe;
	private Fisch[] fische;
	
	/* Konstruktor für das Becken, Masse müssen bei Aufruf angegeben werden */ 
	
	/* this weist dem Objekt den übergebenen Wert zu */
	
	public Aquarium(int breite, int hoehe) {				
		this.breite = breite;
		this.hoehe = hoehe;
				
	}
	
	/* getter und setter-Methoden entsprechend nach späterem Bedarf */
	
	public int getHoehe()  {
		return this.hoehe;
	}
	
	public int getBreite()  {
		return this.breite;
	}
	
	
	
	// Methode füllen füllt das Becken entsprechend seiner Höhe mit einer entsprechenden Anzahl von Fischen
	
	public void fuellen()   {
	
	    this.fische = new Fisch[this.hoehe];   // Array vom Typ Fisch namens fische in der Grösse hoehe wird angelegt 
	    		   
	  
	    for (int i = 0; i < this.hoehe; i++) {
			
			fische[i] = new Fisch( 2, i, true);	 // Fischobjekte werden iterativ angelegt
		}

	}
	

	public void anzeigen() {
		// TODO Auto-generated method stub
	
		// Schleife so oft wie Aquariumhöhe:
		for (int i = 0; i < this.hoehe; i++) {
			
			//      Gibt linken Rand aus
			this.gibRandAus();
			//      Gib eine Zeile Wasser mit Fisch aus
			this.gibZeileAus(i);
			//      Gib rechten Rand aus
			this.gibRandAus();
			
			System.out.println();
		
		}
		//  Gib eine Zeile Aquariumboden aus
		this.gibBodenAus();
	}

	private void gibBodenAus() {
		
		System.out.print('+');

		for (int i = 0; i < this.breite; i++) {
			System.out.print('-');
			}
		System.out.println('+');
	}	
	
	private void gibRandAus()  {
		System.out.print('|');
	}
	
	private void gibZeileAus(int zeile)  {
		
		int xwert = this.fische[zeile].getXpos();
		
		for (int i = 0; i < (xwert-1); i++) {
			System.out.print(' ');
			}
		
		if(this.fische[zeile].getDir())  {
			System.out.print(Fisch.shape1);
			} else {
				System.out.print(Fisch.shape2);
			}
		for (int i = (xwert+3); i < this.breite; i++) {
			System.out.print(' ');
			}
	}

	public void fischeBewegen() {
		
		for (int i = 0; i < fische.length; i++) {
			fische[i].bewegen(this.breite);
			
		}
		
	// Schleife über alle fische:
	//	  fisch, beweg dich(maxBreite)
	}
}

	
//
//
//
//public static void ansichtZeichnen()   {
//	
//	for (int y = 0; y < 5; y++)  {
//		
//		for (int x = 0; x < 40; x++)  { 
//			
//			System.out.print(bild[y][x]);
//			}
//		
//		System.out.println(" ");
//		}
//	}	
//}
//	
	

//	for (int x = 0; x < 6; x++)  {
//		
//		for (int y = 0; y < 40; y++)  {
//			
//			System.out.println(bild[x][y]);
//				
//		}
//	}
//	
	
		

	
	



