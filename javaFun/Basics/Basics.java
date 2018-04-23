import java.util.ArrayList;
import java.util.Arrays;

public class Basics{
    public void printOneTo255 (){
        for (int i=0; i<256; i++){
            System.out.println(i);
        }
    }

    public void oddNumbers1to255 (){
        for (int i=1; i<256; i+=2){
            System.out.println(i);
        }
    }

    public void sum (){
        int x = 0;
        for (int i=0; i < 256; i++){
            x += i;
            System.out.println("New Number: "+i+" Sum: "+x);
        }
    }

    public void iterateArray (int [] arr){
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public void findMax (int [] arr){
        int max = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public void getAverage (int [] arr){
        int avg = 0;
        for (int i=0; i<arr.length; i++){
            avg += arr[i];
        }
        avg = avg/arr.length;
        System.out.println(avg);
    }

    public void oddNumbersArray (){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i=1; i<256; i++){
            y.add(i);
        }
        System.out.println(y);
    }

    public void greaterThanY (int [] arr, int y){
            int count =0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>y){
                count ++;
            }
        }
        System.out.println(count);
    }

    public void squareTheValues (int [] arr){
        for (int i=0; i<arr.length; i++){
            arr[i]*=arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    public void eliminateNegativeNumbers (int [] arr){
        for (int i=0; i<arr.length; i++){
            if (arr[i]<0){
                arr[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void maxMinAverage (int [] arr){
        int min = arr[0];
        int max = arr[0];
        int avg = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]<min){
                min = arr[i];
            }
            else if (arr[i]>max){
                max = arr[i];
            }
            avg += arr[i];
        }
        avg = avg/arr.length;
        System.out.println("Min: "+min+" Max: "+max+" Avg: "+avg);
    }

    public void shiftValuesOfTheArray (int [] arr){
        for (int i=0; i<arr.length-1; i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=0;
        System.out.println(Arrays.toString(arr));
    }
}