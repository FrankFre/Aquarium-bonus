
public class Kugelf extends Fisch {
	
	static String shape1 = "><()>";
	static String shape2 = "<()><";
	static float sprung = 0.1f;

	
	
	
	public float getSprung() {
		return sprung;
	}


	public Kugelf(int xpos, int ypos, boolean dir) {

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
