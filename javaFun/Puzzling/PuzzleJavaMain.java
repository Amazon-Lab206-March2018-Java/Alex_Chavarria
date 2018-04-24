public class PuzzleJavaMain {
    public static void main (String [] args){
        PuzzleJava puzzle = new PuzzleJava();
        int [] x = {3,5,1,2,7,9,8,13,25,32};
        String [] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        // puzzle.sumArrayAndOver10(x);
        // puzzle.shuffleAndOver5(names);
        // puzzle.firstAndLastLetter(alphabet);
        // puzzle.randomNumbers55To100();
        // puzzle.sortRandomNumbersArray();
        // puzzle.randomString(alphabet);
        puzzle.arrayOfRandomStrings(alphabet);
    }
}