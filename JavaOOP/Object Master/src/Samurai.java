import java.util.*;
public class Samurai extends Human {
	
	private static int number = 0;

	public Samurai() {
		number += 1;
		health = 200;
	}
	
	public void deathBlow (Human human) {
		human.setHealth(0);
		health = health/2;
	}
	
	public void meditate () {
		health += health/2;
	}
	
	public static int howMany () {
		return number;
	}

}
