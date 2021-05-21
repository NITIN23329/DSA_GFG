package recursion;
//problem link : https://leetcode.com/problems/letter-case-permutation/
import java.util.*;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        while (testcase-- > 0) {
            String str = sc.nextLine();
            ArrayList<String> list = new ArrayList<>();
            changeCases(list, str, "");
            for (String ele : list)
                System.out.print( ele+" ");
            System.out.println();
        }
    }
    //time complexity O(2^n)
    private static void changeCases(ArrayList<String> list , String str , String curr){
        if(str.isEmpty()){
            list.add(curr);
            return;
        }
        changeCases(list,str.substring(1),curr+str.charAt(0));
        changeCases(list,str.substring(1),curr+(str.charAt(0)+"").toUpperCase());
    }
}
