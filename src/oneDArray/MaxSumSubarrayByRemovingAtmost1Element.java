package oneDArray;

/**
 * *********************************************IMPORTANT************************************************************
 * problem link : https://practice.geeksforgeeks.org/problems/max-sum-subarray-by-removing-at-most-one-element/1/
 */
public class MaxSumSubarrayByRemovingAtmost1Element {
    // time and space complexity : O(n)
    /*
        approach :
            --> for every k in [1,n-1], find maximum sum subarray ending with k-1 from left side  and maximum sum subaaray ending with k+1 from right side.
            --> for every i in[0,n-1] we can calculate maximum sum subarray ending with i from both forward and backward direction
            --> and store them in array just like calculating prefix sum.
            --> for every k int [1,n-1] , we have 3 options
            --> if we include  k and left and right subarray, currSum = leftSubArraySum[k-1] + arr[k] + rightSubarraySum[k+1]
            --> if we don't inculde k but include left and right subarray , currSum = leftSubArraySum[k-1] + rightSubarraySum[k+1]
            --> if we include only k not left and right subarray , currSum = arr[k] ( this case happens when leftSubArraySum[k-1] + rightSubarraySum[k+1]<0)
            --> find maximum of all currSum .

     */
    public static int maxSumSubarray(int[] arr, int n){
        int min = -99999;
        int[] leftSubarraySum = new int[n];
        int[] rightSubarraySum = new int[n];
        int currSum = min;
        for(int i=0;i<n;i++){
            currSum = Math.max(currSum+arr[i],arr[i]);
            leftSubarraySum[i] = currSum;
        }
        currSum = min;
        for(int i=n-1;i>=0;i--){
            currSum = Math.max(currSum+arr[i],arr[i]);
            rightSubarraySum[i] = currSum;
        }
        int maxSum = Math.max(arr[0],arr[n-1]);
        // we initially took max(arr[0] and arr[n-1]) as we will not consider them as k in below loop
        for(int k=1;k<n-1;k++){
            int o1 = leftSubarraySum[k-1] + rightSubarraySum[k+1];
            int o2 = leftSubarraySum[k-1]  + arr[k] + rightSubarraySum[k+1];
            int o3 = arr[k];
            maxSum = Math.max(maxSum,Math.max(Math.max(o1,o2),o3));
        }
        return maxSum;
    }
}
