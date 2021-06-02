package dp.unboundedKnapsack;
// problem link : https://leetcode.com/problems/coin-change/
import java.util.Arrays;

public class CoinChange {
    // recursive with time complexity O(amount^n)
    /*
        approach : this problem is similar to subset where sum = amount
            --> a minor difference is we can use a particular value any # of times like unbounded knapsack
            --> so for a particular coin we can
                    --> either reduce amount by current coin value and recursively call for this coin again
                    --> we ignore this coin and goto next coin.
                    -->in all possible cases ,check if it is possible to get given amount using minimum coins
            --> remember we can pick a coin as long as sum of all coins <= amount required.
     */
    public int recursive(int[] coins, int amount) {
        return memoHelper(0,amount,coins);
    }
    private int memoHelper(int i, int amount, int [] coins){
        if(amount==0)return 0;
        if(i==coins.length)return -1;
        int y = memoHelper(i+1,amount,coins);
        if(amount-coins[i]>=0){
            int x = memoHelper(i,amount-coins[i],coins);
            if(x==-1 && y==-1)return -1;
            if(x==-1)return y;
            if(y==-1)return 1 + x;
            return Math.min(1+x,y);
        }
        return y;
    }
    // time complexity O(n*amount) , we used -2 to initialize dp array with -2 cuz -1 represents that it is impossible to get given amount
    public int memoization(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            Arrays.fill(dp[i],-2);
        return memoHelper(0,amount,coins,dp);
    }
    private int memoHelper(int i, int amount, int [] coins, int[][] dp){
        if(amount==0)return 0;
        if(i==coins.length)return -1;
        if(dp[i][amount]!=-2)return dp[i][amount];
        int y = memoHelper(i+1,amount,coins,dp);
        if(amount-coins[i]>=0){
            int x = memoHelper(i,amount-coins[i],coins,dp);
            if(x==-1 && y==-1)return dp[i][amount] = -1;
            if(x==-1)return dp[i][amount] = y;
            if(y==-1)return dp[i][amount] = 1 + x;
            return dp[i][amount]= Math.min(1+x,y);
        }
        return dp[i][amount] = y;
    }
    // time complexity O(n*amount), space complexity : O(amount)
    /* Recursive relation :
                    x>0 solve(x) = for all coins c, min[  1 + solve(x - c) ]
                    x=0 solve(x) = 0
                    x<0 solve(x) = INFINITE
            */
    public static int bottomUp(int[] coins, int amount) {
        long [] dp = new long[amount+1];
        int[] first = new int[amount+1];    // first[i]  stores the first coin for a amount  = i
        int INT_MAX  = Integer.MAX_VALUE;
        dp[0] = 0;  // base case
        for(int x = 1;x<=amount;x++){
            dp[x] = INT_MAX;    // initially set to not possible
            for(var c : coins)
                if(x>=c && dp[x]>1 + dp[x-c]){
                    dp[x] = 1 + dp[x-c];
                    first[x] = c;   // we know that c is a coin for amount = x for sure
                }


        }
        StringBuilder solution = new StringBuilder();
        int x = amount;
        if(dp[amount]<INT_MAX)
            while (x>0){
                solution.append(first[x]).append(" ");
                x-=first[x];
            }
        else solution.append("no solution");
        System.out.println("A possible coin combination : "+solution);
        return dp[amount]>=INT_MAX?-1:(int)dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{3,5,10};
        int amount = 27;
        System.out.println(bottomUp(coins,amount));
    }
}
