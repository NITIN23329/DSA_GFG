package graph;
/**
 * ************************************IMPORTANT*********************************************
 */
// problem link : https://practice.geeksforgeeks.org/problems/mother-vertex/1/?track=SPC-Graph&batchId=154
import java.util.*;

public class MotherVertex {
    // approach 1 :
    // do a dfs/ bfs for every node from i=0 to v-1, if all nodes are visited from i, i is the mother vertex
    // time O(v*(v+e))

    // approach 2
    // store a stack according to finishing time of verte
    // i.e. we add a node after visiting all neighbours like kosaraju's algo
    //the most eligible candidate the the top most node in the stack , having highest finishing time
    // do dfs from that node , if we can visit all node , it will be the mother vertex else no vertex is mother vertex
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] isVisited = new boolean[v];
        for(int i=0;i<v;i++)
            if(!isVisited[i])
                dfs(adj,i,isVisited,dq);

        int x = dq.pop();
        if(dfs(adj,x,new boolean[v],new ArrayDeque<>())==v)return x;
        return -1;

    }
    private int dfs(ArrayList<ArrayList<Integer>>adj,int curr,boolean[] isVisited, Deque<Integer> dq ){
        isVisited[curr] = true;
        int x = 1;
        for(int child : adj.get(curr)){
            if(!isVisited[child])
                x+=dfs(adj,child,isVisited,dq);
        }
        dq.push(curr);
        return x;
    }
}
