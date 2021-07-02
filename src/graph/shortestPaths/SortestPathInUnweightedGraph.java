package graph.shortestPaths;

//similar problem : https://practice.geeksforgeeks.org/problems/level-of-nodes-1587115620/1/?track=SPC-Graph&batchId=154
import java.util.*;

public class SortestPathInUnweightedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfVertices = sc.nextInt();
        int noOfEdges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList =new ArrayList<>(noOfVertices);
        for(int i = 0 ; i<noOfVertices;i++)adjList.add(new ArrayList<>());
        for(int i =  0;i <noOfEdges ; i++){
            int x = sc.nextInt();
            int y =sc.nextInt();
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        int start = sc.nextInt();
        System.out.println(Arrays.toString(bfs(adjList , noOfVertices , start)));
    }

    /**
     * time complexity o(v+e)
     *why to use BFS??? , in bfs we visit in shortest path manner.
     * first we visited the nearest node then nearest of neighbours and so on like Level order traversal
     * i.e. first we visit node at distance 1 from start , then nodes at distance 2 from start and so on.
     */
    public static int[] bfs(ArrayList<ArrayList<Integer>> adjList, int noOfVertices, int start) {
        int[] distance = new int[noOfVertices];
        Arrays.fill(distance,-1);
        // if after bfs, we find the distance of a node to be -1 ,then its an unreachable node(disconnected graph)
        boolean[] isVisited = new boolean[noOfVertices];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start , 0});
        isVisited[start] = true;
        while (!q.isEmpty()) {
            int[] parent = q.poll();
            distance[parent[0]] = parent[1];
            for (int neig : adjList.get(parent[0])) {
                if (!isVisited[neig]) {
                    isVisited[neig] = true;
                    q.add(new int[]{neig , parent[1]+1});
                }
            }
        }
        return distance;
    }
}
