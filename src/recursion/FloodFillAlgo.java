package recursion;

import java.util.Scanner;

public class FloodFillAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase= sc.nextInt();
        while (testCase-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for(int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    arr[i][j] = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int color=  sc.nextInt();
            traverse(arr,x,y,color);
            for(int i=0;i<n;i++) {
                for (int j = 0; j < m; j++)
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void traverse(int[][] arr, int x, int y, int color) {
        int origional = arr[x][y];
        arr[x][y]=color;
        if(x-1>=0 && arr[x-1][y]==origional)
            traverse(arr, x-1, y, color);
        if(x+1<arr.length && arr[x+1][y]==origional)
            traverse(arr, x+1, y, color);
        if(y-1>=0 && arr[x][y-1]==origional)
            traverse(arr, x, y-1, color);
        if(y+1<arr[0].length && arr[x][y+1]==origional)
            traverse(arr, x, y+1, color);

    }
}
