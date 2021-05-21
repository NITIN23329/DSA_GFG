package backtracking;
//problem link : https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
import java.util.*;

public class RatMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            ArrayList<String> res = printPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
    //time complexity : O((n*n)^4)
    static ArrayList<String> list ;
    static boolean[][] isVisited;
    public static ArrayList<String> printPath(int[][] arr, int n) {
        list = new ArrayList<>();
        isVisited = new boolean[n][n];
        if(arr[0][0]!=0 && arr[n-1][n-1]!=0)
            helper(arr,n,"",0,0);
        Collections.sort(list);
        return list;
    }
    private static void helper(int[][] arr,int n,String str,int x,int y){
        if(x==n-1 && y==n-1){
            list.add(str);
            return ;
        }
        isVisited[x][y] = true;
        if(x+1<n && arr[x+1][y]==1 && !isVisited[x+1][y])
            helper(arr,n,str+"D",x+1,y);
        if(x-1>=0 && arr[x-1][y]==1 && !isVisited[x-1][y])
            helper(arr,n,str+"U",x-1,y);
        if(y+1<n && arr[x][y+1]==1 && !isVisited[x][y+1])
            helper(arr,n,str+"R",x,y+1);
        if(y-1>=0 && arr[x][y-1]==1 && !isVisited[x][y-1])
            helper(arr,n,str+"L",x,y-1);
        isVisited[x][y] =false;             //this is the key to backtrack, once a cell is visited can be again visited
    }
}
/*
testCase :
7
1 1 0 0 0 0 0
0 1 1 0 0 0 0
0 0 1 0 0 0 0
0 0 1 0 0 0 0
1 1 1 0 1 1 1
1 0 0 0 1 0 1
1 1 1 1 1 0 1
ans : RDRDDDLLDDRRRRUURRDD
7
1 1 0 0 0 0 0
0 1 1 0 0 0 0
0 0 1 0 0 0 0
0 0 1 0 0 0 0
1 1 1 1 1 1 1
1 1 0 0 1 0 1
1 1 1 1 1 0 1
ans : RDRDDDLDDRRRUURRDD RDRDDDLDLDRRRRUURRDD RDRDDDLLDDRRRRUURRDD RDRDDDLLDRDRRRUURRDD RDRDDDRRRRDD
 */

