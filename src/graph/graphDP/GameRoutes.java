/*
    created by: nitin23329
    on Date: 02/07/21
*/
package graph.graphDP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**     problem link : https://cses.fi/problemset/task/1202
 *      Approach : graph DP , time complexity O(n)
 *          --> We need to count the number of paths from node 1 to node n in a DAG.
 *          --> If order to find the # of path to reach node x, we can sum
 *              the # of path to reach it's parent to find the number of path to reach the node x
 *          --> if node 2 and 3 have an edge from them to node 4,
 *              then the # of paths to reach 4 = the # of paths to reach 2 + the # of paths to reach 3
 *          --> So it means we need to traverse all paths to parents of node before reaching the node itself.
 *          --> Hence we travers nodes in the topological sorting order.
 */
public class GameRoutes {
    static ArrayList<Integer>[] dag;
    static int[] inDegree;
    static long[] wayToReach;
    static int mod = (int)1e9+7;
    private static void graphDP(int n){
        Deque<Integer> q = new ArrayDeque<>();
        wayToReach[1] = 1;  // we start the game from 1
        for(int i=1;i<=n;i++)
            if(inDegree[i]==0)q.add(i);
        while (!q.isEmpty()){
            int curr =  q.poll();
            for(int neig: dag[curr]){
                wayToReach[neig] += wayToReach[curr];
                wayToReach[neig] %=mod;
                if(--inDegree[neig]==0)
                    q.add(neig);
            }
        }
        System.out.println(wayToReach[n]);
    }
    private static void solve()  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dag = new ArrayList[n+1];
        inDegree = new int[n+1];
        wayToReach = new long[n+1];
        for(int i=1;i<=n;i++)dag[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            inDegree[y]++;
            dag[x].add(y);
        }
        graphDP(n);
    }
}
