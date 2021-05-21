package backtracking;
//problem link : https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/?track=SPC-Graph&batchId=154
public class WhetherPathExist {
    public static int is_possible(int M[][], int n) {
        int sx = 0;
        int yx = 0;
        for(int i = 0;i<n;i++)
            for(int j = 0;j<n;j++){
                if(M[i][j]==1){
                    sx = i;
                    yx = j;
                    break;
                }
            }
        boolean[][] visited = new boolean[n][n];
        if(findPath(M , sx,yx ,visited))
            return 1;
        return 0;

    }
    public static boolean findPath(int arr[][] , int i , int j , boolean[][] visited){
        if(arr[i][j]==3)
            visited[i][j] = true;
        if(arr[i][j]==2)return true;
        boolean a1 =false;
        boolean a2 =false;
        boolean a3 =false;
        boolean a4 =false;
        if(i+1<arr.length && arr[i+1][j]!=0 && !visited[i+1][j])
            a1 = findPath(arr , i+1 , j  , visited);
        if(i-1>=0 && arr[i-1][j]!=0 && !visited[i-1][j])
            a2 = findPath(arr , i-1 , j , visited);
        if(j-1>=0 && arr[i][j-1]!=0 && !visited[i][j-1])
            a3  = findPath(arr , i , j-1 , visited);
        if(j+1<arr.length && arr[i][j+1]!=0 && !visited[i][j+1])
            a4 = findPath(arr , i, j+1 , visited);
        return a1||a2||a3||a4;

    }
}
