import java.util.*;

public class PuzzleJava {
    public ArrayList<Integer> sumArrayAndOver10 (int [] arr){
        int sum = 0;
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
            if (arr[i]>10){
                y.add(arr[i]);
            }
        }
        System.out.println(sum);
        System.out.println(y);
        return (y);
    }

    public ArrayList<String> shuffleAndOver5 (String [] arr){
        ArrayList<String> y = new ArrayList<String>();
        ArrayList<String> x = new ArrayList<String>();
        for (int i=0; i<arr.length; i++){
            x.add(arr[i]);
            if(arr[i].length()>5){
                y.add(arr[i]);
            }
        }
        Collections.shuffle(x);
        System.out.println(x);
        System.out.println(y);
        return y;
    }

    public void firstAndLastLetter (String [] arr){
        ArrayList<String> y = new ArrayList<String>();
        for (int i=0; i<arr.length; i++){
            y.add(arr[i]);
        }
        Collections.shuffle(y);
        System.out.println(y.get(25));
        if (y.get(0)=="a" || y.get(0)=="e" || y.get(0)=="i" || y.get(0)=="o" || y.get(0)=="u"){
            System.out.println(y.get(0)+" Is a vowel!");
        }
        else{
            System.out.println(y.get(0));
        }
    }

    public ArrayList<Integer> randomNumbers55To100 (){
        Random rng = new Random();
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            int x = rng.nextInt(45)+55;
            y.add(x);
        }
        System.out.println(y);
        return y;
    }

    public ArrayList<Integer> sortRandomNumbersArray (){
        ArrayList<Integer> y = randomNumbers55To100();
        Collections.sort(y);
        int min = y.get(0);
        int max = y.get(y.size()-1);
        System.out.println("The array is: "+y);
        System.out.println("The Min is: "+min);
        System.out.println("The Max is: "+max);
        return y;
    }

    public String randomString (String [] arr){
        String y = "";
        Random rng = new Random();
        for (int i=0; i<5; i++){
            int x = rng.nextInt(26);
            y+=arr[x];
        }
        // System.out.println(y);
        return y;
    }

    public void arrayOfRandomStrings (String [] arr){
        ArrayList<String> y = new ArrayList<String>();
        
        for (int i=0; i<10; i++){
            String x = randomString (arr);
            y.add(x);
        }
        System.out.println(y);
    }
}