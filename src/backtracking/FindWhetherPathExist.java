package backtracking;
//problem link : https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
class Solution
{
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        int sx = -1, sy=-1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    sx=i;sy=j;
                }
            }
        if(sx==-1)return false;
        return dfs(sx,sy,grid,new boolean[n][n]);
    }
    private boolean dfs(int x,int y,int[][]grid,boolean[][] isVisited){
        isVisited[x][y] =true;
        if(grid[x][y]==2)return true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i],y+dy[i],grid,isVisited)){
                boolean ans = dfs(x+dx[i],y+dy[i],grid,isVisited);
                if(ans)return true;
            }
        }
        return false;

    }
    private boolean isValid(int x,int y,int[][]grid,boolean[][] isVisited){
        return x>=0 && y>=0 && x<grid.length && y<grid.length && (!isVisited[x][y]) && (grid[x][y]==3 || grid[x][y]==2);
    }
}