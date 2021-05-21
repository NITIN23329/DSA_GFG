package dp.longestIncreasingSubsequence;

import java.util.Scanner;
// problem link : https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence/0#
public class MaximumSumOfBitonicSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            System.out.println(lbs(arr,n));
        }
    }
    // time complexity O(n^2) , space complexity O(n)
    /*
        approach :
            --> for every i in 0 to n-1
            --> find largest sum of Longest increasing subsequence ending with element at index i  = a
            --> find largest sum of Longest decreasing subsequence starting with element at index i = b
            --> sum of current Biotnic subsequence is a+b - arr[i] , we subtract arr[i] as element at i is considered in both LIS and LDS
     */
    private static int lbs(int[] arr,int n){
        int [] ldsDp = new int[n];
        int[] lisDp = new int[n];
        for(int i=0;i<n;i++){
            lisDp[i] = arr[i];
            for(int j=0;j<i;j++)
                if(arr[j]<arr[i])
                    lisDp[i] = Math.max(lisDp[i] , lisDp[j]+arr[i]);
        }
        for(int i=n-1;i>=0;i--){
            ldsDp[i] = arr[i];
            for(int j=n-1;j>i;j--){
                if(arr[j] <  arr[i])
                    ldsDp[i] = Math.max(ldsDp[i],ldsDp[j]+arr[i]);
            }
        }
        int maxLbs = 0 ;
        for(int i=0;i<n;i++)
            maxLbs = Math.max(maxLbs , lisDp[i]+ldsDp[i] - arr[i]);
        return maxLbs;
    }
}
