package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/form-a-palindrome/0#
public class FormPalindrom {
    // time complexity O(n*n)
    /*
        approach :
            --> find length of longest palindrome in given string.
            --> answer is len(string) - length of longest palindrome
     */
    private static int formPalindrome(String str1,int n){
        int[][] dp = new int[n+1][n+1];
        String str2 = new StringBuilder(str1).reverse().toString();
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        return n - dp[n][n];
    }
}
