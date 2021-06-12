/*
    created by: nitin23329
    on Date: 10/06/21
*/
package dp.digitDP;
// problem link : https://www.spoj.com/problems/GONE/
// solution link : https://www.youtube.com/watch?v=sCwokuCoQB8
/**
    Approach : Use digit dp, time and space: O(len * sum * 2), len  = logn, sum = 9 * logn, =  O(logn * logn)
    --> Let f(r) will give us the count of numbers whose digit sum is prime.
    --> Then ans= f(r) - f(l-1)
    --> let f(r) = G(i,sum,isBounded), where i tells the index if the digit we are processing,
            sum is the sum of digit0,1,...i-1 index, isBounded tells whether we need to bound ith digit by the ith digit of r or not..

    --> At ith digit, we can put any digit from 0 to 9 if it is not bounded and add it to sum
    --> If bounded, we can only by digit from 0 to r[i] at ith digit.
    --> Base case is when we successfully place all digits, then if sum is prime return 1 otherwise 0.
 */
public class Problem1$Gone {
    private static int solve(int l, int r) {
        int[][][] dp1 = new int[10][90][2];
        int[][][] dp2 = new int[10][90][2];
        for(int i=0;i<dp1.length;i++)
            for(int j=0;j<dp1[0].length;j++){
                dp1[i][j] = new int[]{-1,-1};
                dp2[i][j] = new int[]{-1,-1};
            }

        return digitDP(0,0,0,findDigitArray(r),dp1) -
                (l>1?digitDP(0,0,0,findDigitArray(l-1),dp2):0);
    }
    private static int digitDP(int i,int sum,int isBounded,int[] digitsOfR,int[][][] dp){
        if(i==digitsOfR.length)
            return firstDivisor(sum) == -1 ?1:0;
        if(dp[i][sum][isBounded]!=-1)return dp[i][sum][isBounded];
        int ans = 0;
        if(isBounded==1 || i == 0){
            for(int digit = 0;digit <= digitsOfR[i];digit++)
                ans += digitDP(i+1,sum + digit,digit == digitsOfR[i]?1:0,digitsOfR,dp);
        }
        else {
            for(int digit = 0; digit <= 9; digit++)
                ans += digitDP(i+1,sum + digit,0,digitsOfR,dp);
        }
        return dp[i][sum][isBounded] = ans;
    }
    private static int[] findDigitArray(int n){
        int len = countDigitBase10(n);
        int[] digitArray = new int[len];
        for(int i = len-1;i>=0;i--){
            digitArray[i] = n%10;
            n/=10;
        }
        return digitArray;
    }
    // tells if n is prime or not
    public static long firstDivisor(long n) {
        if (n == 1 || n == 0) return n;
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0) return i;
        return -1;
    }
    // count the length of a number, time O(1)
    public static int countDigitBase10(long n){
        return (int)(1 + Math.log10(n));
    }

}
