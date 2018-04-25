import java.util.*;

public class Ninja extends Human{

	public Ninja() {
		stealth = 10;
	}
	
	public void steal (Human human) {
		human.setHealth(human.getHealth()-10);
		this.health = this.health + 10;
	}
	
	public void runAway () {
		this.health =this.health - 10;
	}

}
