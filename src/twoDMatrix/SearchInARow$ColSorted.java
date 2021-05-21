package twoDMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInARow$ColSorted {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-->0){
            int n =sc.nextInt();
            int m =sc.nextInt();
            int[][] arr = new int[n][m];
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    arr[i][j] = sc.nextInt();
                int x =sc.nextInt();
            System.out.println(Arrays.toString(search(n,m,arr,x)));
            ser(n,m,arr,x);
        }
    }
    static int[] search(int n1, int m1, int arr[][], int x)
    {
        int col = m1-1;
        while(col>0 && arr[0][col]>x)col--;
        for( int i=0;i<n1;i++)
            if(arr[i][col]==x)return new int[]{i,col};
        return new int[]{-1};
    }
    static void ser(int n1, int m1, int arr[][], int x){
        int col = 0; int row = n1-1;
        while(row>=0 && col<m1){
            if(arr[row][col]==x){
                System.out.println(row+" "+col);return;
            }
            else if(arr[row][col]<x)col++;
            else row--;
        }
        System.out.println(-1);
    }
}
