package graph.shortestPaths;

import java.util.*;

/**
 * ********************************************IMPORTANT***************************************
 * solution link : https://www.youtube.com/watch?v=TXkDpqjDMHA&t=39s
 * time complexity O(v+e) . unlike dijkstra's weights can be negative
 * This is only applicable on DAG for single source shortest path
 * uses topological sorting , we process the nodes according to topological ordering,
 * topological sort ensures we visit each node after visiting all its parents
 * then we update the distance of each child node if the current path is shorter than previous one
 * only thing to keep in mind is that we choose that
 * node as starting point whose indegree initially is 0, or if it has more than 0 indegree ,
 * all parent nodes of it must not increase the indegree of any node we are going to visit
 *
 *
 * if we are asked to find longest path in DAG , we multiply each weights by -1 and the apply the above algo.
 *  after finding the shortest path we multiply our result by -1 which gives longest path
 *  or we can find max() instead of min()
 */

public class ShortestPathInDAG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for (int i = 0; i < nov ; i++)
            list.add(i, new ArrayList<>());
        for (int i = 0; i < edg; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            Integer[] node = new Integer[]{y,z};
            list.get(x).add(node);
        }
        int start = sc.nextInt();
            System.out.println(Arrays.toString(distanceUsingTopologicalSort(list, nov, start)));

    }
    // find topological sorting and then relax each edge
    public static long[] distanceUsingTopologicalSort(ArrayList<ArrayList<Integer[]>> adjList , int noOfVertices,int start) {
        long[] distance = new long[noOfVertices];
        Arrays.fill(distance, Long.MAX_VALUE);
        int[]  topoSort = topoSort(adjList , noOfVertices);
        distance[start]=0L;
        for(int i = 0;i<noOfVertices;i++){
            int parent = topoSort[i];
            if(distance[parent]==Long.MAX_VALUE)continue;
            ArrayList<Integer[]> child = adjList.get(parent);
            for(Integer[] ele : child){
                 distance[ele[0]] = Math.min(distance[ele[0]],distance[parent]+ele[1]);
            }

        }
        return distance;
    }

    private static int[] topoSort(ArrayList<ArrayList<Integer[]>> adjList, int noOfVertices) {
        int[] inDegree = new int[noOfVertices];
        for (ArrayList<Integer[]> list : adjList)
            for (Integer[] ele : list) inDegree[ele[0]]++;
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[noOfVertices];
        for(int i=0;i<noOfVertices;i++)
            if(inDegree[i]==0)q.add(i);
            int i = 0;
        while (!q.isEmpty()){
            int x = q.poll();
            res[i++] = x;
            for(Integer[] ele : adjList.get(x )){
                inDegree[ele[0]]--;
                if(inDegree[ele[0]]==0)q.add(ele[0]);
            }
        }
        return res;
    }
    /*
    // another code : relax edges during topological sorting
    private static int[] shortestPathInDAG(ArrayList<ArrayList<int[]>> adj, int v, int source){
        int[] distance = new int[v];
        //initially fill the distance array with infinite value
        Arrays.fill(distance,Integer.MAX_VALUE);
        int[] inDegree = new int[v];
        //calculating in-degree of each node
        for(int parent=0;parent<v;parent++)
            for(int[] child : adj.get(parent))inDegree[child[0]]++;
        // nullifying the out-degree of all nodes whose initial in-degree is 0 and not is a source
        // 0-->1<--2 , suppose starting node is 0, we can not enter node 1 cuz of 2. 2 has in-degree also 0 we will nullify its all out-degree
        for(int parent=0;parent<v;parent++)
            if(inDegree[parent]==0 && parent!=source){
                for(int[] child : adj.get(parent))inDegree[child[0]]--;
            }
        // doing the topological sorting
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{source,0});
        distance[source] = 0;
        while (!q.isEmpty()){
            int[] parent = q.poll();
            for(int[] child : adj.get(parent[0])){
                inDegree[child[0]]--;
                //relaxing the edge from parent to child
                distance[child[0]] = Math.min(distance[child[0]],distance[parent[0]]+child[1]);
                if(inDegree[child[0]]==0)q.add(child);
            }
        }
        return distance;
    }
     */

}
/*
test case 1
5 6
0 2 -7
0 3 -3
2 3 3
1 0 8
4 2 6
4 1 3
4
ans :[11, 3, 4, 7, 0]
 */
/*
test case 2
5 6
0 2 -7
0 3 -3
2 3 3
1 0 8
4 2 6
4 1 3
0
ans :[0, 2147483647, -7, -4, 2147483647]
 */
/*
test case 3
6 9
0 1 7
0 3 4
2 0 3
2 4 -1
1 3 5
1 5 1
3 5 -2
4 1 6
4 0 2
2
ans : [1, 5, 0, 5, -1, 3]
 */
/*
test case 4 :
5 6
0 2 2
0 3 3
3 2 5
2 1 -3
3 4 1
1 4 4
0
ans: [0, -1, 2, 3, 3]
 */
/*
test case 5 :
8 13
0 1 3
0 2 6
1 2 4
1 4 11
1 3 4
2 3 8
2 6 11
3 4 -4
3 5 5
3 6 2
4 7 9
5 7 1
6 7 2
0
ans : [0, 3, 6, 7, 3, 12, 9, 11]
 */