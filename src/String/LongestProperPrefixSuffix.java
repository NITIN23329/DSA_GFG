package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestProperPrefixSuffix {
    public static void main(String[] args) {
        String str = "abacababa";
        naiveApproach(str);
    }
    public static void naiveApproach(String str){
        int[] lps = new int[str.length()];
        for(int i=1;i<str.length();i++){
            Set<String> set = new HashSet<>();
            for(int j=0;j<=i;j++)
                set.add(str.substring(0,j));
           // System.out.println(set);
            int maxLen = 0;
            for(int j=i;j>=0;j--){
                String suffix = str.substring(j,i+1);
                //System.out.println(suffix);
                if(set.contains(suffix))maxLen = Math.max(maxLen,suffix.length());
            }
            lps[i]=maxLen;
        }
        System.out.println(Arrays.toString(lps));
    }
}
