import java.util.*;
public class Human {
	
	protected int strength;
	protected int intelligence;
	protected int stealth;
	protected int health;
	
	public Human () {
		strength = 3;
		intelligence = 3;
		stealth = 3;
		health = 100;
	}
	
	public void attack (Human human) {
		human.setHealth(human.getHealth()-this.getStrength());
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}
	
	
}
