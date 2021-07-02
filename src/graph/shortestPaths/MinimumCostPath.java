package graph.shortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostPath {
    // time O(n*nlog(n*n))
    // create a graph from node # 0 to n-1 like
    // 0,1,2,3,4
    // 5,6,7,8,9 , so on
    // for every vertex , create edge to its left,right,up,down node
    //apply dijkstra's algo from 0 to n-1

    public int minimumCostPath(int[][] grid)
    {

        List<List<int[]>> adj = new ArrayList<>();
        int n = grid.length;
        for(int i=0;i<n*n;i++)adj.add(new ArrayList<>());
        int c = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(j+1<n)adj.get(c).add(new int[]{c+1,grid[i][j+1]});
                if(j-1>=0)adj.get(c).add(new int[]{c-1,grid[i][j-1]});
                if(i-1>=0)adj.get(c).add(new int[]{c-n,grid[i-1][j]});
                if(i+1<n)adj.get(c).add(new int[]{c+n,grid[i+1][j]});
                c++;
            }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        boolean[] isVisited = new boolean[n*n];
        int[] distance = new int[n*n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        pq.add(new int[]{0,grid[0][0]});
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(isVisited[x[0]])continue;
            isVisited[x[0]] = true;
            distance[x[0]] = x[1];
            for(int[] neig : adj.get(x[0])){
                int currD = x[1]+neig[1];
                if(!isVisited[neig[0]] && currD<distance[neig[0]]){
                    pq.add(new int[]{neig[0],currD});
                    distance[neig[0]] = currD;
                }
            }
        }
        return distance[n*n-1];
    }
}
