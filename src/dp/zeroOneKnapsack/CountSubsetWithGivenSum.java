package dp.zeroOneKnapsack;

import java.util.Arrays;
import java.util.Scanner;

public class CountSubsetWithGivenSum {
    // recursive approach , time complexity O(2^n)
    private static int recursive(int[] arr,int sum,int n){
        return recursiveHelpr(0,arr,0,sum);
    }
    private static int recursiveHelpr(int i,int[] arr,int curr,int sum){
        if(i==arr.length)
            return curr==sum ? 1 : 0;
        int x = 0;
        int y = 0;
        if(curr+arr[i]<=sum)
            x = recursiveHelpr(i+1,arr,curr+arr[i],sum);
        y  = recursiveHelpr(i+1,arr,curr,sum);
        return x+y;
    }
    // memoization of recursive solution, time complexity O(n*sum)
    private static int memoization(int [] arr,int sum,int n){
        int[][] dp =  new int[n][sum+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
       return memoHelpr(0,arr,0,sum,dp);
    }
    private static int memoHelpr(int i,int[] arr,int curr,int sum,int[][] dp){
        if(i==arr.length)
            return curr==sum ? 1 : 0;
        if(dp[i][curr]!=-1)return dp[i][curr];
        int x = 0;
        int y = 0;
        if(curr+arr[i]<=sum)
            x = memoHelpr(i+1,arr,curr+arr[i],sum,dp);
        y  = memoHelpr(i+1,arr,curr,sum,dp);
        return dp[i][curr] = x+y;
    }
    // bottom up dp solution , time complexity O(n*sum)
    private static int bottomUp(int[] arr,int Sum,int N){
        int[][] dp = new int[N+1][Sum+1];
        // initialization
        // no matter what sum is , if n==0, we can not create any required subset, hence ans is 0
        for(int sum=0; sum<=Sum;sum++)
            dp[0][sum] = 0;
        // no matter what n is, if sum==0 , we can create an empty set , hence ans is 1
        for(int n=0;n<=N;n++)
            dp[n][0]=1;
        for(int n=1;n<=N;n++)
            for(int sum = 1;sum<=Sum;sum++){
                if(arr[n-1]<=sum)
                    dp[n][sum] = dp[n-1][sum-arr[n-1]] + dp[n-1][sum];
                else dp[n][sum] = dp[n-1][sum];
            }
        return dp[N][Sum];
    }

    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        System.out.println("recursive :  "+recursive(arr,sum,n));
        System.out.println("memoization : "+memoization(arr,sum,n));
        System.out.println("bottom up : "+bottomUp(arr,sum,n));
    }
}
