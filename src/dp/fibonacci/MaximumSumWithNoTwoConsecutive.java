package dp.fibonacci;
// problem link : https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
import java.util.Arrays;

public class MaximumSumWithNoTwoConsecutive {
    // time complexity O(2^n)
    /*
        approach :
            --> we have 2 choices , either take arr[i] and goto i+2
            --> or take arr[i+1]
     */
    public int FindMaxSum(int[] arr, int n){
        return recursiveHelper(arr,0);
    }
    private int recursiveHelper(int[] arr,int i){
        if(i>=arr.length)return 0;
        int c1 = arr[i] + recursiveHelper(arr,i+2);
        int c2 = recursiveHelper(arr,i+1);
        return Math.max(c1,c2);
    }
    // time and space complexity O(n)
    public int memoization(int arr[], int n){
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return memoHelper(arr,0, dp);
    }
    private int memoHelper(int[] arr, int i, int[] dp){
        if(i>=arr.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int c1 = arr[i] + memoHelper(arr,i+2,dp);
        int c2 = memoHelper(arr,i+1,dp);
        return dp[i] = Math.max(c1,c2);
    }
}
