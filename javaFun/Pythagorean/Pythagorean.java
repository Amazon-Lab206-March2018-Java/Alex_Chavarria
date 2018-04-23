public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        // the hypotenuse is the side across the right angle. 
        // calculate the value of c given legA and legB
        legA *= legA;
        legB *= legB;
        double hypotenuse = Math.sqrt(legA+legB);
        return hypotenuse;
    }
}
