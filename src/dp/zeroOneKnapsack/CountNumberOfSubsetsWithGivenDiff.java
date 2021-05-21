package dp.zeroOneKnapsack;

public class CountNumberOfSubsetsWithGivenDiff {
    // time complexity O(2^n)
    // for every element in nums , either add it to set1 or to set2
    public int recursive(int[] nums, int S) {
        return recursiveHelpr(0,0,0,S,nums);
    }
    private int recursiveHelpr(int i,int curr1,int curr2,int sum,int[] nums){
        if(i==nums.length)
            return curr1-curr2 == sum ? 1 : 0;
        return recursiveHelpr(i+1,curr1+nums[i],curr2,sum,nums)
                + recursiveHelpr(i+1,curr1,curr2+nums[i],sum,nums);
    }
    // time complexity O(n*sum of array)
    /*
        --> use count subsets with given sum to find answers of all sum in range [0,diff]
        --> count # of subsets with sum s1 such that s1-s2 = diff
        --> we can traverse last row of dp to find our answer
        --> only case where this code fails when array has 0
     */
    public int bottomUp(int[] nums, int diff) {
        int totalSum = 0;
        for(int ele : nums)totalSum +=ele;
        int[][] dp = new int[nums.length+1][totalSum+1];
        // initialization
        // no matter what sum is , if n==0 ans is 0
        for(int sum=0;sum<=totalSum;sum++)
            dp[0][sum] = 0;
        // no matter what n is , if sum==0 , ans is 1
        for(int n=0;n<=nums.length;n++)
            dp[n][0] = 1;
        for(int n =1;n<=nums.length;n++)
            for(int sum=1;sum<=totalSum;sum++){
                if(nums[n-1] <= sum)
                    dp[n][sum] = dp[n-1][sum - nums[n-1]] + dp[n-1][sum];
                else dp[n][sum] = dp[n-1][sum];
            }
        int count = 0;
        for(int sum=0;sum<=totalSum;sum++)
            if(2*sum- totalSum == diff)count+=dp[nums.length][sum];
        return count;
    }
}
