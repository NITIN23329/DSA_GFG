package backtracking;
//problem link : https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1/?track=DSASP-Backtracking&batchId=154
import java.util.*;

public class MColoring {
    boolean graphColoring(int n, List<int[]> edges, int m) {
        adj = new ArrayList[n];
        for(int i=0;i<n;i++)adj[i] = new ArrayList<>();
        for(int[] x : edges){
            if(x[0] == x[1])continue;
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
        }
        
        vis = new int[n];
        boolean ans = true;
        for(int i=0;i<n;i++)
            if(vis[i] == 0)ans &= dfs(i,m,n);
        return ans;
        
    }
    List<Integer> [] adj;
    int[] vis;
    private boolean dfs(int x, int m, int n){
        boolean ans = false;
        for(int c=1;c<=m;c++){
            vis[x] = c; // try out all possible colors for current node
            boolean currAns = true;
            for(int y : adj[x]){
                if(vis[y] == 0)currAns &= dfs(y,m,n); // check for next node can we color it properly?, since it is bidirectional, it will if we try to color next node with color of current node, then it will get checked in next else if conidion
                else if(vis[y] == vis[x]){
                    currAns = false;
                    break;
                }
            }
            ans |= currAns;
        }
        vis[x] = 0; //backtrack
        return ans;
        
    }
}
/*
test case:
16
4
40
9 16 4 6 1 3 13 15 1 11 14 15 9 10 14 16 2 6 5 12 10 12 13 14 3 13 11 16 4 7 3 6 15 16 12 13 2 13 13 16 10 16 1 2 9 13 3 4 8 14 8 13 12 14 5 9 6 11 11 12 3 10 2 16 11 14 9 15 6 8 8 9 8 10 9 11 8 12 3 15
ans : 1
 */
//https://ide.geeksforgeeks.org/2rP1LyFB8Z
