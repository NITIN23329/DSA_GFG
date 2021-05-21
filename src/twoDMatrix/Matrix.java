package twoDMatrix;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] arr = new int[5][];
        // here we created 2d array , having total 5 1d arrays. the size of each individual array may be different
        // here each 1d array need not to be contiguous as 2d array  contains reference to 1d array.
        // but each 1d array is contiguous

        for(int i=0;i<arr.length;i++)
            arr[i] = new int[(i+1)*10];
        for(int[] ele : arr) System.out.println(Arrays.toString(ele));


    }
}
