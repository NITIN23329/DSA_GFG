package graph.traversal;
//problem link : https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/?track=SPC-Graph&batchId=154
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DFSTraversal {
    //time complexity O(v+e)
    //iterative
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjList, int noOfVertices,int start)
    {
        boolean[] visited = new boolean[noOfVertices];
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(start);
        visited[start]=true;
        while(!dq.isEmpty()){
            int parent = dq.pop();
            list.add(parent);
            ArrayList<Integer> neig = adjList.get(parent);
            for(int i = neig.size()-1;i>=0;i--){
                if(!visited[neig.get(i)]){
                    visited[neig.get(i)] = true;
                    dq.push(neig.get(i));
                }
            }

        }
        return list;

    }
    //recursive
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        boolean[] isVisited = new boolean[N];
        ArrayList<Integer> list = new ArrayList<>();
        traversal(g , list , isVisited , 0);
        return list;
    }
    private static void traversal(ArrayList<ArrayList<Integer>> g ,ArrayList<Integer> list,boolean[] isVisited , int start ){
        ArrayList<Integer> temp = g.get(start);
        isVisited[start] = true;
        list.add(start);
        for(int ele : temp){
            if(!isVisited[ele]){
                traversal(g , list , isVisited , ele);
            }
        }
    }

}
