package binarSearch;

import java.util.Arrays;

public class findFirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3,4};
        System.out.println(Arrays.toString(searchRange(arr,1)));
    }
    public static  int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int first =-1;
        while(start<=end){              // binary search to find first occuring index
            int mid = (start+end)/2;
            if(nums[mid]==target)first = mid;
            if(nums[mid]>=target)end = mid-1;
            else start =mid+1;
        }
        int last  = -1;
        start=0;end =nums.length-1;
        while(start<=end){           // binary search to find last occuring index
            int mid = (start+end)/2;
            if(nums[mid]==target)last = mid;
            if(nums[mid]>target)end = mid-1;
            else start =mid+1;
        }
        return new int[]{first,last};
    }
}
