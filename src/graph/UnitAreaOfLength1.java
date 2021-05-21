package graph;

//problem link : https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1/?track=SPC-Graph&batchId=154
/*  time complexity O(nm) , space complexity (nm) excluding recursive stack;
    approach : do a dfs
    --> when arr[i][j]==1 , do a dfs  starting from [i,j] th cell until we don't find any nearer 1
    --> for every dfs ,count how much cells we visited

 */
public class UnitAreaOfLength1 {

    public int findMaxArea(int[][] grid)
    {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1){
                    res = Math.max(res,dfs(grid,i,j,n,m));
                }
        return res;
    }
    private int dfs(int[][] arr,int x,int y,int n,int m){
        arr[x][y]=0;
        int[] dx = {-1,-1,-1,1,1,1,0,0};
        int[] dy = {0,1,-1,0,1,-1,1,-1};
        int ans=1;
        for(int i=0;i<8;i++)
            if(isValid(arr,x+dx[i],y+dy[i],n,m))
                ans+=dfs(arr,x+dx[i],y+dy[i],n,m);
        return ans;

    }
    private boolean isValid(int[][] arr,int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m && arr[x][y]==1;
    }
}
