package backtracking;
/**
 * ***********************************IMPORTANT***********************************************
 * problem link : https://practice.geeksforgeeks.org/problems/n-queen-problem/0
 * similar problem : https://cses.fi/problemset/task/1624/
 */

import java.util.*;
public class NQueenProblem {
    /* time complexity : idk
      Approach : using backtracking and some memoization
        --> AS we need to place 8 queens, we need to put a queen in evey row and every column.
        --> Rule a queen can go in a row or column or in both diagonal.
        --> We can check if there is a queen previously placed at column of left diagonal or right diagonal in O(1) time.
        --> This will reduce time complexity  drastically
        --> for left Diagonals row + col = constant for all cells of a particular diagonal
        --> for right Diagonals row - col = constant for all cells of a particular diagonal

     */
    static boolean[] cols,leftDiagonal,rightDiagonal;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        cols = new boolean[n];
        leftDiagonal = new boolean[2*n];
        rightDiagonal = new boolean[2*n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++)temp.add(0);
        backtrack(ans,n,0,temp);
        Collections.sort(ans,new Comparator<>(){
            @Override
            public int compare(ArrayList<Integer>a,ArrayList<Integer> b){
                for(int i=0;i<a.size();i++)
                    if(a.get(i)!=b.get(i))
                        return a.get(i)-b.get(i);
                return 0;
            }
        });
        return ans;
    }
    private static void backtrack(ArrayList<ArrayList<Integer>> ans,int n,int row,ArrayList<Integer> comb){
        if(row==n){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int col = 0;col<n;col++){
            if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
                continue;
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
            comb.set(col,row+1);
            backtrack(ans,n,row+1,comb);
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
        }
    }

}
