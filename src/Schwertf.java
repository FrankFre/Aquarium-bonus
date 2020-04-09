
public class Schwertf extends Fisch  {
	

	static String shape1 = "><>-";
	static String shape2 = "-<><";
	static double sprung = 0.2f;

	
	/* Konstruktor */

	public Schwertf(int xpos, int ypos, boolean dir) {

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


@Override
protected int getHoehe() {
	// TODO Auto-generated method stub
	return 0;
}


}

