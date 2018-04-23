public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();


        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld 


        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer x = manipulator.getIndexOrNull(word, subString);
        Integer y = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(x); // 2
        System.out.println(y); // null

        String words = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(words); // eworld
    }

}