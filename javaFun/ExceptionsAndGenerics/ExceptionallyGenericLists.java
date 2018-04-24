import java.util.*;

public class ExceptionallyGenericLists{
    public void run(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        System.out.println(myList);
        for(int i=0; i<myList.size(); i++){
            try{
                Integer castedValue = (Integer) myList.get(i);
            }catch(ClassCastException e){
                System.out.println("Error on index "+i);
            }
        }
    }
}