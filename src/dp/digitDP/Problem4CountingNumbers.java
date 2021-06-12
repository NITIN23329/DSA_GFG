/*
    created by: nitin23329
    on Date: 12/06/21
*/
package dp.digitDP;
// problem link : https://cses.fi/problemset/task/2220/
import java.util.Arrays;

/**
 *  Approach : Use digit dp, time and space complexity : O( logn * 11 * 40)
 *  --> We need to make sure no 2 adjacent numbers has same digit. So we keep hold of previous digit used.
 *  --> By this we need to make sure current digit must not be equal to previous digit.
 *  --> Note the cases like "001" , this is a valid number  but we can see that first 2 digit are 0 so we discard it in our solution
 *  --> To stop this we need to check if the number is started yet not.
 *  --> If the number is started we definitely can not have "00". if not started we can append "0" adjacently.
 *  --> Hence we hold another variable which tells whether a number is started yet or not?
 */
public class Problem4CountingNumbers {
    static long [][] [] dp = new long[20][11][4];
    private static long solve(long l,long r) {
        return helper(r) - helper(l-1);
    }
    private static long helper(long n) {
        if (n <0) return 0;
        if(n==0)return 1;
        int digitLength =(int)(1 + Math.log10(n));
        int[] digitArray = new int[digitLength];
        for (int i = digitLength - 1; i >= 0; i--) {
            digitArray[i] = (int) (n % 10);
            n /= 10;
        }
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                Arrays.fill(dp[i][j],-1);
        return memo(0,10,1,0,digitArray);
    }
    private static long memo(int i,int prevDigit,int isBound,int isNumStarted,int[] digitArray){
        if(i==digitArray.length) return 1;
        int bitMast = (isBound)*(1<<1) + (isNumStarted)*(1<<0);
        if(dp[i][prevDigit][bitMast]!=-1)return dp[i][prevDigit][bitMast];
        int maxDigit = isBound==1? digitArray[i] : 9;
        long ans = 0;
        for(int digit=0;digit <= maxDigit;digit++){
            if(digit == prevDigit)continue;
            if(isNumStarted == 0 && digit == 0 ) ans += memo(i+1,prevDigit,(isBound==1 && digit == digitArray[i])?1:0,0,digitArray);
            else ans += memo(i+1,digit,(isBound==1 && digit == digitArray[i])?1:0,1,digitArray);
        }
        return dp[i][prevDigit][bitMast] = ans;
    }
}
