public class StringManipulator {
    public String trimAndConcat (String str1, String str2){
        return str1.trim().concat(str2.trim());
    }
    public Integer getIndexOrNull (String str1, char c){
        return str1.indexOf(c);
    }
    public Integer getIndexOrNull (String str1, String str2){
        return str1.indexOf(str2);
    }
    public String concatSubstring(String str1, int num1, int num2, String str2){
        return str1.substring(num1,num2).concat(str2);
    }
}