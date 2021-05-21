package dp.longestCommonSubsequence;

//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
public class MinNumberOfOperationsToTransformStringAToB {
    // time complexity O(nm)
    /*
        approach :
                --> for string s1 and s2 to be equal, we can make both to lcs using deletion of some character in both of them
                --> we remove or count those characters from s1 and s2 which are not present in lcs
                --> so ans = s1.length() + s2.length() - 2*lcs
     */
    public int minOperations(String s1, String s2)
    {   int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // if n==0 || m==0 dp[n][m] = 0
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        int lcsLength = dp[n][m];
        return s1.length() + s2.length() - 2*lcsLength;
    }
}
