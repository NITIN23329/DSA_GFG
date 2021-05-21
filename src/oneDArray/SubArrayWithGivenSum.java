package oneDArray;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10,2,-2,-20,10};
        int sum = -10;
        System.out.println(checkSubArray(arr,arr.length,sum));
    }
    public static boolean checkSubArray(int[] arr,int n,int sum){
        Set<Integer> set = new HashSet<>();
        int curr = 0;
        for(int ele : arr){
            curr+=ele;
            if(set.contains(curr-sum))return true;
            if(curr== sum)return true;
            set.add(curr);
        }
        return false;
    }
}
