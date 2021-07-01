/*
    created by: nitin23329
    on Date: 01/07/21
*/

// problem link : https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1/
package graph.minimumSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KrushkalsAlgo$MST {
    // DSU by rank
    static class DSU{
        int[] parent,rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++)
                makeSet(i);
        }
        public void makeSet(int x){
            parent[x] = x;
            rank[x] = 0;
        }
        public int find(int x){
            while(x != parent[x])x = parent[x];
            return x;
        }
        public void union(int x,int y){
            x = find(x);
            y = find(y);
            if(x==y)return;
            if(rank[x]>rank[y])parent[y] = x;
            else if(rank[y]>rank[x])parent[x] = y;
            else {
                parent[y] = x;
                rank[x]++;
            }
        }
        public boolean isInSameSet(int x,int y){
            return find(x) == find(y);
        }
    }
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
        System.out.println(spanningTree(nov , list));

    }
    /*
        Time complexity : o(eloge), e being # of edges in the graph.
        Krushkal's algo: Put all edges in a min heap according to their weight.
        --> The take out the edges one by one from the min heap and check if adding the edge creates a cycle or not.
        --> If adding this edge to our MST creates cycle, then that edge will not be helpful in creating our MST hence discard that edge.
        --> Otherwise add this edge to MST and add its cost to our answer.
     */
    static int spanningTree(int n, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[2]-b[2]));
        for(int parent=0;parent<n;parent++){
            for(int[] neig : adj.get(parent)){
                int child = neig[0];
                int weight = neig[1];
                if(child<parent)continue;   // don't process same edge twice.
                pq.add(new int[]{parent,child,weight});
            }
        }
        DSU dsu = new DSU(n);
        int cost = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int from = curr[0];
            int to = curr[1];
            int weight = curr[2];
            if(dsu.isInSameSet(from,to))continue;
            cost += weight;
            dsu.union(from,to);
        }
        return cost;
    }
}
