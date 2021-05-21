package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main (String[] args)
    {
        Scanner sc =  new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        while(testCase-->0){
            String parent = sc.nextLine();
            String child = sc.nextLine();
            System.out.println(naive(parent,child));
            System.out.println(efficient(parent,child));

        }
    }
    public static int naive(String parent , String child){
        // time complexity o(nm)
        int count = 0;
        Map<Character,Integer> childCount = new HashMap<>();
        for(int i=0;i<child.length();i++){
            char ch = child.charAt(i);
            if(childCount.containsKey(ch))
                childCount.put(ch,childCount.get(ch)+1);
            else
                childCount.put(ch,1);
        }
       for(int i=0;i<=parent.length()-child.length();i++){
           Map<Character,Integer> parentCount = new HashMap<>();
           for(int j = 0;j<child.length();j++){
               char ch = parent.charAt(i+j);
               if(parentCount.containsKey(ch))
                   parentCount.put(ch,parentCount.get(ch)+1);
               else
                   parentCount.put(ch,1);
           }
           if(childCount.equals(parentCount))count++;
       }
        return count;
    }
    public static int efficient(String parent, String child){
       // time complexity O(n*Distinct_char_int_child)
        int count = 0;
        Map<Character,Integer> childCount = new HashMap<>();
        Map<Character,Integer> parentCount = new HashMap<>();
        for(int i=0;i<child.length();i++){
            char ch = child.charAt(i);
            char pa = parent.charAt(i);
            if(childCount.containsKey(ch))
                childCount.put(ch,childCount.get(ch)+1);
            else
                childCount.put(ch,1);
            if(parentCount.containsKey(pa))
                parentCount.put(pa,parentCount.get(pa)+1);
            else
                parentCount.put(pa,1);
        }
        if(parentCount.equals(childCount))count++;
        for(int i=0;i<parent.length()-child.length();i++){
            char next = parent.charAt(child.length()+i);
            if(parentCount.containsKey(next))
                parentCount.put(next,parentCount.get(next)+1);
            else parentCount.put(next,1);
            char prev = parent.charAt(i);
            if(parentCount.get(prev)==1)
                parentCount.remove(prev);
            else
                parentCount.put(prev,parentCount.get(prev)-1);
            if(parentCount.equals(childCount))count++;
        }
        return count;
    }
}
