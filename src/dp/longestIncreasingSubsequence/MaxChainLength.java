package dp.longestIncreasingSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/max-length-chain/1#
import java.util.Arrays;

class Pair
{
    int x;
    int y;

    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}
public class MaxChainLength {
    // time complexity O(2^n)
    // approach is same as LIS
    // one thing is reorder is allowed so sort them according to y values
    int recursive(Pair[] arr, int n)

    {   Arrays.sort(arr , (a,b)->(a.y-b.y));
        return recursiveHelper(-1,0,arr);
    }
    private int recursiveHelper(int previ,int curri,Pair [] arr){
        if(curri==arr.length)
            return 0;
        if( previ==-1 || arr[previ].y < arr[curri].x)
            return Math.max(1 + recursiveHelper(curri,curri+1,arr),
                    recursiveHelper(previ,curri+1,arr));
        return recursiveHelper(previ,curri+1,arr);
    }
    // time and space complexity O(n^2)
    int memoization(Pair[] arr, int n){
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        Arrays.sort(arr , (a,b)->(a.y-b.y));
        return memoHelper(-1,0,arr,dp);
    }
    private int memoHelper(int previ, int curri, Pair [] arr, int[][] dp){
        if(curri==arr.length)
            return 0;
        if(dp[previ+1][curri]!=-1)return dp[previ][curri];
        if( previ==-1 || arr[previ].y < arr[curri].x)
            return dp[previ+1][curri] = Math.max(1 + memoHelper(curri,curri+1,arr,dp),
                    memoHelper(previ,curri+1,arr,dp));
        return dp[previ+1][curri] = memoHelper(previ,curri+1,arr,dp);
    }
    public int bottomUp(int[][] pair) {
        Arrays.sort(pair,(a,b)->(a[1]-b[1]));
        int max = 0;
        int[] dp = new int[pair.length];
        for(int i=0;i<pair.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++)
                if(pair[i][0]>pair[j][1])
                    dp[i] = Math.max(dp[i],1 + dp[j]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
