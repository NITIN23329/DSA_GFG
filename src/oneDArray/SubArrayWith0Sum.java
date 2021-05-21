package oneDArray;
//problem link : https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0
// solution link : https://practice.geeksforgeeks.org/tracks/SPCF-Hashing/?batchId=154
import java.util.HashSet;
import java.util.Set;

public class SubArrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,-3,7};
        System.out.println(findsum(arr,arr.length));
    }
    static boolean findsum(int arr[],int n)
    {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(0);
        for(int i = 0 ; i< n ; i ++){
            sum+=arr[i];
            if(set.contains(sum)){
                return true;

            }
            set.add(sum);
        }

        return false;
    }
}
