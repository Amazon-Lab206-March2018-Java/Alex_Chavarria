import java.util.*;
public class Gorilla extends Mammal {
	
	public Gorilla () {
		super();
	}
	public void throwSomething () {
		System.out.println("The Gorilla threw something at you!");
		super.setEnergylevel(-5);
	}
	public void eatBannanas () {
		System.out.println("The Gorilla ate a bannana");
		super.setEnergylevel(10);
	}
	public void climb () {
		System.out.println("The Gorilla climbed a tree");
		super.setEnergylevel(-10);
	}
}
