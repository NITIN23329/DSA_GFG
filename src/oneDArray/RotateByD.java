package oneDArray;

import java.util.Arrays;


public class RotateByD {
    public static void main(String[] args) {
        int[] array  = {1,2,3,4,5,6,7};
        int d = 5;
        rotateUsingTempArray(array,d);
        rotateInPlace(array,d);

    }
    public static void rotateUsingTempArray(int[] array,int d){
        int[] temp = new int [array.length];
        int k = 0;
        for(int i=d;i<array.length;i++)
            temp[k++]=array[i];
        for(int i=0;i<d;i++)
            temp[k++]=array[i];
        System.out.println("using temp array : " +Arrays.toString(temp));
    }
    public static void rotateInPlace(int [] array , int d){
        reverse(array,0,d-1);
        reverse(array,d,array.length-1);
        reverse(array,0,array.length-1);
        System.out.println("using in place : " +Arrays.toString(array));
    }
    private static void reverse(int[] array,int start,int last){
        while (start<last){
            int temp = array[start];
            array[start]  = array[last];
            array[last]  = temp;
            start++;
            last--;
        }
    }
}
