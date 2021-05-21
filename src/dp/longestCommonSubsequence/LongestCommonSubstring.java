package dp.longestCommonSubsequence;

/**
 * *******************************IMPORTANT*************************************************
 */
// problem link : https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "KXCGMTMVVGFQQWSPD";
        String s2 = "JXZADDUKVLQPKUZJZHWSUTPCAFSYA";
        System.out.println(memoization(s1,s2,s1.length(),s2.length()));

    }
    /*
        approach :
            --> base condition is if either string is empty ans is 0
            --> we return ans array of size 2, in which 0th index gives ans from substring for n and m , and 1st index denotes the maximum ans so far.
            --> if s1[n-1]!=s2[m-1]  , ans[0] = 0 as no common substring formed and ans[1] = max(ans[n-1][m][1],ans[n][m-1[1]) i.e. consider s1[n] and s2[m-1] and s1[n-1] and s2[m].
            --> if s1[n-1]==s2[m-1] , ans[0]  = 1 + ans[n-1][m-1][0] and ans[1] = max(ans[n-1][m],ans[n][m-1],ans[0])
     */
    // memoization of recursive solution , time complexity O(n*m)
    static int memoization(String s1, String s2, int n, int m){
        int[][][] dp = new int[n+1][m+1][2];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j] = new int[]{-1,-1};
        return memoHelper(s1,s2,n,m,dp)[1];
    }
    private static int[] memoHelper(String s1, String s2, int n, int m,int[][][] dp){
        if(n==0 || m==0)return new int[]{0,0};
        if(dp[n][m][0]!=-1)return dp[n][m];
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            int[] x = memoHelper(s1,s2,n-1,m-1,dp);
            return dp[n][m] = new int[]{x[0]+1,Math.max(x[0]+1,Math.max(x[0]+1,Math.max(memoHelper(s1,s2,n,m-1,dp)[1],memoHelper(s1,s2,n-1,m,dp)[1])))};
        }
        int[] x = memoHelper(s1,s2,n-1,m,dp);
        int[] y = memoHelper(s1,s2,n,m-1,dp);
        return dp[n][m] = new int[]{0,Math.max(Math.max(x[1],y[1]),Math.max(x[0],y[0]))};
    }
    // time complexity O(n*m)
    static int bottomUp(String s1, String s2, int n, int m){
        int[][][] dp = new int[n+1][m+1][2];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j][0] = dp[i-1][j-1][0]+1;
                    dp[i][j][1] = Math.max(Math.max(dp[i][j-1][1],dp[i-1][j][1]),dp[i][j][0]);
                }
                else{
                    dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i][j-1][1]);
                }
        return dp[n][m][1];
    }
}
