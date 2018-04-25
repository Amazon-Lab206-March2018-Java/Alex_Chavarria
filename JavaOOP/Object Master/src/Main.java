
public class Main {

	public static void main(String[] args) {
		Human human = new Human();
		Human human1 = new Human();
		human1.attack(human);
		System.out.println(human.getHealth());
	}

}
