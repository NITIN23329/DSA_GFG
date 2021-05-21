package oneDArray;

import java.util.HashMap;
import java.util.Map;
//problem link : https://practice.geeksforgeeks.org/problems/subarray-range-with-given-sum0128/1/?track=SPCF-Hashing&batchId=154
// solution :   https://www.youtube.com/watch?v=HbbYPQc-Oo4&t=590s
public class CountNumberofSums {
    public static void main(String[] args) {
        int[] arr = {10, 2 ,-2 ,-20, 10 ,0};
        System.out.println(subArraySum(arr,arr.length,-10));
    }
    static int subArraySum(int arr[], int n, int sum)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int curr=0;
        int count=0;
        for(int ele : arr){
            curr+=ele;
            if(curr==sum)count++;
            if(map.containsKey(curr-sum)){
                count+=map.get(curr-sum);
            }
            if(map.containsKey(curr))map.put(curr,map.get(curr)+1);
            else map.put(curr,1);
            System.out.println(map);
        }

        return count;
    }
}
