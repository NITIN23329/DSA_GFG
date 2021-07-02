/*
    created by: nitin23329
    on Date: 02/07/21
*/
package graph.graphDP;

import java.io.IOException;
import java.util.*;
// problem link : https://cses.fi/problemset/task/1680
public class LongestFlightRoute {
    static ArrayList<Integer>[] dag;
    static int[] inDegree;
    static int[] longestPath;   // longestPath[i] = x means the node i is at distance of x edges from node 1
    static int[] backTrack;     // used to backtrack the longest path from n to 1
    private static void graphDP(int n){
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.fill(longestPath,-2*n);  // we don't want to find max path from a node !=1 to n
        longestPath[1] = 0; // take the path that starts at node 1 only.
        for(int i=1;i<=n;i++)
            if(inDegree[i]==0)q.add(i);
        while (!q.isEmpty()){
            int curr = q.poll();
            for(int neig : dag[curr]){
                if(longestPath[neig]< 1 + longestPath[curr]){
                    backTrack[neig] = curr;
                    longestPath[neig] = 1 + longestPath[curr];
                }
                if(--inDegree[neig]==0)
                    q.add(neig);
            }
        }
        if(longestPath[n] < 0)System.out.println("IMPOSSIBLE");
        else {
            int curr = n;
            List<Integer> path = new ArrayList<>();
            path.add(curr);
            do{
                curr = backTrack[curr];
                path.add(curr);

            }while (curr!=1);
            Collections.reverse(path);
            System.out.println(path.size());
            for(int ele : path)System.out.print(ele+" ");
        }
    }
    @SuppressWarnings({"unchecked"})
    private static void solve(int test)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dag = new ArrayList[n+1];
        inDegree = new int[n+1];
        longestPath = new int[n+1];
        backTrack = new int[n+1];
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
