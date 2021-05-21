package dp.longestIncreasingSubsequence;
// problem link : https://leetcode.com/problems/longest-increasing-subsequence/submissions/
import java.util.Arrays;

public class LongestIncreasingSubsequence {

   /*
        approach : recursive
            --> for every element we have 2 choices,
                --> either we an add it to the previously created subsequence or we don't add it
                --> we can only add a element if the previously added element in subsequence is smaller than current element.
                --> if we add the current element we add 1 to the recursive call which finds its subsequence length from next index

    */

    public int recursive( int[] nums){
        return recursiveHelper(-1,0,nums);
    }
    private  int recursiveHelper(int previ, int curri, int[] arr){
        if(curri==arr.length)
            return 0;
        if(previ==-1 || arr[previ] < arr[curri])
            return Math.max(1 + recursiveHelper(curri,curri+1,arr),
                    recursiveHelper(previ,curri+1,arr));
        return  recursiveHelper(previ,curri+1,arr);
    }

    /*  approach : memoization of above recursive approach
     --> we have 2 state variables , current index(curri) , index of previously added element(previ)
     --> as previ can have value -1 , we store ans in previ+1
     --> so time and space complexity : O(n^2)
     */
    public int memoization(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size+1][size+1];
        for(int i=0;i<=size;i++)Arrays.fill(dp[i],-1);
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

    // time complexity O(n^2) and space complexity O(n)
    /*  solution link : https://www.youtube.com/watch?v=fV-TF4OvZpk
        approach :
        --> create a 1D dp array in which dp[i] stores the length of longest increasing subsequence by considering nums[i] as its last element
        --> so for every i initially dp[i] = 1 as we can consider nums[i] as our answer
        --> we run a loop for every i , for a particular i, we means that how can we add nums[i] element to any subsequence created by elements btw 0 to i-1
        --> so we run a loop j from 0 to i-1 , where dp[j] represents ans which consider nums[j] as the last element of particular subsequence
        --> we check if nums[i] > nums[j] , it means we can add current ith element to the subsequence whose last element is nums[j]
        --> so we add 1 to the dp[j] to get ans for dp[i].
        --> find the max of dp array
     */
    public int bottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                max = Math.max(max,dp[i]);
            }

        return  max;
    }
}
