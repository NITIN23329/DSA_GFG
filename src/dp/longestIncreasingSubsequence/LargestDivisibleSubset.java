package dp.longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    // time complexity : O(N^2)
    // space complexity O(N)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp[i] = new int[]{1,-1};
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i][0]<1+dp[j][0])
                    dp[i] = new int[]{dp[j][0]+1,j};
            }
            if(list.size()<dp[i][0]){
                int index = i;
                list = new ArrayList<>();
                while(index!=-1){
                    list.add(nums[index]);
                    index = dp[index][1];
                }
            }
        }
        return list;
    }
}
