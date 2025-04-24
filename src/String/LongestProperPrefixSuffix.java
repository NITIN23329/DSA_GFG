package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// problem link: https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
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
    // use string hashing to compare
    public static int longestPrefixSuffix(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        long[] hash = new long[n];
        long[] pow = new long[n];
        pow[0] = 1;
        for(int i=0;i<n;i++){
            if(i>0) pow[i] = p * pow[i-1];
            pow[i] %= mod;
            hash[i] = (str[i] - 'a' + 1) * pow[i];
            hash[i] %=mod;
            if(i>0){
                hash[i] += hash[i-1];
                hash[i] %=mod;
            }
        }
        int ans = 0;
        for(int i=0;i<n-1;i++){
            long prefix = hash[i];
            long suffix = (hash[n-1] - hash[n- i - 2]  + mod) % mod;
            prefix = prefix * pow[n-i-1] % mod; // upgrade prefix to same power of suffix instead downgrading suffix to same power of prefix
            if(suffix == prefix)ans = i+1;
            // System.out.println(prefix +" c "+suffix);
        }
        return ans;
    }
}
