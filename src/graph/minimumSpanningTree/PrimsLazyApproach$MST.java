package graph.minimumSpanningTree;
import java.util.*;
// problem link : https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1/?track=SPC-Graph&batchId=154
/**
 * definition of MST :
 * 1) it is a weighted(may be positive or negative weights) , undirected graph
 * 2) it has exactly noOfVertices-1 edges
 * 3) it doges not contains cycle
 * 4)it is a connected graph
 * 5) all vertices are connected to each other directly or indirectly.
 * 6) for a given graph, total no of MST : (noOFEdges)
 *                                                     C                     - noOfCycle
 *                                                        (noOfVertices-1)
 */
public class PrimsLazyApproach$MST {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<int[]>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for (int i = 0; i < nov; i++)
            list.add(i, new ArrayList<>());
        for (int i = 1; i <= edg; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w= sc.nextInt();
            list.get(u).add(new int[]{v,w});
            list.get(v).add(new int[]{u,w});
        }
        System.out.println(primsLazy(list , nov));

    }
    //time complexity O(e * loge) ; e = no of edges
    // (william fiset) : https://www.youtube.com/watch?v=jsmMtJpPnhU
    // approach : maintain a boolean array which keep track of elements visited so far.
    // start from any node .Mark it visited and add all its neighbour to priority queue
    // use priority queue which gives us next shortest path node which is not visited till now.
    // mark it visited and add all its neighbour to priority queue which are not visited yet,
    // do this until all nodes are visited.
    private static int primsLazy(List<List<int[]>> adj,int v){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int[] ele : adj.get(0))pq.add(ele);
        int cost = 0;
        boolean[] isVisited = new boolean[v];
        isVisited[0] = true;
        while (!pq.isEmpty()){
            int[] x = pq.poll();
            if(isVisited[x[0]])continue;
            isVisited[x[0]] = true;
            cost+=x[1];
            for(int[] ele : adj.get(x[0]))
                if(!isVisited[ele[0]])
                    pq.add(ele);
        }
        return  cost;
    }

}
