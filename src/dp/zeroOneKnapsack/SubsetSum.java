package dp.zeroOneKnapsack;

//problem link : https://www.interviewbit.com/problems/subset-sum-problem/#
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {
    // time complexity O(n * sum)
    // we have 2 choices for every element , either consider it or don't consider it to find if given sum exist
    // memoization of recursive code
        public int solve(ArrayList<Integer> A, int B) {
            int[][] dp = new int[A.size()+1][B+1];
            for(int i=0;i<A.size()+1;i++)
                Arrays.fill(dp[i],-1);
            return memoization(0,B,A,dp);
        }
        private int memoization(int i,int sum ,ArrayList<Integer> list,int[][] dp){
            if(sum==0)return 1;
            if(i==list.size()|| sum <0 )
                return -1;
            if(dp[i][sum]!=-1)return dp[i][sum];
            int x = memoization(i+1,sum-list.get(i),list,dp);
            int y =  memoization(i+1,sum,list,dp);
            if(x==1 || y==1)
                dp[i][sum] = 1;
            else dp[i][sum] = 0;
            return dp[i][sum];
        }
        // bottom-up  dp approach
        // time complexity O(n * sum)
        // base case or initialization case : when sum==0, no matter the value of n , ans is true
        // for n>=1 and sum>=1 , find if including  nth(1 base indexing) elements is possible i.e. current sum does not exceeds given sum
        // if yes , then result for current state depends on  either take nth element or don't take
        public int bottomUp(ArrayList<Integer> A, int B) {
            boolean[][] dp = new boolean[A.size()+1][B+1];
            for(int n=0;n<dp.length;n++)
                dp[n][0] = true;
            for(int n=1;n<=A.size();n++)
                for(int sum = 1;sum<=B;sum++)
                    if(A.get(n-1) <= sum)
                        dp[n][sum] = dp[n-1][sum-A.get(n-1)] || dp[n-1][sum];
                    else dp[n][sum] = dp[n-1][sum];
            return dp[A.size()][B]? 1 : 0;

    }
}
