package maths;
// problem link : https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1#
// time complexity : O(logn)
// space complexity : O(1)
public class BinaryExponentiation {
    long power(long x,long n){
        long mod = (long)1e9+7;
        long ans = 1;
        while(n>0){
            if(n%2!=0){
                ans *= x;
                n--;
            }else {
                x *= x;
                n/=2;
            }
            x %=mod;
            ans %=mod;
        }
        return ans;
    }
}
