package dp.longestIncreasingSubsequence;
// problem link : https://leetcode.com/problems/longest-increasing-subsequence/
// solution link : https://www.youtube.com/watch?v=S9oUiVYEq7E&t=557s   (Tushar Roy)
// time complexity : O(nlogn) and space complexity : O(n)
public class LISLengthAndSequence_nlogn {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            // this will keep hold of LIS length found until index i.
            int len = 0;
            // This will tell us the index of smallest ending element of a LIS in nums whose length is = index of minElementIndex.
            // or minElementIndex[i] = j. It means the nums[j] is the smallest ending element of a LIS of length i.
            int[] minElementIndex = new int[n];
            // This will be used to find the LIS sequence
            // backtrack[i] = j means nums[i] comes after nums[backtrack[j]] in LIS
            // backtrack[i] = -1 means we have completed our LIS finding .
            int[] backtrack = new int[n];
            for(int i=0;i<n;i++){
                // smallest and largest are 2 end points of LIS.
                int smallest = minElementIndex[0];  // LIS with length 0
                int largest = minElementIndex[len]; // LIS whose length is Maximum = len.
                if(nums[smallest]>nums[i]){         // if nums[i] is smaller that LIS of smallest length
                    minElementIndex[0] = i;
                    backtrack[i] = -1;            // nums[i] is the starting of LIS with length 1.
                }
                else if(nums[largest]<nums[i]){     // if nums[i] is greater than LIS of maximum length.
                    minElementIndex[len+1] = i;
                    backtrack[i] = largest;
                    len++;                          // increase len as we have included nums[i]
                }
                else {
                    // here we can use BS to find replacementIndex as for i = [0,len] nums[minElementIndex[i]] > nums[minElementIndex[i-1]]
                    int replacementIndex = bs(minElementIndex,nums,nums[i],0,len);
                    if(replacementIndex==-1)
                        backtrack[i] = -1;      // nums[i] is a duplicate so no need to include it in any LIS
                    else{
                        minElementIndex[replacementIndex] = i;          // we update the smallest ending element
                        backtrack[i] = minElementIndex[replacementIndex-1];
                    }
                }
            }
            System.out.println(findLIS(backtrack,nums,minElementIndex[len]));
            return len+1;
        }
        private int bs(int[] arr,int[] nums,int val,int l,int r){
            // this BS will find the index in minElementIndex[] such that ceil(val) = nums[ minElementIndex[index] ]
            if(l>r)return -1;
            int mid = (r-l)/2 + l;
            if(nums[arr[mid]] == val)return -1;
            if(nums[arr[mid]]< val && nums[arr[mid+1]]>val)return mid+1;
            if(nums[arr[mid]]<val)
                return bs(arr,nums,val,mid+1,r);
            return bs(arr,nums,val,l,mid-1);
        }
        private String findLIS(int[] backtrack,int[] nums,int i){
            StringBuilder sb = new StringBuilder();
            while(i!=-1){
                sb.append(nums[i]).append(",");
                i = backtrack[i];
            }
            return sb.toString();
        }
}
