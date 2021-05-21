package recursion;

import java.util.ArrayList;

//problem link : https://practice.geeksforgeeks.org/problems/power-set-using-recursion/1/?track=DSASP-Recursion&batchId=154
//idea is either u will append a character of string or not.
public class StringPermutations {
    static ArrayList<String> list ;
    static ArrayList<String> powerSet(String s)
    {
        list = new ArrayList<>();
        list.add("");
        helper(s);
        return list;
    }
    static void helper(String str){
        if(str.isEmpty())
            return;
        int s = list.size();
        for(int i=0;i<s;i++)
            list.add(list.get(i)+str.charAt(0));
        helper(str.substring(1));
    }
}
