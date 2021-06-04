package dp.others;

/** problem  link : https://cses.fi/problemset/task/1744/
 *
 */
public class RectangleCutting {
    /*
      --> Approach : use dp
      --> Time complexity : o(nmn + nmm), space complexity : O(nm)
      --> Cutting via min(n,m) is not optimal , consider case n=7, m=6
      --> base cases:
          --> if we have row  = 1, then we cut it to 1x1 cubes and ans = col - 1
          --> Similarly if col = 1 , then ans  = row-1.
      --> Otherwise we can make a cut either vertically and horizontally
      --> all horizontal cut can pass through row = 1 to n-1.
      --> all vertical cut can pass through col = 1 to m-1.
      --> Consider all situation and find min cuts for (n,m)

 */
    private static int countMinCuts( int n, int m) {
        int[][] dp;dp = new int[n+1][m+1];
        // initialization/ base case .
        // if row = 1 , then total cuts = col - 1
        // if col is 1 , then total cuts = row -1
        for(int j=1;j<=m;j++)dp[1][j] = j-1;
        for(int i=1;i<=n;i++)dp[i][1] = i-1;
        for(int i=2;i<=n;i++)
            for(int j=2;j<=m;j++){
                if(i==j)dp[i][j] = 0;   // row = col, hence it's a square
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int ii=1;ii<i;ii++) // cut every row and find answer
                        dp[i][j] = Math.min(dp[i][j],1 + dp[ii][j]+dp[i-ii][j]);
                    for(int jj=1;jj<j;jj++) // cut every col and find answer
                        dp[i][j] = Math.min(dp[i][j],1 + dp[i][jj]+dp[i][j-jj]);
                }
            }
        return dp[n][m];

    }
}
