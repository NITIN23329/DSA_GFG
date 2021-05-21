package oneDArray;
//find maximum arr[j]-arr[i] s.t. i<j
import java.util.Arrays;

public class MaxDiffInArray {
    public static void main(String[] args) {
        int[] arr = {30,10,8,2};
        System.out.println(find(arr,arr.length));
    }
    // what we can do it not use rightMax array instead take a variable
    // which keep track of maximum element found so far.
    private static int find(int[] arr,int n) {
        int[] rightMax = new int[n];
        rightMax[n-1] = -999999;
        int max = arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]= max;
            max = Math.max(max,arr[i]);
        }
        System.out.println(Arrays.toString(rightMax));
        int x = -9999;
        for(int i=0;i<n;i++)
            x=Math.max(x,rightMax[i]-arr[i]);
        return x;
    }
}
