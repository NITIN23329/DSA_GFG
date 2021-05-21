package dp.matrixChainMultiplication;
import java.util.*;

/**
 * ************************************************IMPORTANT************************************************
 * problem link : https://leetcode.com/problems/scramble-string/
 * solution link : https://www.youtube.com/watch?v=SqA0o-DGmEw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=41
 */



public class ScrambledString {
    /*
        approach :
            --> base case is the string contains only 1 character , return s1[0]==s2[0].
            --> else for every k in range [0,s1.length()-1].
            --> divide both strings to {0,k+1} and {k+1,s.length()}.
            --> let left substring of s1 = s1.substring(0,k+1).
            --> let right substring of s1 = s1.substring(k+1,s1.length()).
            --> there are 2 cases possible , swapped or not swapped.
            --> if not swapped , it means left of s1 and left of s2 will be scrambled string of each other
            --> and right of s1 and s2 are scrambled string of each other.
            --> if swapped,it means left substring of s1 matches with some last characters of s2 and right substring of s1 matches with some first characters of s2.
            --> if either condition is true , s1 and s2 are scrambled strings
            -->basically we will partition the sting s1 and s2 for each k and check if left and right substrings  are scrambled string or not
            -->
     */
    public boolean recursive(String s1, String s2) {
        return recursiveHelper(s1,s2);
    }
    private boolean recursiveHelper(String s1, String s2){
        if(s1.length()==1)
            return s1.charAt(0) == s2.charAt(0);
        for(int k=0;k<s1.length()-1;k++){
            if((recursiveHelper(s1.substring(0,k+1),s2.substring(0,k+1)) &&
                    recursiveHelper(s1.substring(k+1,s1.length()),s2.substring(k+1,s2.length()))) ||
                    (recursiveHelper(s1.substring(0,k+1),s2.substring(s2.length()-k-1,s2.length())) &&
                            recursiveHelper(s1.substring(k+1,s1.length()),s2.substring(0,s2.length()-k-1))))
                return true;
        }
        return false;
    }

    // time complexity O(n^4) where n = [1,30]
    // memoization of above solution
    // one more optimization can be done : we sort both string and compare the # of characters in both ,
    // if they are not equal , return false
    public boolean isScramble(String s1, String s2) {
        Map<String,Boolean> dp = new HashMap<>();
        return memoHelper(s1,s2,dp);
    }
    private boolean memoHelper(String s1, String s2,Map<String,Boolean> dp){
        if(s1.length()==1)
            return s1.charAt(0) == s2.charAt(0);
        String str = s1+s2;
        if(dp.containsKey(str))return dp.get(str);
        boolean ans = false;
        for(int k=0;k<s1.length()-1;k++){
            if((memoHelper(s1.substring(0,k+1),s2.substring(0,k+1),dp) &&
                    memoHelper(s1.substring(k+1,s1.length()),s2.substring(k+1,s2.length()),dp)) ||
                    (memoHelper(s1.substring(0,k+1),s2.substring(s2.length()-k-1,s2.length()),dp) &&
                            memoHelper(s1.substring(k+1,s1.length()),s2.substring(0,s2.length()-k-1),dp))){
                ans =  true;
                break;
            }
        }
        dp.put(str,ans);
        return ans;
    }
}
