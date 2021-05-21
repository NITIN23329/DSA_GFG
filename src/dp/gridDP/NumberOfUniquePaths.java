package dp.gridDP;
// problem link : https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/
import java.util.Arrays;

public class NumberOfUniquePaths {
    // time complexity O(2^nm)
    // recursive codes
    public static int recursive(int a, int b) {
    return memoHelper(1,1,a,b);
    }
    private static int memoHelper(int x, int y, int n, int m){
        if(x>n || y>m)return 0;
        if(x==n && y==m)return 1;
        return memoHelper(x+1,y,n,m) + memoHelper(x,y+1,n,m);
    }

    // time and space complexity : O(nm)
    //memoization of recursive code
    public static int memoization(int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return memoHelper(1,1,n,m,dp);
    }
    private static int memoHelper(int x, int y, int n, int m, int[][] dp){
        if(x>n || y>m)return 0;
        if(x==n && y==m)return 1;
        if(dp[x][y]!=-1)return dp[x][y];
        return dp[x][y] = memoHelper(x+1,y,n,m,dp) + memoHelper(x,y+1,n,m,dp);
    }

    // time and space complexity : O(nm)
    // bottom up dp
    /* initialization step :
            --> if on a grid , we are at rightmost column,we have only one path to goto n,m by going downwards only
            --> if we are on down-most row , we only have 1 path to goto n,m by traversing to rightward only
            --> we will fill 1 on these cells of dp table
     */

    public static int bottomUp(int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][m] = 1;
        for(int j=0;j<=m;j++)
            dp[n][j] = 1;
        for(int i=n-1;i>=1;i--)
            for(int j=m-1;j>=1;j--)
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
        return dp[1][1];
    }
}
