package dp.fibonacci;
// problem link : https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1/?track=DSASP-DP&batchId=154
public class CountWaysToReachNthStairs {
    // time complexity O(n2^n)
    int recursive(int n){
        return recursiveHelper(n);
    }
    private int recursiveHelper(int n){
        if(n==0)return 1;
        if(n<0)return 0;
        return (recursiveHelper(n-2) + recursiveHelper(n-1))%((int)1e9+7);
    }
    // bottom up with time and space complexity O(n)
    int bottomUp(int n){
        int[] dp = new int[n+2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
            dp[i] = (dp[i-1] + dp[i-2])%((int)1e9+7);
        return dp[n];
    }
    // time complexity O(n) , space complexity O(1)
    // we require ans of n-1 and n-2 to calculate ans of n
    int countWays(int n){
        int n_1 = 1;
        int n_2 = 1;
        int curr = 1;
        for(int i=2;i<=n;i++){
            curr = (n_1+n_2)%((int)1e9+7);
            n_2 = n_1;
            n_1 = curr;
        }
        return curr;
    }
}
