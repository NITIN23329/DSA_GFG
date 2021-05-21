package recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9,-2,12,3,0,3,16,-8,4,3};
        sortRecursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    private static void sortRecursive(int[] arr,int n){
        if(n==1)
            return;
        sortRecursive(arr,n-1);
        int ii = n-2;
        int x= arr[n-1];
        while (ii>=0){
            if(arr[ii]<x)
                break;
            else
                arr[ii+1] = arr[ii];
            ii--;
        }
        arr[ii+1] = x;
    }
}
