
public class Haie extends Fisch {

	/* Klassenvariablen */

	final static String shape1 = "><====\\\\\\>"; // seltsames Aussehen wegen der Erkennung der Backslashes als
													// Steuerzeichen
	final static String shape2 = "<///====><";
	public static float sprung = 0.25f;

	/* Konstruktor */

	public Haie(int xpos, int ypos, boolean dir) {
		super(xpos, ypos, dir);
		this.laenge = shape1.length();
	}

	public String getShape() {
		if (this.dir) {
			return Haie.shape1;
		} else {
			return Haie.shape2;
		}
	}

	public float getSprung() {
		return sprung;
	}

	public int getHoehe() {
		return ypos;
	}

}
