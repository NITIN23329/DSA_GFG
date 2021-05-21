package recursion;

import java.util.*;
//problem link : https://practice.geeksforgeeks.org/problems/subsets/0
public class GenerateUniqueSubsets {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)arr[i] = sc.nextInt();
            Set<String> set = new HashSet<>();
            Arrays.sort(arr);
            set.add("");
            subset(set,arr,"",0);
            ArrayList<String> list = new ArrayList<>(set);
            Collections.sort(list);
            for(String ele : list)
                System.out.print("("+ele+")");
            System.out.println();

        }
    }
    private static void subset(Set<String> set , int[] arr , String curr, int i){
        if(i==arr.length){
            set.add(curr);
            return;
        }
        subset(set,arr,curr,i+1);
        if(curr.isEmpty())
            subset(set,arr,""+arr[i],i+1);
        else
         subset(set,arr,curr+" "+arr[i],i+1);
    }
}
