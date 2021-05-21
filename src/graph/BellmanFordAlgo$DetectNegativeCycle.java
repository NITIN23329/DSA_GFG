package graph;
// problem link : https://practice.geeksforgeeks.org/problems/negative-weight-cycle/0
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFordAlgo$DetectNegativeCycle {
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
            //list.get(v).add(new Integer[]{u,w});
        }
        int start = sc.nextInt();
        System.out.println(Arrays.toString(bellmanFord(list , nov , start)));

    }

    /** time complexity O(ve)
     *
     *approach : we iterate through all edges and relax them for noOfvertices-1 times
     * first we make a distance array which keep hold of shortest path from start to all other nodes.
     * If there are negative cycle , then all nodes affected by it is marked a distance of Integer.MIN_VALUE
     *
     * why we do this noOfVertices-1 times??
     * reason : after first iteration we found shortest path for all nodes which are at most 1 edge distant from start,
     * after 2nd iteration we find shortest path for all nodes which are at most 2 edge distant from start and so on.
     * After noOfVeritces-1 times we find shortest path for all nodes which are
     * at most noOfVeritces-1 distant because in longest path there are noOfVertices -1 edges
     * we do not need to always do noOfVertices-1 iteration to find shortest path , sometime it can be found earlier.
     * We take extra boolean isFound is true if we relax some edges in a iteration.
     * If we don't relax any edge then we must found shortest path and return .
     *
     * If there are negative cycle present then we keep relaxing some edges
     * even after noOfVertices-1 time to infinite time.
     *
     */
    public static int[] bellmanFord(ArrayList<ArrayList<Integer[]>> graph , int noOfVertices,int start){
        int[] distance = new int[noOfVertices];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        boolean isFound;
        for(int count = 0;count<noOfVertices-1;count++){
            isFound = false;
            for(int i =noOfVertices-1;i>=0;i--)
                for(int j=0;j<graph.get(i).size();j++){
                    if(distance[i]==Integer.MAX_VALUE)break;
                    int weight =graph.get(i).get(j)[1];
                    int neigh  = graph.get(i).get(j)[0];
                    if(distance[i]+weight<distance[neigh]){
                        distance[neigh] = distance[i]+weight;
                        isFound = true;
                    }
                }
            if(!isFound) {
                System.out.println("FOUND DISTANCE IN LESS TIME :)");
                return distance;
            }


        }

        boolean isNegativeCycle = false;
        for(int i=noOfVertices-1;i>=0;i--){
            for(int j = 0;j<graph.get(i).size();j++) {
                int weight = graph.get(i).get(j)[1];
                int neigh = graph.get(i).get(j)[0];
                if (distance[i] + weight < distance[neigh]) {
                    isNegativeCycle = true;
                    break;
                }
            }
            if(isNegativeCycle)break;
        }
        if(isNegativeCycle) System.out.println("NEGATIVE CYCLE EXISTS ");
        else System.out.println("NO NEGATIVE CYCLE DETECTED");
        return distance;
    }
}
