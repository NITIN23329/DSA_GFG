package graph.traversal;
// problem link : https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/?track=SPC-Graph&batchId=154
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    //time complexity O(v+e) for adj list and O(v^2) for adj matrix
    // BFS on connected graph ,time Complexity O(e)
    // it does not matter which adjacent node is added to q first.
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList, int N , int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] arr = new boolean[N];
        q.add(start);
        arr[start] = true;
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int x = q.poll();
            list.add(x);
            ArrayList<Integer> temp = adjList.get(x);
            for(int ele : temp){
                if(!arr[ele]){
                    arr[ele] = true;
                    q.add(ele);
                }
            }
        }
        return list;

    }
    //bfs on disconnected graph , time complexity O(e+v)
    static ArrayList<Integer> bfsDisconnected(ArrayList<ArrayList<Integer>> adjList, int N ){
        boolean[] isVisited = new boolean[N];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0  ;i<N ; i++ ){
            if(!isVisited[i])
                bfs(adjList ,isVisited  , list , i);
        }
        return list;
    }
    static void bfs(ArrayList<ArrayList<Integer>> adjList ,boolean[] isVisited   , ArrayList<Integer> list ,int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        while (!q.isEmpty()){
            int x = q.poll();
            list.add(x);
            ArrayList<Integer> temp = adjList.get(x);
            for(int ele : temp){
                if(!isVisited[ele]){
                    isVisited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}
