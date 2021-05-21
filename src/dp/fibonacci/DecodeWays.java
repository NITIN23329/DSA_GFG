package dp.fibonacci;
// problem link : https://leetcode.com/problems/decode-ways/
import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return memoHelper(s,0,dp);
    }
    private int memoHelper(String str,int i,int[] dp){
        if(i==str.length())
            return 1;
        if(str.charAt(i)=='0')
            return 0;
        if(dp[i]!=-1)return dp[i];
        int ans = 0;
        ans += memoHelper(str,i+1,dp);
        if(i+1<str.length() && Integer.parseInt(str.substring(i,i+2))<=26)
            ans += memoHelper(str,i+2,dp);
        return dp[i] =  ans;

    }
}
