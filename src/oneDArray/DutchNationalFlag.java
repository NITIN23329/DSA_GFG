package oneDArray;
//problem link : https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2,1,0,2,1,0,2,1,1,1,0,0};
        dutchFlagAlgo(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    // another algo :
    // count no of 1 ,0 ,2 and update the given arrays accordingly
    //time complexity O(2n)
    //
    //
    //time complexity O(n)
    //maintain 3 pointer low,mid,high which keep boundary of 0,1,and 2 elements
    // whenever you see 0  in mid, swap it with low and increment low
    //whenever you see 2  in mid, swap it with high and decrement high
    public static void dutchFlagAlgo(int[] arr , int n){
        int low =0,mid = 0,high=n-1;
        while (mid<=high){
            if(arr[mid]==1) {
                mid++;
                continue;
            }
            if(arr[mid]==0) {
                swap(arr,mid, low );
                low++;
            }
            if(arr[mid]==2){
                swap(arr,mid,high);
                high--;
            }
            if(arr[mid]==1 || (mid<low))mid++;

        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
