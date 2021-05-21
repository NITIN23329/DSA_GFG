package dp.matrixChainMultiplication;
// problem link : https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1#
import java.util.*;
class TreeNode{
    int data;
    TreeNode left,right;
    public TreeNode(int data){
        this.data = data;
    }
}
public class MatrixChainMultiplication {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<int[]>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for (int i = 0; i < nov; i++)
            list.add(i, new ArrayList<>());
        for (int i = 1; i <= edg; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w= sc.nextInt();
            list.get(u).add(new int[]{v,w});
            list.get(v).add(new int[]{u,w});
        }
        System.out.println(primsLazy(list , nov));

    }

    private static TreeNode primsLazy(List<List<int[]>> adj,int v){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(b[1]-a[1]));
        for(int[] ele : adj.get(0))pq.add(ele);
        TreeNode root = null;
        TreeNode next = null;
        boolean[] isVisited = new boolean[v];
        isVisited[0] = true;
        while (!pq.isEmpty()){
            int[] x = pq.poll();
            if(isVisited[x[0]])continue;
            isVisited[x[0]] = true;
            if(root==null){
                root = new TreeNode(x[0]);
                next = root;
            }
            else {
                next.right = new TreeNode(x[0]);
                next = next.right;
            }
            for(int[] ele : adj.get(x[0]))
                if(!isVisited[ele[0]])
                    pq.add(ele);
        }
        return  root;
    }
    // recursive solution
    /*  approach :
            --> Given matrix A1*A2*A3*A4*A5 , which matrix should we multiply first to get min cost is our question to solve
            -->  matrix[i] dimension is = arr[i-1] x arr[i]
            -->  we will start from index i=1 and end at index j=n-1
            -->  for every index k in [i,j-1], do following (we took k=j-1 cuz if we took k==j , a recursive call would be (j+1,j) which is a invalid matrix)
                    --> recursive find  minimum cost for a=(i,k) and b=(k+1,j)
                    --> to multiply matrix[k] , we do arr[i-1]*arr[k]*arr[j] . Let suppose our k=3 ,i.e. A3 is we are solving
                    --> so a=(i,k) will multiply A1 and A2 and return its cost, b=(k+1,j) will multiply A4 and A5 and return its cost
                    --> what left is to find cost for row(A1) * arr[k] * col(A5) ,  add this cost with a and b to get total cost .
                    --> return minimum of all such total costs
     */

    static int recursive(int N, int[] arr){
        return recursiveHelper(arr,1,N-1);
    }
    private static int recursiveHelper(int[] arr,int l, int r){
        if(l==r) return 0;
        int res = Integer.MAX_VALUE;
        for(int mid = l;mid<r;mid++){
            int left = recursiveHelper(arr,l,mid);
            int right = recursiveHelper(arr,mid+1,r);
            res = Math.min(res,left+right+arr[l-1]*arr[mid]*arr[r]);
        }
        return res;
    }
    /* memoization of recursive solution
        --> time complexity : O(n^3) , space complexity O(n^2)
        --> for every l and r we traverse l to r
     */
    static int memoization(int N, int[] arr){
        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++)Arrays.fill(dp[i],-1);
        return memoHelper(arr,1,N-1,dp);
    }
    private static int memoHelper(int[] arr,int l, int r,int[][] dp){
        if(l==r)
            return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        int res = Integer.MAX_VALUE;
        for(int mid = l;mid<r;mid++){
            int left = memoHelper(arr,l,mid,dp);
            int right = memoHelper(arr,mid+1,r,dp);
            res = Math.min(res,left+right+arr[l-1]*arr[mid]*arr[r]);
        }
        return dp[l][r] = res;
    }
}
