package bitMagic;
// problem link : https://leetcode.com/problems/subsets/
import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // since each bit represents an element, we must have n bits in total.
        // all possible subsets are from 000..000 to 1111...111
        // in decimal we have to go reom 0 to 2^n - 1
        for(int b = 0;b<(1<<n);b++){
            List<Integer> subset = new ArrayList<>();
            // we loop through each bit and check if ith bit in b is set
            // if yes we take ith element .
            for(int i=0;i<n;i++){
                if((b & (1<<i))!=0)
                    subset.add(nums[i]);
            }
            ans.add(subset);
        }
        return ans;

    }
}
