package avlTree;

import java.util.Arrays;
import java.util.TreeSet;

public class CelingOnLeft {
    public static void main(String[] args) {
        int[] arr =new int[]{2,8,30,15,25,12};
        System.out.println(Arrays.toString(findCeil(arr , arr.length)));
    }
    public static int[] findCeil(int[] arr , int n){
        int[] temp = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i =0;i<n;i++){
            Integer ans =  treeSet.ceiling(arr[i]);
            if(ans==null)temp[i] = -1;
            else
            temp[i] =ans;
            treeSet.add(arr[i]);
        }
        return temp;
    }
}
