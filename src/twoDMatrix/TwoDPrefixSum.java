package twoDMatrix;

import java.io.PrintStream;
import java.util.Scanner;

public class TwoDPrefixSum {
    /***************************IMPORTANT*********************************************
    problem link : https://www.codechef.com/problems/COW3E
   time and space complexity : O(n^2)
   Approach : using 2D prefix sum
       --> step 1
           --> in step 1 we create an temporary array to store changes.
           --> we are given r1,c1,r2,c2. We add and subtract k at selected cells so that when we take 2d prefix sum only cells from r1c1 to r2c2 got affected
           --> For this we do arr[r1][c1]+=k,
           --> arr[r1][c2+1] -=k and arr[r2+1][c1] -=k to balance off the k added at r1,c1
           --> arr[r2+1][c2+1] +=k to balance of the two -k added
       --> step 2 : find the 2D prefix sum of the temporary array to get the change for every cells.
            --> to find prefix sum we for cell i,j we do arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1]
       --> step3: Add those changes to our original array to appropriate cells
       --> step4 : Find 2D prefix sum of the updated array.
       --> step 5: find the sum of cells from r1c1 to r2c2. To do this :
           --> sum = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1]
    **/
    public static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int updates = sc.nextInt();
        int query = sc.nextInt();
        long[][] arr = new long[n][m];
        for(int i=0;i<n;i++)
            for(int j= 0;j<m;j++)
                arr[i][j] = sc.nextLong();
        long[][] changePrefix = new long[n][m];
        for(int i=0;i<updates;i++){
            int k = sc.nextInt();
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            // step 1
            changePrefix[r1][c1] += k;
            if(c2+1<m) changePrefix[r1][c2+1] -= k;
            if(r2+1<n) changePrefix[r2+1][c1] -= k;
            if(r2+1<n && c2+1<m)changePrefix[r2+1][c2+1] += k;
        }
        // step2
        calcPrefix(changePrefix,n,m);

        //step3
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr[i][j]+=changePrefix[i][j];

        // step4
        calcPrefix(arr,n,m);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<query;i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            // step5
            long val = arr[r2][c2] - (r1==0?0:arr[r1-1][c2]) - (c1==0?0:arr[r2][c1-1]) + (r1==0 || c1==0?0:arr[r1-1][c1-1]);
            sb.append(val).append("\n");
        }
        out.print(sb);

    }
    private static void calcPrefix(long[][] arr,int n,int m){
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr[i][j] += (i==0?0:arr[i-1][j]) + (j==0?0:arr[i][j-1]) - (i==0 || j==0?0:arr[i-1][j-1]);
    }
    static Scanner sc = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);
}
