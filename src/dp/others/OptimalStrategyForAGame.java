package dp.others;
import java.util.Arrays;
/**
 **************************************IMPORTANT******************************************
 * problem link : https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
 * problem link : https://leetcode.com/problems/predict-the-winner/
 */
public class OptimalStrategyForAGame {
    // time complexity O(4^n)
    /*
        approach :
            --> we can either choose left or right coin which gives us the max value.
            --> now its opponent turn , he will also choose that left or right coin which gives him the maximum value
                 --> or we can say which gives us the minimum value.
            --> so choice 1 is we pick arr[l] coin and now opponent has 2 choices ,  arr[l+1] or arr[r],
            --> he will pick either coin so that we get minimum
            --> choice1 = arr[l] + min( f(l+2,r) , f(l+r,r-1) )
            --> similarly if we pick arr[r] , opponent can either pick arr[l] or arr[r-1]
            --> choice2 = arr[r] + min ( f(l+1,r-1) , f(l,r-2))
            --> basically, we try to maximise 1st move , opponent try to maximize in 2nd move ,then we try to maximize in 3rd move and so on
            --> here we will take 2 consecutive recursive call and make it one which gives answer for us only and not for opponent
            x

     */
    static long recursive(int[] arr, int n){
        return recursiveHelper(arr,0,n-1);
    }
    private static long recursiveHelper(int[] arr, int l,int r){
        if(l>r)return 0;
        long c1 = arr[l] + Math.min(recursiveHelper(arr,l+2,r), recursiveHelper(arr,l+1,r-1));
        long c2 = arr[r] + Math.min(recursiveHelper(arr,l,r-2), recursiveHelper(arr,l+1,r-1));
        return Math.max(c1,c2);
    }

    // memoization of above recursive solution
    // time and space complexity O(n^2)
    static long memoization(int[] arr, int n){
        long[][] dp = new long[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return memoHelper(arr,0,n-1,dp);
    }
    private static long memoHelper(int[] arr, int l, int r, long[][] dp){
        if(l>r)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        long c1 = arr[l] + Math.min(memoHelper(arr,l+2,r,dp), memoHelper(arr,l+1,r-1,dp));
        long c2 = arr[r] + Math.min(memoHelper(arr,l,r-2,dp), memoHelper(arr,l+1,r-1,dp));
        return dp[l][r] = Math.max(c1,c2);
    }
}
