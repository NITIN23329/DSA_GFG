package dp.zeroOneKnapsack;

import java.util.Arrays;
    // problem link : https://atcoder.jp/contests/dp/tasks/dp_e
public class zeroOneknapsack2 {
    /*
        --> time complexity : O(nV). n =  size of array and V = sum of values
        --> Since W can be upto 1e9 , standard Knapsack solution don't work
        --> As v[i] <=1e3 and n<=100, we can use something like dp[n][sum(v[i)]
        --> Let dp[i][j] = k means to get a profit of j with elements from  0 to i, we need atleast k weight
        --> initialization: if val = 0 then weight = 0. otherwise it is impossible to make any value >1 initially(dp[i][j] = inf)
        --> Then we can either take current element if its val <= the total value we want or don't take it.
                --> if we take current element the total weight to create a profit of total value = dp[i-1][val - currentProfit] + currentWeight
                --> If we don't take current element then the total weight to create a profit of total value = dp[i-1][totalValue]
        --> take the minimum of both cases and then we get minimum weight to create a profit of total value
     */
    private static long solve(int n,int cap,int[][] arr) {
        // arr[i][0] = weight of ith element and arr[i][1] value of ith element
        int mx = 0;
        for(int [] ele : arr)mx += ele[1];
        long inf = (long)1e13;
        // dp[i][j] = k means to get a profit of j with elements from  0 to i, we need atleast k weight
        long [][] dp = new long[n+1][mx+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],inf);   // initially any value > 1 is not possible
            dp[i][0] = 0;           // for 0 profit, weight is 0 (don't take any element)
        }
        for(int i=1;i<=n;i++){
            for(int val = 0;val<=mx;val++){
                if(val>=arr[i-1][1])    // can take current element
                    dp[i][val] = Math.min(dp[i][val],dp[i-1][val - arr[i-1][1]]+ arr[i-1][0]);
                dp[i][val] = Math.min(dp[i][val],dp[i-1][val]);// don't take current element
            }
        }
        for(int val=mx;val>=0;val--){   // find the maximum value we can create s.t. total weight <= capacity
            for(int i=0;i<=n;i++){
                if(dp[i][val]<=cap){
                    return val;
                }
            }
        }
        return -1;
    }
}
