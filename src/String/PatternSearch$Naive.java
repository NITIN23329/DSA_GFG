package String;
//problem link : https://practice.geeksforgeeks.org/problems/naive-pattern-search-1587115620/1/?track=SPC-Strings&batchId=154
public class PatternSearch$Naive {
    public static void main(String[] args) {
        String parent = "ABABABA";
        String child = "ABA";
        repetition(parent,child);
        parent = "BABCDABABCBBBABC";
        child = "ABC";
        distinct(parent,child);
    }
    public static void repetition(String str, String find){
        //time complexity :O((n-m+1)*m) : n =len(str) and m = len(find)
        // when repetitions are present
        System.out.println("repetition algo");
        for(int i =0;i<=str.length()-find.length();i++){
            if(str.startsWith(find, i)) System.out.println(i);
        }
    }
    public static void distinct(String str,String find){
        //time complexity O(n): n =len(str)
        // when no overlaps are presents
        System.out.println("distinct algo");
        for(int i=0;i<=str.length()-find.length();){
            int j;
            for( j=0;j<find.length();j++){
                if(find.charAt(j)!=str.charAt(i+j))break;
            }
            if(j==find.length()) System.out.println(i);
            if(j==0)i++;
            else i+=j;
        }
    }
}
