package dp.zeroOneKnapsack;
/** *************************************IMPORTANT****************************************
 * problem link : https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#
 *
 */

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    // recursive solution , time complexity O(2^n)
    // for very element in array , we can either put it to set 1 or to set 2
    // find which arrangement will leads to minimum value of (subset sum of set 1 - subset sum of set 2)
    public int recursive(int[] arr, int n) {
        return recursiveHelpr(0,0,0,arr);
    }
    private int recursiveHelpr(int i,int curr1, int curr2,int[] arr){
        if(i==arr.length)
            return Math.abs(curr1-curr2);
        int x = recursiveHelpr(i+1,curr1+arr[i],curr2,arr);
        int y = recursiveHelpr(i+1,curr1,curr2+arr[i],arr);
        return Math.min(x,y);
    }
    // time complexity O(2*n*sum) , memoization
    /*
        --> recursive approach is to add every element to either set
        --> if we do memoization of recursive approach , the state variable would be i,curr1 and curr2
        --> so the dp array would be 3D and time complexity would be O(n*sum*sum).
        --> we can reduce the # of state variables
        --> we initially calculate sum of whole array = sum.
        --> so assume subset sum of either set = curr , => subset sum of other set  = sum - curr.
        --> so now the state variable is i and curr.
        --> if we choose arr[i] to  set 1, but still we need to remove arr[i] value from sum to get subset sum of other set.
        --> an alternative way of doing above step is to add arr[i] twice to set1 , one arr[i] value will simply added to subset sum of set1
                and other arr[i] will be used to tackle the decrement of subset sum of other set by arr[i]
     */
    public int memoization(int[] arr, int n) {
        int sum = 0;
        for(int ele : arr)sum+=ele;
        int[][] dp = new int[n][2*sum+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return memoHelpr(0,0,sum,arr,dp);
    }
    private int memoHelpr(int i,int curr, int sum,int[] arr,int[][] dp){
        if(i==arr.length)
            return Math.abs(curr-sum);
        if(dp[i][curr]!=-1)return dp[i][curr];
        int x = memoHelpr(i+1,curr+2*arr[i],sum,arr,dp);
        int y = memoHelpr(i+1,curr,sum,arr,dp);
        return dp[i][curr] = Math.min(x,y);
    }
}
