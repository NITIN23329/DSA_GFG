package graph.traversal;

import java.util.ArrayList;

/**
 * ***********************************IMPORTANT***************************
 * problem link : https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?track=SPC-Graph&batchId=154
 * // similar problem : https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/?track=SPC-Graph&batchId=154
 * yet similar problem : https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1/?track=SPC-Graph&batchId=154
 */
public class NoOfIslands {
    //time complexity O(nm)
    // important thing is to form a graph with given matrix
    //then do simply dfs and find disconnected components
    static int findIslandsGraph(ArrayList<ArrayList<Integer>> A, int N, int M) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N*M);
        for(int i = 0;i<N*M;i++)list.add(new ArrayList<>());
        int c = 0;
        for(int i =0 ; i<N;i++)
            for(int j = 0;j<M;j++){
                if(A.get(i).get(j)==1){
                    list.get(c).add(c);
                    if(i+1<N && A.get(i+1).get(j)==1)
                        list.get(c).add(c+M);
                    if(i+1<N && j+1 < M && A.get(i+1).get(j+1)==1)
                        list.get(c).add(c+M+1);
                    if(j+1<M && A.get(i).get(j+1)==1)
                        list.get(c).add(c+1);
                    if(i-1>=0 && j+1<M && A.get(i-1).get(j+1) ==1)
                        list.get(c).add(c-M+1);
                    if(i+1<N && j-1>=0 && A.get(i+1).get(j-1)==1)
                        list.get(c).add(c+M-1);
                    if(j-1>=0  && A.get(i).get(j-1)==1)
                        list.get(c).add(c-1);
                    if(i-1>=0 && A.get(i-1).get(j)==1)
                        list.get(c).add(c-M);
                    if(i-1>=0 && j-1>=0 && A.get(i-1).get(j-1)==1)
                        list.get(c).add(c-M-1);

                }
                c++;
            }

        for(ArrayList<Integer> ele : list) System.out.println(ele);
        boolean[] isVisited = new boolean[N*M];
        int ans = 0;
        for(int i = 0;i<N*M ; i++)
            if(!isVisited[i] && !list.get(i).isEmpty()){
                dfs(list , i , isVisited);
                ans++;
            }
        return ans;
    }
    private static void  dfs(ArrayList<ArrayList<Integer>> list , int curr ,boolean[] isVisited ){
        isVisited[curr] = true;
        for(int ele: list.get(curr))
            if(!isVisited[ele])
                dfs(list , ele , isVisited);
    }
}
