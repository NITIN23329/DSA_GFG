package graph;
//problem link : https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1/?track=DSASP-Graph&batchId=154
import java.util.*;
/*      time complexity o(n^2)  , space complexity O(n^2)
    * approach : do a bfs

 */
public class StepsByKnight {
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        if(KnightPos[0]==TargetPos[0] && KnightPos[1]==TargetPos[1])
            return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(KnightPos);
        boolean[][] isVisited = new boolean[N+1][N+1];
        isVisited[KnightPos[0]][KnightPos[1]] = true;
        int c=1;
        while(!q.isEmpty()){
            int s = q.size();
            for(int j=0;j<s;j++){
                int[] z = q.poll();
                int x = z[0];int y = z[1];
                int[] dx = {-2,-2,-1,-1,1,1,2,2};
                int[] dy = {-1,1,-2,2,2,-2,-1,1};
                for(int i=0;i<8;i++){
                    if(x+dx[i]==TargetPos[0] && y+dy[i]==TargetPos[1])
                        return c;
                    if(isValid(x+dx[i],y+dy[i],N) && !isVisited[x+dx[i]][y+dy[i]]){
                        q.add(new int[]{x+dx[i],y+dy[i]});
                        isVisited[x+dx[i]][y+dy[i]] = true;
                    }
                }
            }
            c++;
        }
        return -1;
    }
    private boolean isValid(int x,int y,int n){
        return x>=1 && y>=1 && x<=n && y<=n;
    }
}
