/*
    created by: nitin23329
    on Date: 02/07/21
*/
package graph.graphDP;

import java.io.IOException;
import java.util.*;

/**     ********************************IMPORTANT***********************************
 * problem link : https://cses.fi/problemset/task/1202/
 *  Approach : dijkstra's + graph DP.
 *      --> find the answers we are asked for, we need to create a shortest path DAG without missing information
 *          like multiple paths with same least distance to a node from start.
 *      --> We can see that the edges that are used by dijkstra's to find the shortest path always forms DAG.
 *      --> So we first run a dijkstra's to find the shortest path distance to each node from node 1.
 *      --> Then we need to store only those edges which are used by the dijkstra's to calculate the distances.
 *      -->  if we know that we can reach from a parent node to a child node such that
 *          the least distance to reach parent node + this edge weight = least distance to reach child node
 *           then, the current edge is used by dijkstra's and we add this edge in our DAG.
 *          ( Alternatively we can say while reaching to child node from start with the shortest distance,
 *              if we can use this edge then this edge should be added to DAG).
 *           By doing this, we also add all the multiple paths with least distance.
 *      --> After forming the DAG, we use the graph dp to find the requested information by traversing
 *          the DAG in topological sort fashion
 *
 *
 */
public class Investigation {
    static ArrayList<int[]>[] adj;  // the adjacency list given in the input. Can't assume DAG, cycle may present.
    static ArrayList<Integer>[] dagAfterDijkstra;   // the DAG we get from the dijkstra's algo
    static long[] distance;
    static int[] inDegree;
    private static void dijkstra(int n){
        distance = new long[n+1];
        Arrays.fill(distance,inf_long);
        boolean[] visited = new boolean[n+1];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->(Long.compare(a[1],b[1])));
        pq.add(new long[]{1,0});
        while (!pq.isEmpty()){
            long[] curr = pq.poll();
            int currNode = (int)curr[0];
            long currDistance = curr[1];
            if(visited[currNode])continue;
            visited[currNode] = true;
            distance[currNode] = currDistance;
            for(int[] neig : adj[currNode]){
                long neigDist = currDistance + neig[1];
                int neigNode = neig[0];
                if(!visited[neigNode] && neigDist<distance[neigNode]){
                    distance[neigNode] = neigDist;
                    pq.add(new long[]{neigNode,neigDist});
                }
            }
        }
        setDagAfterDijkstra(n);
    }
    private static void setDagAfterDijkstra(int n){
        inDegree = new int[n+1];
        for(int node = 1;node<=n;node++){
            for(int[] neig : adj[node]){
                long neigDist = distance[node] + neig[1];
                int neigNode = neig[0];
                if(neigDist == distance[neigNode]){
                    dagAfterDijkstra[node].add(neigNode);
                    inDegree[neigNode]++;
                }
            }
        }
        graphDP(n);
    }
    private static void graphDP(int n){
        long[] waysToReach = new long[n+1];
        int[] minEdgeInWay = new int[n+1];
        int[] maxEdgeInWay = new int[n+1];
        waysToReach[1] = 1;
        Arrays.fill(minEdgeInWay,inf_int);
        minEdgeInWay[1] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()){
            int curr = q.poll();
            for(int neig : dagAfterDijkstra[curr]){
                if(--inDegree[neig] == 0)q.add(neig);
                waysToReach[neig] += waysToReach[curr];
                waysToReach[neig] %=mod;
                if(minEdgeInWay[neig]>1 + minEdgeInWay[curr])
                    minEdgeInWay[neig] = 1 + minEdgeInWay[curr];
                if(maxEdgeInWay[neig]<1 + maxEdgeInWay[curr])
                    maxEdgeInWay[neig] = 1 + maxEdgeInWay[curr];
            }
        }
        System.out.println(distance[n]+" "+waysToReach[n]+" "+minEdgeInWay[n]+" "+maxEdgeInWay[n]);

    }
    @SuppressWarnings({"unchecked"})
    private static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        adj = new ArrayList[n+1];
        dagAfterDijkstra = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
            dagAfterDijkstra[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            adj[x].add(new int[]{y,z});
        }
        dijkstra(n);
    }
    static long inf_long = (long)1e15;
    static int inf_int = (int)1e9;
    static int mod = (int)1e9+7;
}
