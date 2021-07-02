package graph.shortestPaths;
//problem link : https://www.hackerrank.com/challenges/dijkstrashortreach/problem
//problem link : https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1/?track=SPC-Graph&batchId=154
// dijkstra does not work for negative weights.

import java.util.*;

public class DijkstrasAlgo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for (int i = 0; i < nov; i++)
            list.add(i, new ArrayList<>());
        for (int i = 1; i <= edg; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w= sc.nextInt();
            list.get(u).add(new Integer[]{v,w});
            list.get(v).add(new Integer[]{u,w});
        }
        int start = sc.nextInt();
        System.out.println(Arrays.toString(dijkstras(list , nov , start)));

    }
    public static int[] dijkstras( ArrayList<ArrayList<Integer[]>> adjList , int noOfVertices,int start){
        //time complexity O(E*logE)
        // take the nearest node to source update its neighbour distance , do this until you visited all nodes
        //approach : use a priority queue which gives the shortest distant node from source which is not visited yet
        //take out the next shortest node from priority queue , mark it as visited
        // and relax all of its adjuscent nodes and only add those adjuscent
        // which are not visited and have been relaxed
        //
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] distance = new int[noOfVertices];
        Arrays.fill(distance , Integer.MAX_VALUE);
        boolean[] isVisited = new boolean[noOfVertices];
        pq.add(new Integer[]{start , 0});
        while(!pq.isEmpty()){
            Integer[] x = pq.poll();
            if(isVisited[x[0]])continue;
            isVisited[x[0]] = true;
            distance[x[0]] = x[1];
            for(Integer[] child : adjList.get(x[0])){
                int currDistance = x[1]+child[1];
                if(!isVisited[child[0]] && currDistance<distance[child[0]])
                    pq.add(new Integer[]{child[0],currDistance});
            }
        }
        return distance;
    }
}

/*
9 14
0 1 4
1 3 8
3 6 7
6 8 9
8 7 10
7 5 2
5 2 1
2 0 8
1 2 11
2 4 7
3 4 2
4 5 6
3 7 4
6 7 14
0
ans : [0, 4, 8, 12, 14, 9, 19, 11, 21]
 */