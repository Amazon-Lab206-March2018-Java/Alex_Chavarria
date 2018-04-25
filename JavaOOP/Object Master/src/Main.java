import java.util.*;
public class Main {

	public static void main(String[] args) {
		Samurai sam1 = new Samurai();
		Samurai sam2 = new Samurai();
		Wizard wiz1 = new Wizard();
		Ninja nin1 = new Ninja ();
		sam1.deathBlow(wiz1);
		System.out.println(Samurai.howMany());
	}

}
