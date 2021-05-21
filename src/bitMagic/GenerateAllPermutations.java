package bitMagic;

import java.util.ArrayList;
import java.util.List;
//problem link : https://leetcode.com/problems/permutations/
/*
approach : use backtracking
--> Suppose we have n elements which an be taken
--> Taking a different  element each time creates an different arrangement.
 */
public class GenerateAllPermutations {
    public List<List<Integer>> permute(int[] arr) {
        ans = new ArrayList<>();
        permutation(0,arr.length,arr,new ArrayList<>());
        return ans;
    }

    private  List<List<Integer>> ans;
    private void permutation(int b,int n,int[] arr,List<Integer> curr){
        // if we have taken all elements
        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        // taking a element which is not taken yet creates an different arrangement.
        for(int i=0;i<n;i++){
            int ith_bit = 1<<i;
            if((b & ith_bit)==0){           // if ith element is not taken yet
                curr.add(arr[i]);           // take arr[i]
                b+=ith_bit;             // setting ith bit of b to 1
                permutation(b,n,arr,curr);
                b-=ith_bit;             // reverting setting of ith bit of b
                curr.remove(curr.size()-1); // do backtracking
            }
        }
    }
}
