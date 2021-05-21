package graph;

import java.util.*;

/**
 * Articular nodes are those nodes, removing them and their corresponding edges will increase the # of disconnected components in graph
 */
//problem link : https://www.techgig.com/practice/question/articulation-points/OGhBQ3VDV1hmd1l6WG8zREhMZUYyWEtzbEEzUUx4ZWhwc2g2c1lpT2x5TjJyY3dPeHhxWXlrai8yS0JuVmZKbQ==/1
// when v==5 , take v=6 broken case
public class ArticulationPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfVertices = sc.nextInt();
        int noOfEdges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < noOfEdges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        System.out.println(articulationPointEfficient(adjList, noOfVertices));
    }
    /*
    * naive approach
    * time complexity O(v*(v+e))
    * For every vertex v, do following
    * 1)Remove v from graph
    * 2)do dfs and check now all nodes other than removed one are
    * visitable or not. if no then the removed node is an articular point
    * 3)Add v back to the graph
     */

    /*
    * efficient approach
    * time complexity O(v+e)
    * solution link : https://www.youtube.com/watch?v=2kREIkF9UAs&t=604s
    * data requires:
    * a) a timer which will increments when we visit new node
    * b) an array to store visit time of each node / time stamp of each node
    * c) an lowValue array to store the minimum of low values of current node and its neighbour nodes
    * d) we don't need to make a extra visited array , as the time starts from 1 , any node's visit time is 0 means its not visited yet.
    * e) parent of each node
    * procedure:
    * a)do dfs from any node
    * b) for every new node we visit in dfs , update the timer and
    *   set visit time and low value as timer
    * c) if the visit time of current node <= low value of any neighbour excluding its parent,
    *  then it will be a articular point.
    * d) update the low value with its neighbour low values at last,if updated,then it means there is a back edge found
    * e)Don't do above approach for starting node.For starting node ,
    * if there are >=2 independent children then root node is an articular point
    *
    * significance of low value :
    * (low value of a node is the smallest discoverable time reachable from that node (including itself) while dfs.
    * Low value of any vertex is basically the lowest discovery time of the vertex we can reach from the current vertex.
    *The significance of this is that, if there's a vertex u which has an adjacent vertex v such that:
    *low[v] >= disc[u]
    *then this means that we cannot reach any ancestor of u via v (as, if it was possible to reach an
    * ancestor of u via v, then the low[v] would have been less than the disc[u]).
    *Therefore, it a node satisfies this condition, then it means that there's no way we can reach
    * any ancestor of u via v. Hence, removing the node u will separate the graph into 2 separate
    * components (one containing u and the other containing v).
    *So, this is the reason we need it to find the articulation points.
    * in easy means: if there is a node u and from its children v we can not go to ancestors of u then
    * removing u will disconnects v.
    *
     */
    static int timer;
    private static Set<Integer> articulationPointEfficient(ArrayList<ArrayList<Integer>> adj, int v){
        Set<Integer> articular = new HashSet<>();
        timer = 0;
        articularPoints(adj,0,-1,new int[v],new int[v],articular);
        return articular;
    }
    private static void articularPoints(ArrayList<ArrayList<Integer>> adj,int curr,int parent,int[] visitedTime,int[] lowTime,Set<Integer> articular){
        timer++;
        visitedTime[curr] = timer;
        lowTime[curr] = timer;
        int lowest  = timer;
        int c=0;
        for(int child : adj.get(curr)) {
            if (visitedTime[child] == 0){           // not visited child
                articularPoints(adj, child, curr, visitedTime, lowTime, articular);
                c++;
            }
            if(curr==0 && c>1)                  //root node is an exception
                articular.add(0);
            if (child != parent) {              // check visitedTime of curr node with its childer
                if (visitedTime[curr] <= lowTime[child] && curr!=0) articular.add(curr);
                lowest = Math.min(lowest, lowTime[child]);
            }
        }
        lowTime[curr] = lowest;
    }
}
/*
8 9
0 2
0 1
1 2
2 3
3 4
6 4
5 4
6 5
7 5
ans : [2, 3, 4, 5]

6 6
0 1
0 2
1 3
2 3
3 4
3 5
ans : [3]

84 87
9 19 29 31 10 72 57 73 2 19 62 67 83 70 24 78 16 16 59 56 75 9 2 26 26 55 43 19 5 42 66 54 17 51 1 28 79 58 57 81 33 35 20 73 62 44 23 78 17 82 7 8 8 9 74 74 64 73 9 69 32 75 80 5 82 81 73 77 12 3 30 45 38 51 74 56 51 14 7 24 12 14 32 60 63 23 50 43 12 60 68 0 7 64 46 6 18 35 39 70 38 70 71 33 77 62 45 0 76 8 25 44 62 13 21 41 76 71 40 45 3 25 45 11 45 47 57 19 39 52 5 33 78 77 22 71 11 68 28 3 32 53 3 11 66 24 52 59 52 9 60 11 74 61 62 75 25 35 11 64 44 56 13 38 49 76 26 16 60 10 59 8 63 63 57 73
ans : 2 3 5 7 8 9 10 11 16 19 23 24 26 28 32 33 35 43 45 51 56 57 60 62 63 66 70 71 73 74 76 78

3 2
0 1
1 2
ans : 1

5 4
0 1
1 2
0 3
3 4
ans : 0 1 3
*/

