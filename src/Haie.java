
public class Haie extends Fisch {

	/* Klassenvariablen */

	public final static String shape1 = "><====XXX>";
	final static String shape2 = "<XXX====><";
	static double sprung = 0.25f;

	/* Konstruktor */

	public Haie(int xpos, int ypos, boolean dir) {
//		String shape1 = "><====\\>";
//		String shape2 = "<//====><";
//	    double sprung = 0.25f;
		super(xpos, ypos, dir);
// 		super(xpos, ypos, dir, shape1, shape2, sprung);		
		this.laenge = shape1.length();
	}

	@Override
	public String getShape() {
		if (this.dir) {
			return Haie.shape1;
		} else {
			return Haie.shape2;
		}
	}

}