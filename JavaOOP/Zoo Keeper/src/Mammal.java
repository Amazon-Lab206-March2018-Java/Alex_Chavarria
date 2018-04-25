import java.util.*;
public class Mammal {
	private int energylevel;
	
	public Mammal () {
		this.energylevel = 100;
	}
	
	public int displayEnergy () {
		System.out.println(this.energylevel);
		return this.energylevel;
	}

	public void setEnergylevel(int energylevel) {
		this.energylevel += energylevel;
	}
}
