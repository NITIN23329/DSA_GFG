/*
    created by: nitin23329
    on Date: 11/06/21
*/
package dp.digitDP;
// problem link : https://lightoj.com/problem/investigation
import java.util.Arrays;
/**
 Approach : Use digit DP, time and space O( 2 * logn * ( 9 logn) ^ 2)
 --> Sum of digits of a number and the number itself should be divisible by k.
 --> Let say sum of digits = sum = ( d1 + d2 + d3 .... + d10).
 --> For sum to be divisible by k, sum % k = 0
 --> So, ( d1 % k + d2 % k + ... + d10 % k ) % k = 0
 --> But the actual problem is how can we find that the number formed is itself divisible  by k?
 --> Let say the number is num = d1d2d3.....d10. so num%k = (d1d2d3 ... d10) %k  must be 0.
 --> So,  num % k = (d1 * 10^9 + d2*10^8 + d3*10^7 + ... + d10 * 10^0)   % k = 0
 --> So, ( (d1 * 10^9) % k + (d2*10^8) % k + ...  + (d10 * 10^0) % k) % k = 0
 */
public class Problem3$Investigation {
    private static int solve(int a,int b,int k) {
        // total sum must be divisible by and total sum <= 90(10 digits * 9)
        if(k>=100){
            return 0;
        }
        // edge case, number = 0 is also considered as a possible solution, hence subtract 1 if f(l-1) is not called
        return helper(b,k) - (a>1?helper(a-1,k):1);
    }
    private static int helper(int n,int k){
        int digitLength = (int)(1 + Math.log10(n));
        int[] digitArray = new int[digitLength];
        int nn = n;
        for(int i = digitLength-1;i>=0;i--){
            digitArray[i] = nn % 10;
            nn/=10;
        }
        // currSum can be digitLength * 9
        // currRem can be upto range 0 to k

        for(int i=0;i<digitLength;i++)
            for(int j=0;j<dp[0].length;j++)
                for(int kk=0;kk<k;kk++)
                    Arrays.fill(dp[i][j][kk],-1);

        return memo(0,0,0,1,k,digitArray);
    }


    static int[][][][] dp =  new int[11][100][100][2];
    private static int memo(int i,int sum,int currRem,int isBounded,int k,int[] digitArray){
        if(digitArray.length == i) {
            return sum == 0 && currRem  ==0 ? 1 :0;
        }
        if(dp[i][sum][currRem][isBounded]!=-1)return dp[i][sum][currRem][isBounded];
        int ans = 0;
        if(isBounded==1){
            for(int digit = 0 ; digit <= digitArray[i];digit++){
                int currPlace = (int)((digit * Math.pow(10,digitArray.length -i-1))%k);
                ans += memo(i+1,(sum + digit)%k,(currRem + currPlace)%k,digit == digitArray[i]?1:0,k,digitArray);
            }
        }else {
            for(int digit = 0 ; digit <= 9;digit++) {
                int currPlace = (int) ((digit * Math.pow(10, digitArray.length - i - 1)) % k);
                ans += memo(i + 1, (sum + digit) % k, (currRem + currPlace) % k, 0, k, digitArray);
            }
        }
        return dp[i][sum][currRem][isBounded] = ans;
    }

}
