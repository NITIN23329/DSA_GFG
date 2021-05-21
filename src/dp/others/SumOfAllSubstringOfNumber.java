package dp.others;
//problem link : https://practice.geeksforgeeks.org/problems/sum-of-all-substrings-of-a-number-1587115621/1/
import java.util.LinkedList;
import java.util.Queue;

public class SumOfAllSubstringOfNumber {
    // time complexity O(n^2) , space complexity O(n)
    // approach is using queue
    public static long queueSolution(String str){
        Queue<Long> q = new LinkedList<>();
        long ans = 0L;
        int mod = (int)1e9+7;
        q.add((long)(str.charAt(0)-'0'));
        int i=1;
        while(i<str.length()){
            long x = (long)(str.charAt(i++)-'0');
            int s = q.size();
            for(int k=0;k<s;k++){
                long y = q.poll();
                ans = (ans+y)%mod;
                y = (y*10 + x) %mod;
                q.add(y);
            }
            q.add(x);
        }
        while(!q.isEmpty())
            ans = (ans + q.poll())%mod;
        return (int)ans;
    }
    // time and space complexity O(n)
    //space complexity can be reduce to O(1) as to find dp[i] , we need dp[i-1] only
    /*
        approach : try to see a pattern for str = 1234 , say n=4
        for n==1 , substring ending with n=1 is : 1
        for n==2 , substring ending with n=2 is : 12,    2
        for n==3,  substring ending with n=3 is : 123,   23,   3
        for n==4 , substring ending with n=4 is : 1234, 234,  34, 4.
        can you see a relation btw of n-1 and n
        to calculate substrings ending with 4, we find substrings ending with 3, append 4 to end of each of them and 1 extra 4 is also taken
        so dp[i] = dp[i-1]*10 + (i+1)* str.charAt(i)
        sum of result of i from i = 1 to n is our answer
     */
    public static long dpSolution(String s){
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = (long)(s.charAt(0)-'0');
        long sum = dp[0];
        int mod = (int)1e9+7;
        for(int i=1;i<n;i++){
            dp[i] = (dp[i-1]*10 + (i+1)*((long)(s.charAt(i)-'0')))%mod;
            sum = (sum + dp[i]) % mod;
        }
        return sum;
    }
}
