/*
    created by: nitin23329
    on Date: 12/06/21
*/
package dp.digitDP;
// problem link : https://www.spoj.com/problems/PR003004/

/**
 * Approach : use digit dp. Time and space complexity : O( logn * ( 9 * logn) * 2 )
 *  --> We use digit dp to store our sum of digits of current number and when we reach end, we return this sum.
 *     --> Let f(r) will give us the total sum of digit of all numbers from 0 to r.
 *     --> Then ans= f(r) - f(l-1)
 *     --> let f(r) = G(i,sum,isBounded), where i tells the index of the digit we are processing,
 *             sum is the sum of digit0,1,...i-1 index, isBounded tells whether we need to bound ith digit by the ith digit of r or not..
 *
 *     --> At ith digit, we can put any digit from 0 to 9 if it is not bounded and add it to sum
 *     --> If bounded, we can only by digit from 0 to r[i] at ith digit.
 *
 */
public class Problem2DigitSum {
    static long [][][] dp = new long[17][150][2];
    private static long solve(long l,long r) {
        long ans = 0;
        if(r>0)ans += helper(r);
        if(l-1>0) ans -= helper(l-1);
       return ans;
    }
    private static long helper(long n){
        int digitLength = (int)(1 + Math.log10(n));
        int[] digitArray = new int[digitLength];
        for(int i = digitLength-1;i>=0;i--){
            digitArray[i] = (int)(n % 10);
            n/=10;
        }
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                dp[i][j] = new long[]{-1,-1};

        return memo(0,0,1,digitArray);

    }
    private static long memo(int i,int currDigitSum,int isBounded,int[] digitArray){
        if(i==digitArray.length)return currDigitSum;
        if(dp[i][currDigitSum][isBounded]!=-1)return dp[i][currDigitSum][isBounded];
        long ans = 0;
        if(isBounded==1){
            for(int digit = 0;digit <= digitArray[i];digit++){
                ans += memo(i+1,currDigitSum + digit,digit == digitArray[i]?1:0,digitArray);
            }
        }else {
            for(int digit = 0;digit <= 9;digit++){
                ans += memo(i+1,currDigitSum + digit,0,digitArray);
            }
        }
        return dp[i][currDigitSum][isBounded] = ans;
    }
}
