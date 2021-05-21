package graph.stronglyConnectedComponent;
//problem link : https://practice.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1/?track=DSASP-Graph&batchId=154
import java.util.*;

public class TarjansAlgoSCC {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int nov = sc.nextInt();
        int edg = sc.nextInt();
        for (int i = 0; i < nov; i++)
            list.add(i, new ArrayList<>());
        for (int i = 1; i <= edg; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
        }
        tarjans(nov,list);


    }
    /**
     * solution link : https://www.youtube.com/watch?v=wUgWX0nc4NY
     *
     * time complexity o(v+e)...requires 1 dfs traversal only.
     * Disclaimer : don't check for low value of neighbour are equal, it only works when
     * there is no cross edge, it fails when there are cross edges present or may leads diff result if the dfs order changes.
     * (cross edge : when a node points to a node which is not ancestor of it).
     *               0
     *             /  /\
     *            /    \
     *           \/     \
     *           1----->2<-----3
     *approach :
     * make use of lowValue and visit time arrays.
     * also make a stack that contains the nodes which are currently visited while doing dfs.
     * while doing dfs , add node u to stack and when all neighbours v of it are visited ,
     * update the low of u with all v only if v is present in stack.(this will look after cross edge)
     * then if the visit time of u is = low value of u then it means ,it is a start of
     * SCC(strongly connected components), so pop all elements from stack until we find u.
     *do this for all nodes which are not visited yet.
     *
     */
    private static Deque<Integer> currStack;
    private static Set<Integer> currSet;
    private static int timer;
    private static int[] visitTime;
    private static int[] lowTime;
    public static void tarjans(int v, ArrayList<ArrayList<Integer>> adj) {
        currStack = new ArrayDeque<>();
        currSet = new HashSet<>();
        timer = 0;
        visitTime = new int[v];
        lowTime = new int[v];
        ArrayList<ArrayList<Integer>> scc = new ArrayList<>();
        for(int i=0;i<v;i++)
            if(visitTime[i]==0)
                tarjansAlgo(adj,i,scc);
        for(ArrayList<Integer> ele : scc)System.out.println(ele);
    }
    private static void tarjansAlgo(ArrayList<ArrayList<Integer>> adj,int curr,ArrayList<ArrayList<Integer>> scc){
        timer++;
        visitTime[curr] = timer;
        lowTime[curr] = timer;
        currStack.push(curr);
        currSet.add(curr);
        for(int child : adj.get(curr)){
            if(visitTime[child]==0)
                tarjansAlgo(adj,child,scc);
            if(currSet.contains(child))
                lowTime[curr] = Math.min(lowTime[curr],lowTime[child]);
        }
        if(visitTime[curr] == lowTime[curr]){
            ArrayList<Integer> currSCC = new ArrayList<>();
            while(currStack.peek()!=curr){
                int x = currStack.pop();
                currSet.remove(x);
                currSCC.add(x);
            }
            int x = currStack.pop();
            currSet.remove(x);
            currSCC.add(x);
            scc.add(currSCC);
        }
    }
}
/*
test case 1
7 12
0 1
1 0
2 1
2 0
2 3
3 2
4 1
6 4
4 3
5 3
4 5
5 6
ans :
1,0
3,2
6,5,4
test case 2
5 6
0 3
0 2
1 3
2 3
3 4
4 0
ans :
[2, 4, 3, 0]
[1]
test case 3 :
8 12
0 1
1 2
2 0
6 0
6 4
5 0
5 6
4 5
3 4
3 7
7 3
7 5
ans :
[2, 1, 0]
[6, 5, 4]
[7, 3]
 */