package graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//
/**
 *  problem link : https://practice.geeksforgeeks.org/problems/bipartite-graph/1
 *  A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
 *  U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
 *  approach : time O(e+v)
 *      --> do a bfs ,
 *      --> mark all neighbour of red with blue color
 *      --> mark all neighbour of blue with red color
 *      -->if we see that any 2 adjacent nodes are marked with same color, then its not a bipartite graph
 *      --> if a cycle have even # of nodes , then it is bipartite graph
 */

public class Bipartite {
    boolean isBipartite(int G[][],int V)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++){
                if(G[i][j]==1)  adj.get(i).add(j);
            }
        boolean [] isVisited = new boolean[V];
        boolean [] value = new boolean[V];
        for(int i=0;i<V;i++)
            if(!isVisited[i])
                if(!bfs(adj,i,isVisited,value))return false;
        return true;

    }
    boolean bfs(List<List<Integer>> adj , int start,boolean[] isVisited,boolean[] value){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        value[start] = true;
        while(!q.isEmpty()){
            int parent = q.poll();
            for(Integer child : adj.get(parent)){
                if(isVisited[child]){
                    if(value[parent]==value[child]){
                        return false;
                    }
                }else{
                    q.add(child);
                    isVisited[child] =true;
                    value[child] = !value[parent];
                }
            }
        }
        return true;
    }
}
