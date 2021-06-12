/*
    created by: nitin23329
    on Date: 12/06/21
*/
package dp.digitDP;
// problem link : https://lightoj.com/problem/palindromic-numbers
import java.util.Arrays;

/**
 *  Approach : use Digit dp, time and space complexity : O( logn * logn * 2 * 2)
 *  --> For a number to be palindrome,
 */
public class Problem4PalindromeNumber {
    static int[][][][] dp = new int[20][20][2][2];
    private static int solve(long a, long b){
        long l = Math.min(a,b);
        long r = Math.max(a,b);
        int ans = helper(r) ;
        ans -= (l==0?0:helper(l-1));
       return ans;

    }
    private static int helper(long n){
        if(n==0)return 1;   // 0 is considered as a palindrome
        int digitLength = (int)( 1 + Math.log10(n));
        int[] digitArray = new int[digitLength];
        for(int i = digitLength-1;i>=0;i--){
            digitArray[i] = (int)(n % 10);
            n/=10;
        }
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++)
                for(int k=0;k<2;k++)
                    Arrays.fill(dp[i][j][k],-1);
        int ans = memo(0,digitLength-1,0,1,digitArray);
        // the edge case when we make a num palindrome > r.
        // Like if the r = 10, but we assumed num = 11 as a possible answer, so remove it.
        // there is only 1 palindrome that can be created which exceeds r and added by our memo()
        for(int i=(digitLength-1)/2; i>=0;i--){
            if(digitArray[digitLength-i-1]<digitArray[i]){
                ans--;
                break;
            }
            else if(digitArray[digitLength - i - 1]>digitArray[i])break;
        }
        return ans;
    }
    private static int memo(int l, int r,int canPlaceZero,int isBound,int[] digitArray){
        if(l>r)return 1;
        if(dp[l][r][canPlaceZero][isBound]!=-1)return dp[l][r][canPlaceZero][isBound];
        int ans = 0;
        int maxDigit = isBound == 1? digitArray[l]: 9;
        for(int digit = 0;digit<=maxDigit;digit++) {
            if (digit == 0 && canPlaceZero == 0)
                ans += memo(l + 1, r, 0, 0, digitArray);
            else ans += memo(l + 1, r - 1, 1, (isBound == 1 && digitArray[l] == digit) ? 1 : 0, digitArray);
        }
        return dp[l][r][canPlaceZero][isBound] = ans;
    }
}
