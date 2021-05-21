package twoDMatrix;

import java.util.Scanner;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase -->0){
            int row =sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row][col];
            for(int i = 0;i<row;i++)
                for(int j=0;j<col;j++)
                    arr[i][j] = sc.nextInt();
            printBoundary(arr);
        }
    }
    public static void printBoundary(int[][] arr){
            for(int j = 0;j<arr[0].length;j++)
                System.out.print(arr[0][j]+" ");
            for(int i = 1 ;i<arr.length-1;i++)
                System.out.print(arr[i][arr[i].length-1]+" ");
            if(arr.length>1)
                for(int j = arr[0].length-1 ;j>=0 ; j--)
                    System.out.print(arr[arr.length-1][j]+" ");
            if(arr[0].length>1)
                for(int i = arr.length-2;i>0;i--)
                    System.out.print(arr[i][0]+" ");
            System.out.println();

    }
}
