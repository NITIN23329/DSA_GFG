package twoDMatrix;

import java.util.Scanner;

public class RotateAntiClockwise {
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
           rotateUsingExtraSpace(arr);
           rotateWithoutUsingExtraSpace(arr,arr.length);

        }
    }
    public static void rotateUsingExtraSpace(int[][] arr){
        // matrix can be any type
        int[][] temp = new int[arr[0].length][arr.length];
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++)
                temp[j][i] = arr[i][arr[i].length-j-1];
        }
        for(int[] ele : temp){
            for(int i : ele) System.out.print(i+"   ");
            System.out.println();
        }
    }
    static void rotateWithoutUsingExtraSpace(int arr[][], int n)
    {   // must be square matrix
        transPose(arr,n);

        for(int i=0;i<n/2;i++){
            for( int j = 0;j<n;j++)
                swap(arr,i,n-i-1,j);
        }
        for(int i = 0;i<n;i++)
            for(int j=0;j<n;j++) System.out.print(arr[i][j]+" ");
    }
    private static void transPose(int[][] arr , int n){
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)swap1(arr,i,j);
    }
    private static void swap(int[][] arr,int a,int b,int j){
        int temp = arr[a][j];
        arr[a][j] = arr[b][j];
        arr[b][j] = temp;
    }
    private static void swap1(int[][] arr,int i,int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
