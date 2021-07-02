package graph.traversal;
// problem link : https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1/?track=DSASP-Graph&batchId=154
import java.util.*;

class RottenOranges
{
    /*  time complexity : o(nm)
        -->do a bfs
        --> check of adjacent up/down/left/right  fresh oranges, if there any, add it to queue with time increased by 1.
        --> when we add a orange to q, make it to 2 so that it will not be check with another rotten orange

     */

    public int orangesRotting(int[][] grid)
    {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==2)
                    q.add(new int[]{i,j,0});
        int time = 0;
        while(!q.isEmpty()){
            int[] x = q.poll();
            time = Math.max(time,x[2]);
            int i = x[0];
            int j = x[1];
            if(isValid(grid,i-1,j,n,m)){
                grid[i-1][j]=2;
                q.add(new int[]{i-1,j,time+1});
            }
            if(isValid(grid,i+1,j,n,m)){
                grid[i+1][j]=2;
                q.add(new int[]{i+1,j,time+1});
            }
            if(isValid(grid,i,j-1,n,m)){
                grid[i][j-1]=2;
                q.add(new int[]{i,j-1,time+1});
            }
            if(isValid(grid,i,j+1,n,m)){
                grid[i][j+1]=2;
                q.add(new int[]{i,j+1,time+1});
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                    return -1;
        return time;
    }
    private boolean isValid(int[][] arr,int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && arr[x][y]==1;
    }
}