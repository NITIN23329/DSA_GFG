package graph;

import java.util.*;
//problem link : https://leetcode.com/problems/critical-connections-in-a-network/submissions/
/*
 *time complexity O(v+e)
 * only difference between algo of articular point and bridges is that
 * in bridges we check for a u that there is a child v, such that
 *  v has connections with strict ancestors of u(not with u).
 * but in articular point we check for a u that there is a child v ,
 * such that v has connections with either u and/or with strict ancestors of u
 * i.e for articular point we check visitTime[current] <= lowTime[neighbour]
 * for bridges we check  visitTime[current] < lowTime[neighbour]
 */
public class Brideges {
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
        ArrayList<ArrayList<Integer>> bridges = findBridges(adjList, noOfVertices);
        for (ArrayList<Integer> ele : bridges) System.out.println(ele);
    }

    private static int timer;
    private static int[] visitTime;
    private static  int[] lowTime;
    public static ArrayList<ArrayList<Integer>> findBridges(ArrayList<ArrayList<Integer>> adj, int v) {
        timer = 0;
        visitTime = new int[v];
        lowTime = new int[v];
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
        findBridges(adj,0,-1,bridges);
        return bridges;
    }

    private static void findBridges(ArrayList<ArrayList<Integer>> adj,int curr,int parent, ArrayList<ArrayList<Integer>> bridges){
        timer++;
        visitTime[curr] = timer;
        lowTime[curr] = timer;
        int lowest = timer;
        for(int child : adj.get(curr)){
            if(visitTime[child]==0)
                findBridges(adj,child,curr,bridges);
            if(child!=parent){
                if(visitTime[curr]<lowTime[child]){
                    ArrayList<Integer> temp = new ArrayList<>(2);
                    temp.add(curr);temp.add(child);
                    bridges.add(temp);
                }
                lowest = Math.min(lowest,lowTime[child]);
            }
        }
        lowTime[curr] = lowest;
    }

}
