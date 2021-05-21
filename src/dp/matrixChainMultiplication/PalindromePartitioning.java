package dp.matrixChainMultiplication;

import java.util.Arrays;

/**
 * ***********************IMPORTANT*****************************
 * problem link : https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
 *
 */
public class PalindromePartitioning {
    /*
        approach :
            --> we try to partition every k from 0 to n-1
            --> before partitioning check if the string s[l...r] is a palindrome or not?
            --> if palindrome , no need to partition and return 0
            --> else try out all possible combinations from l to r-1, for every k in l to r-1
                    -->  ans = f(l,k) + f(k+1,r) + 1 , 1 for partitioning at index k
                    --> find min of all combinations
     */
    static int recursive(String str) {
        return recursiveHelper(0,str.length()-1,str);
    }
    static int recursiveHelper(int l, int r,String str){
        // initially check if the string[l,r] is a palindrome or not,  if yes return 0
        int left = l , right = r;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))break;
            left++;
            right--;
        }
        if(left>=right)return 0;
        int ans = Integer.MAX_VALUE;
        for(int mid = l; mid<r;mid++){
            int a = recursiveHelper(l,mid,str);
            int b = recursiveHelper(mid+1,r,str);
            ans = Math.min(ans,1+a+b);
        }
        return ans;
    }
    // time complexity O(n^3) and space complexity O(n^2)
    static int memoization(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for(int i=0;i<str.length();i++)
            Arrays.fill(dp[i],-1);
        return memeoHelper(0,str.length()-1,str,dp);
    }
    static int memeoHelper(int l, int r, String str, int[][] dp){
        if(dp[l][r]!=-1)return dp[l][r];
        int left = l , right = r;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))break;
            left++;
            right--;
        }
        if(left>=right)return dp[l][r] = 0;
        int ans = Integer.MAX_VALUE;
        for(int mid = l; mid<r;mid++){
            int a = memeoHelper(l,mid,str,dp);
            int b = memeoHelper(mid+1,r,str,dp);
            ans = Math.min(ans,1+a+b);
        }
        return dp[l][r] = ans;
    }
}
