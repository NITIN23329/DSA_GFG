package dp.gridDP;
import java.util.Arrays;
// problem link : https://leetcode.com/problems/out-of-boundary-paths/
public class OutOfBoundaryPaths {
        public int findPaths(int n, int m, int k, int x, int y) {
            return (int)recursiveHelper(x,y,k,n,m);
        }
        private long recursiveHelper(int x, int y, int k,int n,int m){
            if(x==n || y==m || x==-1 || y==-1)
                return 1;
            if(k==0)return 0;
            long left = recursiveHelper(x,y+1,k-1,n,m);
            long right = recursiveHelper(x,y-1,k-1,n,m);
            long up = recursiveHelper(x-1,y,k-1,n,m);
            long down = recursiveHelper(x+1,y,k-1,n,m);
            return (left+right+up+down)%((int)1e9+7);
        }
    // time and space complexity O(n*m*k)
    public int memoization(int n, int m, int k, int x, int y) {
        long[][][] dp = new long[n][m][k+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                Arrays.fill(dp[i][j],-1);
        return (int)memoHelper(x,y,k,n,m,dp);
    }
    private long memoHelper(int x, int y, int k,int n,int m,long[][][] dp){
        if(x==n || y==m || x==-1 || y==-1)
            return 1;
        if(k==0)return 0;
        if(dp[x][y][k]!=-1)return dp[x][y][k];
        long left = memoHelper(x,y+1,k-1,n,m,dp);
        long right = memoHelper(x,y-1,k-1,n,m,dp);
        long up = memoHelper(x-1,y,k-1,n,m,dp);
        long down = memoHelper(x+1,y,k-1,n,m,dp);
        return dp[x][y][k] = (left+right+up+down)%((int)1e9+7);
    }
}
