package graph.traversal;

import java.util.ArrayList;
import java.util.List;

// problem link : https://leetcode.com/problems/all-paths-from-source-to-target/
/*  approach :
      --> do dfs and find all paths from src to dst
*/
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph,res,0,new ArrayList<>());
        return res;
    }
    private void dfs(int[][] graph,List<List<Integer>> res,int curr,ArrayList<Integer> l){
        l.add(curr);
        if(curr==graph.length-1){
            res.add(new ArrayList<>(l));
        }
        for(int neig : graph[curr])
            dfs(graph,res,neig,l);
        l.remove(l.size()-1);
    }
}
