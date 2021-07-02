package graph.traversal;
//problem link : https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1/?track=DSASP-Graph&batchId=154#
import java.util.LinkedList;
import java.util.Queue;
/*  time complexity O(nm), space complexity O(nm)
    approach : do a bfs
        --> add all cells having 1 with a distance of 0 to queue initially
        --> poll these cells update their distance and add all those cells having 0 in up/down.left/right whose distance is not calculated yet.
        --> make a boolean[][] which keep track of those cells whose distance is updated so dont add them to queue again
        -->

 */
public class DistanceOfNearestCellHaving1 {
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isPresent = new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                    isPresent[i][j] = true;
                }

        while(!q.isEmpty()){
            int[] z = q.poll();
            int i = z[0];
            int j = z[1];
            int w = z[2];
            grid[i][j]=w;
            if(i-1>=0 && grid[i-1][j]==0 && !isPresent[i-1][j]){
                q.add(new int[]{i-1,j,w+1});
                isPresent[i-1][j] = true;
            }
            if(i+1<n && grid[i+1][j]==0&& !isPresent[i+1][j]){
                q.add(new int[]{i+1,j,w+1});
                isPresent[i+1][j] = true;
            }
            if(j-1>=0 && grid[i][j-1]==0&& !isPresent[i][j-1]){
                q.add(new int[]{i,j-1,w+1});
                isPresent[i][j-1] = true;
            }
            if(j+1<m && grid[i][j+1]==0&& !isPresent[i][j+1]){
                q.add(new int[]{i,j+1,w+1});
                isPresent[i][j+1] = true;
            }
        }
        return grid;
    }
}
