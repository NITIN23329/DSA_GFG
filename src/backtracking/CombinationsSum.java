package backtracking;
//problem link : https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1/?track=DSASP-Backtracking&batchId=154
// another problem : https://practice.geeksforgeeks.org/problems/subsets-1587115621/1/?track=DSASP-Backtracking&batchId=154
import java.util.*;

public class CombinationsSum {
    // my solution :
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {   Set<Integer> set =new HashSet<>(A);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        A = new ArrayList<>(set);
        helper(list , A,B,new ArrayList<>(),0);
        list.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for(int i = 0;i<Math.min(o1.size(),o2.size());i++) {
                    if (o1.get(i).equals(o2.get(i))) continue;
                    if(o1.get(i)>o2.get(i))return 1;
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }
    static void helper(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> arr , int b, ArrayList<Integer> currList,int currSum){
        for(int ele : arr){
            if(currSum+ele>b)return;
            if(!currList.isEmpty() && ele<currList.get(currList.size()-1))continue;
            currList.add(ele);
            if(currSum+ele==b)  list.add(new ArrayList<>(currList));
            else helper(list,arr,b,currList,currSum+ele);
            currList.remove(currList.size()-1); //back tracking
        }
    }
}
