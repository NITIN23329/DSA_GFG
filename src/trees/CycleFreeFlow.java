/*
    created by: nitin23329
    on Date: 27/06/21
*/
package trees;
// problem link : https://codeforces.com/gym/102694/problem/D
// Topic : LCA using Binary Lifting
import java.util.ArrayList;
import java.util.Scanner;

public class CycleFreeFlow {
    static ArrayList<int[]>[] weightedTree;
    static int[][] binaryLift;
    // just like the binaryLift[node][i] stores the 2^th ancestor of the node ,
    // the minWeight[node][i] stores the the min edge weight from node to 2^th ancestor.
    static int[][] minWeight;
    static int[] level;
    static int maxPower = 20;
    static int inf_int = (int)2e9;
    private static void dfs(int curr,int parent,int depth,int cost){
        binaryLift[curr][0] = parent;
        minWeight[curr][0] = cost;  // immediate parent to child node has the cost of parent to child edge.
        level[curr] = depth;
        for(int [] neig : weightedTree[curr]){
            if(neig[0]!=parent)
                dfs(neig[0],curr,depth+1,neig[1]);
        }
    }
    private static void setBinaryLift(int n){
        for(int power=1;power<maxPower;power++){
            for(int node = 1;node<=n;node++){
                int x = binaryLift[node][power-1];
                if(x ==-1)continue;
                int  y = binaryLift[x][power-1];
                if(y==-1)continue;
                int minWeg1 = minWeight[node][power-1];
                int minWeg2 = minWeight[x][power-1];
                binaryLift[node][power] = y;
                // just like we calculate the (2^ith) ancestor using the (2^i-1 th) ancestor,
                // we can find the min edge by taking the min edge from node to (2^i-1 th) ancestor
                // and from (2^i-1 th) ancestor to (2^ith) ancestor.
                minWeight[node][power] = min2(minWeg1,minWeg2);
            }
        }
    }
    static void preProcess(int n){
        binaryLift = new int[n+1][maxPower];
        minWeight = new int[n+1][maxPower];
        for(int i=0;i<=n;i++)
            for(int power=0;power<maxPower;power++){
                binaryLift[i][power] =-1;
                minWeight[i][power] = inf_int;
            }
        dfs(1,-1,0,-1);
        setBinaryLift(n);
    }
    private static int[] liftUp(int x,int k){
        int node = x;
        int cost = inf_int;
        for(int power=0;power<maxPower;power++)
            if(((1<<power) & k) >0){
                // the minimum edge we get when going up by k nodes
                cost = min2(cost,minWeight[node][power]);
                node = binaryLift[node][power];
            }
        return new int[]{node,cost};
    }
    private static int minWeightInPath(int  x,int y){
        int cost1 = inf_int;
        int cost2 = inf_int;
        if(level[x]>level[y]){
            int[] push =  liftUp(x,level[x] - level[y]);
            x = push[0];
            cost1 = push[1];
        }
        else if(level[y]>level[x]){
            int[] push = liftUp(y,level[y] - level[x]);
            y = push[0];
            cost2 = push[1];
        }
        if(x==y)return min2(cost1,cost2);
        for(int power=maxPower-1;power>=0;power--){
            if(binaryLift[x][power] != binaryLift[y][power]){
                cost1 = min2(cost1,minWeight[x][power]);
                x = binaryLift[x][power];
                cost2 = min2(cost2,minWeight[y][power]);
                y = binaryLift[y][power];
            }
        }
        cost1 = min2(cost1,minWeight[x][0]);
        cost2 = min2(cost2,minWeight[y][0]);
        return min2(cost1,cost2);

    }
    private static void solve(int test) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        weightedTree = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            weightedTree[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            weightedTree[x].add(new int[]{y,z});
            weightedTree[y].add(new int[]{x,z});
        }
        level = new int[n+1];
        preProcess(n);
        int q = sc.nextInt();
        while (q-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(minWeightInPath(x,y));
        }
    }
    public static int min2(int a,int b){
        return Math.min(a,b);
    }
}
