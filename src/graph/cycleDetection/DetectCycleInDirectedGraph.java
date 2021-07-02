package graph.cycleDetection;
/**
 * **********************************************************IMPORTANT**********************************
 * problem link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/?track=SPC-Graph&batchId=154
 * if above don't work : https://www.interviewbit.com/problems/cycle-in-directed-graph/
 */

import java.util.*;

public class DetectCycleInDirectedGraph {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                int nov = sc.nextInt();
                int edg = sc.nextInt();
                for (int i = 0; i < nov + 1; i++)
                    list.add(i, new ArrayList<Integer>());
                for (int i = 1; i <= edg; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    list.get(u).add(v);
                }
                System.out.println(isCyclicEfficient(list , nov));
        }
    //time complexity O(v+e) ,
    //solution  link ; https://www.youtube.com/watch?v=ZS-UPTd73cM&t=239s
    // we say there is a cycle if there we can move from a descendant to its ancestors.
    // we need to keep track of all elements present in current path , we use presentStack boolean array for that,
    // while doing dfs check if  neighbours of a node are present in stack , if yes then cycle found
    // don't check if the element is visited , check element in stack ,
    // after checking all paths from a particular node , make presentStack of it as false i.e remove it from stack.
    // we need current stack cuz consider graph 0-->1<--2 , if we use detect cycle in undirected graph ,
    // we mark 0 and 1 visited and when we do dfs from 2 we see 1 is visited and we return true which is wrong

    static boolean isCyclicEfficient(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean[] isVisited = new boolean[V];
        for(int i=0;i<V;i++)
            if(!isVisited[i]){
                if(dfs(i,adj,isVisited,new HashSet<>()))return true;
            }
        return false;
    }
    private static boolean dfs(int curr,ArrayList<ArrayList<Integer>> adj,boolean[] isVisited,Set<Integer> currStack){
        if(currStack.contains(curr))return true;
        currStack.add(curr);
        for(int neig : adj.get(curr)){
            if(!isVisited[neig]){
                boolean x = dfs(neig,adj,isVisited,currStack);
                if(x)return true;
            }
        }
        isVisited[curr] = true;
        currStack.remove(curr);
        return false;
    }
    // another efficient approach using kahn's algorithm
    // do topological sorting ,  at any point if we found that there is no node
    // whose indegree is 0 we get that there is a cycle
    // so we do topo sort and store the result in arraylist , if list .size == no of nodes
    // that means no cycle else cycle

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int[] inDegree = new int[n];
        for(int parent=0;parent<n;parent++)
            for(int child : adj.get(parent))
                inDegree[child]++;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)q.add(i);
        int z = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            z++;
            for(int child : adj.get(x)){
                inDegree[child]--;
                if(inDegree[child]==0)q.add(child);
            }
        }
        return z!=n;
    }
}