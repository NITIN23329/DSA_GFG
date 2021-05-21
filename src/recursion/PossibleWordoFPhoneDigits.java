package recursion;
//probelm link : https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/?track=DSASP-Recursion&batchId=154
import java.util.ArrayList;
import java.util.Collections;

public class PossibleWordoFPhoneDigits {
    public static void main(String[] args) {
        int[] arr = {2,3,4};
        System.out.println(possibleWords(arr, arr.length));
    }
    static ArrayList <String> possibleWords(int a[], int n)
    {
        String[] str = new String[14];
        str[2] = "abc";
        str[3] = "def";
        str[4] = "ghi";
        str[5] = "jkl";
        str[6] ="mno";
        str[7] ="pqrs";
        str[8] = "tuv";
        str[9] = "wxyz";
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<str[a[0]].length();i++)
            find(a,1,str,""+str[a[0]].charAt(i),list);
        Collections.sort(list);
        return list;

    }
    private static void find(int[] a,int n,String[] str , String curr,ArrayList<String> list){
        if(curr.length()==a.length){
            list.add(curr);
            return;
        }
        for(int i=0;i<str[a[n]].length();i++)
            find(a,n+1,str,curr+str[a[n]].charAt(i),list);

    }
}
