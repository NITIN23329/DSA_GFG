package backtracking;
// problem link ; https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?track=SPC-Graph&batchId=154

import java.util.ArrayList;
import java.util.Scanner;

public class NoOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }

            System.out.println(findIslandsGraph(list, N, M));
        }
    }
    //use back tracking
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {

        int ans = 0;
        boolean[][] isVisited = new boolean[N][M];
        for(int i = 0;i<N;i++)
            for(int j = 0;j<M;j++)
                if(!isVisited[i][j] && A.get(i).get(j)==1){
                    helper(A,  N,  M , i , j , isVisited);
                    ans++;
                }

        return ans;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> list, int N, int M , int i , int j , boolean[][] isVisited){
        if(isVisited[i][j])return;
        if(i>=N || j>=M)return;
        isVisited[i][j] = true;
        if(i+1<N && !isVisited[i+1][j] && list.get(i+1).get(j)==1)
            helper(list ,N ,M ,i+1 , j ,isVisited);
         if(i+1<N && j+1<M && !isVisited[i+1][j+1] && list.get(i+1).get(j+1)==1)
            helper(list , N ,M ,i+1 , j+1 , isVisited);
         if(j+1<M && !isVisited[i][j+1] && list.get(i).get(j+1)==1)
            helper(list , N , M  , i ,j+1 , isVisited);
         if(i+1<N && j-1>=0 && !isVisited[i+1][j-1] && list.get(i+1).get(j-1)==1)
             helper(list,N ,M ,i+1 ,j-1 ,isVisited);
        if( j-1>=0 && !isVisited[i][j-1] && list.get(i).get(j-1)==1)
            helper(list,N ,M ,i ,j-1 ,isVisited);
        if(i-1>=0  && j-1>=0 && !isVisited[i-1][j-1] && list.get(i-1).get(j-1)==1)
            helper(list , N ,M ,i-1 , j-1 , isVisited);
        if(i-1>=0  && !isVisited[i-1][j] && list.get(i-1).get(j)==1)
            helper(list , N ,M ,i-1 , j, isVisited);
        if(i-1>=0  && j+1<M && !isVisited[i-1][j+1] && list.get(i-1).get(j+1)==1)
            helper(list , N ,M ,i-1 , j+1 , isVisited);
    }
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

/*
1
4 7
1 1 1 1 0 0 1 1 0 1 0 1 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 1
ans 2
1
4 8
0 1 0 1 1 0 1 0 0 1 0 0 1 1 1 1 0 0 1 1 1 1 1 0 0 1 1 1 0 0 0 0
ans 1
 */