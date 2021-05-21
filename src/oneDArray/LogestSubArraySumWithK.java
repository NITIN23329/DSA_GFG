package oneDArray;

import java.util.HashMap;
import java.util.Map;

public class LogestSubArraySumWithK {
    public static void main(String[] args) {
        int[] arr = new int[]{8,3,1,5,6,-6,2,2};
        System.out.println(naive(arr,4,arr.length));
        System.out.println(efficient(arr,4,arr.length));

    }
    public static int naive(int[] arr , int k,int n){
        // time complexity O(n^2)
        int max = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k)max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
    public static int efficient(int[] arr , int k,int n){
        // time complexity O(n)
        Map<Integer,Integer> map = new HashMap<>();
        int curr = 0;
        int res = 0;
        for(int i= 0;i<n;i++){
            curr+=arr[i];
            if(curr ==k)res = i+1;
            if(!map.containsKey(curr))
                map.put(curr,i);
            if(map.containsKey(curr-k))res =Math.max(res,i-map.get(curr-k));

        }return res;
    }
}
