import java.util.*;
public class Dragon {
	
	private int energylevel;
	
	public Dragon () {
		this.energylevel = 300;
	}

	public int getEnergylevel() {
		return energylevel;
	}

	public void setEnergylevel(int energylevel) {
		this.energylevel = energylevel;
	}
	
	public void fly() {
		System.out.println("The dragon took off!");
		this.energylevel -= 50;
	}
	public void eatHumans() {
		this.energylevel += 25;
	}
	public void attackTown() {
		System.out.println("The town is on fire!");
		this.energylevel -= 100;
	}
}
