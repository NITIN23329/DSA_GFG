package dp.others;
import java.util.Arrays;
/**
 **************************************IMPORTANT******************************************
 * problem link : https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
 * problem link : https://leetcode.com/problems/predict-the-winner/
 * problem link : https://cses.fi/problemset/task/1097
 */
public class OptimalStrategyForAGame {
    /*
        approach 1:
            --> we can either choose left or right coin which gives us the max value.
            --> now its opponent turn , he will also choose that left or right coin which gives him the maximum value
                 --> or we can say which gives us the minimum value.
            --> so choice 1 is we pick arr[l] coin and now opponent has 2 choices ,  arr[l+1] or arr[r],
            --> he will pick either coin so that we get minimum
            --> choice1 = arr[l] + min( f(l+2,r) , f(l+r,r-1) )
            --> similarly if we pick arr[r] , opponent can either pick arr[l] or arr[r-1]
            --> choice2 = arr[r] + min ( f(l+1,r-1) , f(l,r-2))
            --> basically, we try to maximise 1st move , opponent try to maximize in 2nd move ,then we try to maximize in 3rd move and so on
            --> here we will take 2 consecutive recursive call and make it one which gives answer for us only and not for opponent

     */

    // time and space complexity O(n^2)
    static long memoization(int[] arr, int n){
        long[][] dp = new long[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return memoHelper(arr,0,n-1,dp);
    }
    private static long memoHelper(int[] arr, int l, int r, long[][] dp){
        if(l>r)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        long c1 = arr[l] + Math.min(memoHelper(arr,l+2,r,dp), memoHelper(arr,l+1,r-1,dp));
        long c2 = arr[r] + Math.min(memoHelper(arr,l,r-2,dp), memoHelper(arr,l+1,r-1,dp));
        return dp[l][r] = Math.max(c1,c2);
    }

    /*
        Approach 2 :
            --> Suppose diff = alice - bob.
            --> And we know sum = alice + bob. To get alice Score we can do  = (sum + diff) /2;
            --> Wew need to maximize alice score as stated in problem. sum is constant hence we can only maximize diff.
            --> diff = alice + ( - bob )
            --> In alice turn , she will try to maximize her score and hence maximize diff: alice's contribution to diff
            --> In bob turn, he will try to minimise (- bob), so that the diff becomes minimum: bob's contribution to diff
            --> Ley say f(l,r,alice) gives us the diff .
            --> If it is alice's turn, we return max ( take arr[l] + contribution from bob , take arr[r] + contribution from bob)
                --> The recursive function which we called now will give (-bob) here.
                --> Then we calculate alice + (- bob) and return it.
            --> If it is bob's turn, we return min ( - arr[l] + contribution from alice, - arr[r] +  contribution from alice)
                --> The recursive function which we called will give smaller diff .
                --> Then we subtract bob's score from it and add smaller diff and then return it

     */
    private static long getAliceScore(int[] arr,int n) {
        long sum = 0;
        dpAlice = new long[n][n];
        dpBob = new long[n][n];
        for(int ele : arr)sum+=ele;
        for (int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dpAlice[i][j] = dpBob[i][j] = inf;

        // alice Score  =  ( sum + diff)/2 = ( (alice + bob) + (alice - bob) ) /2 = alice
        return (sum+ getMaxDiffInScore(0,n-1,1,arr))/2;
    }
    static long[][] dpAlice, dpBob; // we can create a dp[l][r][alice] or can create 2 dp for alice =1 and alice = 0;
    static long inf = (long)1e13;
    private static long getMaxDiffInScore(int l, int r, int alice, int[] arr){
        if(l>r)return 0;
        if(alice==1){ if(dpAlice[l][r]!=inf)return dpAlice[l][r];}
        else{ if(dpBob[l][r]!=inf)return dpBob[l][r];}
        // let diff = alice + (- bob);
        if(alice==1)  // alice will maximize diff
            return dpAlice[l][r] = Math.max(arr[l] + getMaxDiffInScore(l+1,r,0,arr),arr[r] + getMaxDiffInScore(l,r-1,0,arr));
        // will will minimise (-bob) so the diff will be reduced.
        return dpBob[l][r] = Math.min(-arr[l] + getMaxDiffInScore(l+1,r,1,arr),-arr[r] + getMaxDiffInScore(l,r-1,1,arr));
    }

}
