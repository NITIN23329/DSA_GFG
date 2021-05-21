package graph;
//problem link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/?track=SPC-Graph&batchId=154
import java.util.ArrayList;
import java.util.Stack;

public class DetectCycleInUndirectedGraph {
    // approach : use dfs traversal , in stack we need to keep track
    // of parent so we dont check particular node  with its parent(in undirected graph)
    // if we found a node which is visited previously we found a cycle.
    //time complexity O(v+e)
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adjList, int V)
    {
        // use when graphs are not connected
        boolean[] isVisited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                boolean ans = dfs(adjList , isVisited , i);
                if(ans)return ans;
            }

        }
        return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> adjList , boolean[] isVisited, int start){
        Stack<Integer[]> st = new Stack<>();

        isVisited[start] = true;
        st.push(new Integer[]{start , -1});
        while(!st.isEmpty()){
            Integer[] x = st.pop();
            ArrayList<Integer> neig = adjList.get(x[0]);
            for(int ele :neig ){
                if( ele!= x[1] && isVisited[ele])return true;
                if(!isVisited[ele]){
                    isVisited[ele] = true;
                    st.push(new Integer[]{ele ,x[0]});

                }
            }
        }
        return false;
    }
}
