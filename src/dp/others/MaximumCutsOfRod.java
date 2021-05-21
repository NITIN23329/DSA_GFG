package dp.others;
// problem link : https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
import java.util.Arrays;

public class MaximumCutsOfRod {
    // time complexity O(3^n)
    /*
    --> we can either cut at length x , y or z
    --> find all possible cuts and return max of them
    --> if we can't cut rod into length x , y or z return -1

    */
    public int recursive(int n, int x, int y, int z) {
        int count =  recursiveHelpr(0,n,x,y,z);
        return count==-1 ? 0 : count;
    }
    private int recursiveHelpr(int curr,int n,int x,int y,int z){
        if(curr==n)return 0;
        if(curr>n)return -1;
        int a = recursiveHelpr(curr+x,n,x,y,z);
        if(a!=-1)a++;
        int b = recursiveHelpr(curr+y,n,x,y,z);
        if(b!=-1)b++;
        int c= recursiveHelpr(curr+z,n,x,y,z);
        if(c!=-1)c++;
        return Math.max(Math.max(a,b),c);
    }
    // time complexity O(n)
    // memoization of above recursive solution
    // instead of initializing dp with -1 we will use -2 and -1 state will be used to represent non possible cut
    public int memoization(int n, int x, int y, int z) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-2);
        int count =  memoHelpr(0,n,x,y,z,dp);
        return count==-1 ? 0 : count;
    }
    private int memoHelpr(int curr, int n, int x, int y, int z, int[] dp){
        if(curr==n)return 0;
        if(curr>n)return -1;
        if(dp[curr]!=-2)return dp[curr];
        int a = memoHelpr(curr+x,n,x,y,z,dp);
        if(a!=-1)a++;
        int b = memoHelpr(curr+y,n,x,y,z,dp);
        if(b!=-1)b++;
        int c= memoHelpr(curr+z,n,x,y,z,dp);
        if(c!=-1)c++;
        return dp[curr] = Math.max(Math.max(a,b),c);
    }
    // time complexity O(n)
    // initialisation : if n==0 , ans is 0.
    // -1 denotes if not possible to cut rod with given length(x or y or z)
    // if all are -1 then current rod can not be cut
    // else find maximum of all and add 1 to get result for current length rod
    public int bottomUp(int n, int x, int y, int z){
        int[] dp = new int[n+1];
        dp[0] = 0;  //initialization
        for(int i=1;i<=n;i++){
            int a = i-x>=0 ? dp[i-x] : -1;
            int b = i-y>=0 ? dp[i-y] : -1;
            int c = i-z>=0 ? dp[i-z] : -1;
            if(a==-1 && b==-1 && c==-1)dp[i] = -1;
            else dp[i] = 1+ Math.max(Math.max(a,b),c);
        }
        return dp[n]==-1 ? 0 : dp[n];
    }
}
