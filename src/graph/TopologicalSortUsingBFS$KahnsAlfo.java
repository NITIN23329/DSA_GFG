package graph;

import java.util.*;
//problem link : https://practice.geeksforgeeks.org/problems/topological-sort/1/?track=SPC-Graph&batchId=154
public class TopologicalSortUsingBFS$KahnsAlfo {
    /*
       *the intuition behind Khan's algorithm is to repeatedly remove nodes without any dependencies from graph and add to the topological sorting
       * as nodes without dependencies(and their outgoing edges) are removed from graph, new nodes without dependencies should become free
       * we repeat removing nodes without dependencies from graph until all nodes are processed , or a cycle is discovered
     */
    //time complexity O(v+e)
    //happens only in direct acyclic graph (DAG)
    //topological sorting of a graph is not unique
    // solution link : https://www.youtube.com/watch?v=upyl4Voz2lc
    //approach , we use inDegree array  to hold indegrees ( parents) for each node(index is node value).
    // if indegree of a node is 0 then it means that node is not dependent on any other node
    //we take a queue in which we only add those nodes whose indegree is 0
    // we poll from queue and reduce the indegree of all it neighbour(child)
    // we add only those neighbour whose indegree is 0
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] inDegree = new int[n];
        for(int parent=0;parent<n;parent++)
            for(int child : adj.get(parent))inDegree[child]++;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)q.add(i);
        int z = 0;
        int[] topo = new int[n];
        while(!q.isEmpty()){
            int x = q.poll();
            topo[z++]=x;
            for(int child : adj.get(x)){
                inDegree[child]--;
                if(inDegree[child]==0)q.add(child);
            }
        }
        return topo;
    }
}
