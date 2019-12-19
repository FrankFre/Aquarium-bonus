
public class Schwertf extends Fisch  {
	

	static String shape1 = "><>-";
	static String shape2 = "-<><";
	static double sprung = 0.2f;

	
	/* Konstruktor */

	public Schwertf(int xpos, int ypos, boolean dir) {
//	String shape1 = "><>-";
//	String shape2 = "-<><";
//  double sprung = 0.2f;
    
	super(xpos, ypos, dir);
	this.laenge = shape1.length();
}

	
@Override
public String getShape() {
		
		if (this.dir) {
			return Schwertf.shape1;
		} else {
			return Schwertf.shape2;
		}
	}


}

