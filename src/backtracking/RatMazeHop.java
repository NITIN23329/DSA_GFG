package backtracking;
//problem link : https://practice.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps-1587115621/1/?track=DSASP-Backtracking&batchId=154

public class RatMazeHop {
    /**procedure :
     * if(destination)return true;
     * else
     *    a) Mark current cell in solution matrix as 1.
     *    b) Move forward/jump (for each valid steps) in horizontal direction
     *       and recursively check if this move leads to a solution.
     *    c) If the move chosen in the above step doesn't lead to a solution
     *        then move down and check if this move leads to a solution.
     *    d) If none of the above solutions work then unmark this cell as 0
     *        (BACKTRACK) and return false.
     *
     *  Disclaimer: Don't check of minimum hop, as soon as we find a solution we report it.
     */
    public static void solve(int[][] maze, int n) {
        int[][] vis = new int[n][n];
        maze[n-1][n-1]=1;       // corner case
        boolean ans = helpr(maze,vis,0,0,n);
        if(!ans){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)System.out.print(vis[i][j]+" ");
            System.out.println();
        }
    }
    private static boolean helpr(int[][] maze,int[][] vis,int x,int y , int n){
        vis[x][y]=1;
        if(x==n-1 && y==n-1){
            return true;
        }
        boolean ans = false;
        boolean ans2 =false;
        for(int i=1;i<=maze[x][y];i++){
            if(valid(x,y+i,n) && vis[x][y+i]==0 && maze[x][y+i]!=0){
                ans =helpr(maze,vis,x,y+i,n);
                if(ans)return ans;
            }
            if(valid(x+i,y,n) && vis[x+i][y]==0 && maze[x+i][y]!=0){
                ans2 = helpr(maze,vis,x+i,y,n);
                if(ans2)return ans2;
            }

        }
        vis[x][y]=0;
        return false;
    }
    private static boolean valid(int x,int y,int n){
        return x<n && y<n;
    }
}
