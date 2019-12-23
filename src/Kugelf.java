
public class Kugelf extends Fisch {
	
	static String shape1 = "><()>";
	static String shape2 = "<()><";
	static double sprung = 0.1f;

	
	/* Konstruktor */
	
	public Kugelf(int xpos, int ypos, boolean dir) {
//		String shape1 = "><()>";
//		String shape2 = "<()><";
//	    double sprung = 0.1f;
	    
//		super(xpos, ypos, dir, shape1, shape2, sprung);
		super(xpos, ypos, dir);
		this.laenge = shape1.length();

	}

	
	@Override
	public String getShape() {
			
			if (this.dir) {
				return Kugelf.shape1;
			} else {
				return Kugelf.shape2;
			}
		}


	@Override
	protected int getHoehe() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
