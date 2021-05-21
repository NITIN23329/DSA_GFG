package backtracking;
//problem link : https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1/?track=DSASP-Backtracking&batchId=154
import java.util.*;

public class MColoring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int V = scan.nextInt();
            int C = scan.nextInt();
            int E = scan.nextInt();

            List<Integer>[] G = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                G[u].add(v);
                G[v].add(u);
            }
            int[] color = new int[V];

            System.out.println(graphColoring(G, color, 0, C) ? 1 : 0);
        }
    }
    static Set<Integer> c ;
    public static boolean graphColoring(List<Integer>[] g, int[] color, int j, int m) {
        c = new HashSet<>();
        for(int i=1;i<=m;i++)c.add(i);
        for(int i=0;i<g.length;i++)
            if(color[i]==0){
                if(!dfs(g,i,color)){
                    System.out.println(Arrays.toString(color));
                    return false;
                }
            }
        System.out.println(Arrays.toString(color));
        return true;

    }
    private static boolean dfs(List<Integer>[] g , int curr,int[] color){
        Set<Integer> poss = new HashSet<>(c);
        for(int ele : g[curr])poss.remove(color[ele]);
        int c = 0;
        for(int neig:g[curr])if(color[neig]==0)c++;
        if(c==0){
            if(poss.isEmpty())return false;
            for(int ele : poss){
                color[curr] = ele;
                return true;
            }
        }
        for(int ele : poss){
            color[curr]=ele;
            for(int neig:g[curr]) {
                if (color[neig] == 0) {
                    boolean ans = dfs(g, neig, color);
                    if (ans) return true;
                    else break;
                }
            }
        }
        //color[curr] = 0;        //back track
        return false;
    }
}
/*
test case:
16
4
40
9 16 4 6 1 3 13 15 1 11 14 15 9 10 14 16 2 6 5 12 10 12 13 14 3 13 11 16 4 7 3 6 15 16 12 13 2 13 13 16 10 16 1 2 9 13 3 4 8 14 8 13 12 14 5 9 6 11 11 12 3 10 2 16 11 14 9 15 6 8 8 9 8 10 9 11 8 12 3 15
ans : 1
 */
//https://ide.geeksforgeeks.org/2rP1LyFB8Z