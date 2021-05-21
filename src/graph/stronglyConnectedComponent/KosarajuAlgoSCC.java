package graph.stronglyConnectedComponent;
//problem link ; https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1/?track=SPC-Graph&batchId=154
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KosarajuAlgoSCC {
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
        System.out.println(kosaRaju(list , nov));

    }

    /** solution link : https://www.youtube.com/watch?v=RpgcYiky7uw , https://practice.geeksforgeeks.org/tracks/DSASP-Graph/?batchId=154
     * time complexity O(v+e)
     *  1.) Do a DFS on the original graph, keeping track of the finish times
     *  of each vertex. This can be done  with a stack, when visiting all neighbour
     *  of a particular node finish  ,put that node  vertex on the stack.
     *  This way node with highest finishing time will be on top of the stack.
     *
     *  2.) Reverse the edge direction in original graph.
     *
     *  3.) Pop element from stack, do dfs for poped node
     *and keep marking the vertices visited. When DFS finishes,
     * all vertices visited will  form one Strongly Connected Component.
     * If any more vertex remain unvisited, this means there are more Strongly
     * Connected Component's, so pop vertices from top of the stack until a valid
     * unvisited node is found. This step is repeated until all nodes are visited.
     */
    static String str;
    public static ArrayList<String> kosaRaju(ArrayList<ArrayList<Integer>> adjList ,int noOfVertices){
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[noOfVertices];
        for(int i=0;i<noOfVertices;i++)
            if(!isVisited[i])
                dfs1(adjList , st , isVisited , i);
        ArrayList<ArrayList<Integer>>  reverse = new ArrayList<>(noOfVertices);
        for(int i = 0;i<noOfVertices;i++)reverse.add(new ArrayList<>());
        for(int i = 0;i<noOfVertices;i++)
            for(int ele : adjList.get(i))
                reverse.get(ele).add(i);
        isVisited = new boolean[noOfVertices];
        ArrayList<String> result = new ArrayList<>();
        while (!st.isEmpty()){
            int ele = st.pop();
            if(isVisited[ele])continue;
            str = "";
            dfs2(reverse  , isVisited , ele);
            str=str+ele;
            result.add(str);
        }
        return result;

    }
    private static void dfs1( ArrayList<ArrayList<Integer>> adjList  ,Stack<Integer> st , boolean[] isVisited , int curr){
        isVisited[curr] = true;
        for(int ele : adjList.get(curr))
            if(!isVisited[ele])dfs1(adjList , st , isVisited , ele);

        st.push(curr);
    }
    private static void dfs2(ArrayList<ArrayList<Integer>> reverse , boolean[] isVisited  , int curr){
        isVisited[curr] = true;
        for(int ele : reverse.get(curr) )
            if(!isVisited[ele]){
                str = str + ele+":";
                dfs2(reverse , isVisited , ele);
            }
    }
}
/*
11 13
0 1
1 2
2 0
1 3
3 4
4 5
5 3
5 6
6 7
7 8
8 9
9 10
9 6
ans : [2:1:0, 5:4:3, 9:8:7:6, 10]
5 6
0 1
0 2
2 1
2 3
3 4
4 2
ans : [0, 4:3:2, 1]
 */