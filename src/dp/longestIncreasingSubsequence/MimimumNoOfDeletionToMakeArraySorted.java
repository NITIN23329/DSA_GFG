package dp.longestIncreasingSubsequence;

import java.util.Arrays;

//problem link https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1#
/*  time and space complexity O(n^2) , we can reduce space complexity to O(n) by using the other approach of LIS
    approach :
        -->find length of Longest increasing subsequence
        --> remove all other elements not in LIS to get a sorted increasing array
        --> ans = arr.size - LIS length

 */
public class MimimumNoOfDeletionToMakeArraySorted {
    public int minDeletions(int[] arr, int n) {
        int lisLength = lis(arr,n);
        return n - lisLength;
    }
    public int lis(int[] nums,int size) {
        int[][] dp = new int[size+1][size+1];
        for(int i=0;i<=size;i++) Arrays.fill(dp[i],-1);
        return memoHelper(-1,0,nums,dp);
    }
    private  int memoHelper(int previ, int curri, int[] arr, int[][] dp){
        if(curri==arr.length)
            return 0;
        if(dp[previ+1][curri]!=-1)return dp[previ+1][curri];
        if(previ==-1 || arr[previ] < arr[curri])
            return dp[previ+1][curri] = Math.max(1 + memoHelper(curri,curri+1,arr,dp),
                    memoHelper(previ,curri+1,arr,dp));
        return  dp[previ+1][curri] = memoHelper(previ,curri+1,arr,dp);
    }
}
