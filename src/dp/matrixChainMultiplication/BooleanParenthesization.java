package dp.matrixChainMultiplication;

/**
 *  *****************************************IMPORTANT*****************************************
 * problem link : https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1#
 *  problem link : https://www.interviewbit.com/problems/evaluate-expression-to-true/
 */
public class BooleanParenthesization {
    /*
        approach :
            --> for every k in [l+1,r-1] , k will only point to a operator
            --> find # of true and false in t1,f1=[l,k-1] and t2,f2 = [k+1,r]
            --> find # of current true and false by consider all cases and  add to result
            --> in case of xor , it will given true in t1f2 or f1t2 , and given false in t1t2 or f1f1
            --> in case of or , it will give true in t1t1,t1f2,f1t2 adn give false in f1f2
            --> in case of and, it will give true in t1t2 and give false in t1f2,f1t2,f1 f2
            -->return result
     */
    static int recursive(int N, String S){
        return recursiveHelper(S,0,N-1)[0];
    }
    private static int[] recursiveHelper(String str,int l,int r){
        if(l==r)
            return str.charAt(l)=='T'? new int[]{1,0} : new int[]{0,1};
        int[] count = new int[]{0,0};
        for(int k=l+1;k<r;k+=2){
            int[] ans1 = recursiveHelper(str,l,k-1);
            int[] ans2 = recursiveHelper(str,k+1,r);
            int t1 = ans1[0],t2 = ans2[0];
            int f1 = ans1[1], f2 = ans2[1];
            char ch = str.charAt(k);
            if(ch=='^'){
                count[0] = (count[0] + t1*f2 + t2*f1)%1003;
                count[1] = (count[1] + t1*t2 + f1*f2)%1003;
            }
            else if(ch=='|'){
                count[0] = (count[0] + t1*t2 + t1*f2 + f1*t2)%1003;
                count[1] = (count[1] + f1*f2)%1003;
            }
            else{
                count[0] = (count[0] + t1*t2)%1003;
                count[1] = (count[1] + t1*f2 + f1*t2 + f1*f2)%1003;
            }
        }
        return count;
    }
    // time complexity O(n^3) and space complexity O(2*n^2)
    // here dp[i][j] = { # of true ,  # of false} or we can take trueDP[i][j] and falseDP[i][j] to store # of true and false for i,j respectively f
    static int memoization(int N, String S){
        int[][][] dp = new int[N][N][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                dp[i][j] = new int[]{-1,-1};
        }
        return memoHelper(S,0,N-1,dp)[0];
    }
    private static int[] memoHelper(String str, int l, int r, int[][][] dp){
        if(l==r)
            return str.charAt(l)=='T'? new int[]{1,0} : new int[]{0,1};
        if(dp[l][r][0]!=-1)return dp[l][r];
        int[] count = new int[]{0,0};
        for(int k=l+1;k<r;k+=2){
            int[] ans1 = memoHelper(str,l,k-1,dp);
            int[] ans2 = memoHelper(str,k+1,r,dp);
            int t1 = ans1[0],t2 = ans2[0];
            int f1 = ans1[1], f2 = ans2[1];
            char ch = str.charAt(k);
            if(ch=='^'){
                count[0] = (count[0] + t1*f2 + t2*f1)%1003;
                count[1] = (count[1] + t1*t2 + f1*f2)%1003;
            }
            else if(ch=='|'){
                count[0] = (count[0] + t1*t2 + t1*f2 + f1*t2)%1003;
                count[1] = (count[1] + f1*f2)%1003;
            }
            else{
                count[0] = (count[0] + t1*t2)%1003;
                count[1] = (count[1] + t1*f2 + f1*t2 + f1*f2)%1003;
            }
        }
        return dp[l][r] = count;
    }

}
