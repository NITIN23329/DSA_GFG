package dp.longestCommonSubsequence;
/**
 * *************************************IMPORTANT*************************************
 */
//problem link : https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem?isFullScreen=true
// solution link ; https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
import java.util.ArrayList;
import java.util.Arrays;

public class PrintingLongestCommonSubsequence {
    // time complexity O(2^nm)
    static int[] recursive(int[] a, int[] b) {
        int n = a.length; int m = b.length;
        ArrayList<Integer> list = recursiveHelper(a,b,n,m);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i] = list.get(i);
        return res;
    }
    private static ArrayList<Integer> recursiveHelper(int[] a, int[] b, int n, int m){
        if(n==0 || m==0)
            return new ArrayList<>();
        if(a[n-1]==b[m-1]){
            ArrayList<Integer> list = recursiveHelper(a,b,n-1,m-1);
            list.add(a[n-1]);
            return list;
        }
        ArrayList<Integer> list1 = recursiveHelper(a,b,n-1,m);
        ArrayList<Integer> list2 = recursiveHelper(a,b,n,m-1);
        return list1.size()>list2.size() ? list1 : list2;
    }
    // solution is almost same as longestCommonSubsequence
    // time and space complexity O(nm)
    // to find the sequence , track back the path we used to go from n=0,m=0 to n=n,m=m.
    // fill the dp table by taking example and do dry run
    // if a[n-1]==b[m-1] , we did 1 + ans(n-1,m-1) ,so] add a[n-1] to our result and goto n-1,m-1
    // else if a[n-1]!=b[m-1],  we did max( ans(n-1,m) , ans(n,m-1)),  so goto max of them
    static int[] memoization(int[] a, int[] b) {
        int n = a.length; int m = b.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        int len = memoHelper(a,b,n,m,dp);
        int[] res = new int[len];
        int i = n, j = m;
        int idx = len-1;
        while(i>0 && j>0){
            if(a[i-1]==b[j-1]){
                res[idx--] = a[i-1];
                i--;j--;
            }
            else if (dp[i-1][j]>dp[i][j-1])i--;
            else j--;
        }
        return res;

    }
    private static int memoHelper(int[] a, int[] b, int n, int m, int[][] dp){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m] !=-1)  return dp[n][m];
        if(a[n-1]==b[m-1]){
            return dp[n][m] = 1 + memoHelper(a,b,n-1,m-1,dp);
        }
        return dp[n][m] = Math.max(memoHelper(a,b,n-1,m,dp), memoHelper(a,b,n,m-1,dp));
    }
    // time and space complexity O(nm)
    static int[] bottomUp(int[] a, int[] b) {
        int n = a.length; int m = b.length;
        int[][] dp = new int[n+1][m+1];
        // base case when n==0 || m==0 dp[n][m] = 0.
        // creating dp table
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(a[i-1]==b[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        // length of longest common subsequence if size n,m is at dp[n][m]
        int[] lcs = new int[dp[n][m]];
        int i = n;int j = m;int idx = lcs.length-1;
        // tracking back the path we used to go from i=0,=0 to i=n,j=m
        //using  i=n,j=m to i=0,j=0
        // we can not get our subsequence if we traverse from 0,0 to n,m
        while(i>0 && j>0){
            if(a[i-1]==b[j-1]){
                lcs[idx--] = a[i-1];
                i--;
                j--;
            }
            else if (dp[i-1][j]>dp[i][j-1])i--;
            else j--;
        }
        return lcs;

    }
}
