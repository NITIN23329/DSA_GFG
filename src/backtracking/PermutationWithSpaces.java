package backtracking;

import java.util.*;

public class PermutationWithSpaces {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        while(testCase-->0){
            String str = sc.nextLine();
            Set<String> set = new HashSet<>();
            helper(str , set);
            ArrayList<String> list = new ArrayList<>(set);
            Collections.sort(list);
                  for(String ele : list)
                System.out.print("("+ele+")");
            System.out.println();
        }
    }
    private static void helper(String str ,Set<String> set ){
        set.add(""+str.charAt(0));
        for(int i=1;i<str.length();i++){
            ArrayList<String> remover = new ArrayList<>();
            ArrayList<String> adder = new ArrayList<>();
            for(String ele : set){
                String s1 = ele+str.charAt(i);
                String s2 = ele+" "+str.charAt(i);
                adder.add(s1);
                adder.add(s2);
                remover.add(ele);
            }
            for(String ele : remover)set.remove(ele);
            for(String ele : adder)set.add(ele);
        }
    }
}
