package twoDMatrix;
// problem link : https://practice.geeksforgeeks.org/problems/make-matrix-beautiful/0
public class makeMatrixBeautiful {
    public static void main(String[] args) {
        int[][] arr  = new int[][]{{0 ,1 ,0, 4 },{3, 3, 3 ,10} ,{1 ,8 ,5 ,5} ,{6, 0, 5, 5} };
        System.out.println(findMinOperation(arr.length,arr));
    }

    static int findMinOperation(int n, int arr[][])
    {
        int max  =0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++)sum+=arr[i][j];
            max = Math.max(max,sum);
        }
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++)sum+=arr[j][i];
            max = Math.max(max,sum);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++)sum+=arr[i][j];
            count+=max - sum;
        }
        return count;
    }
}
/*
5
2 2
1 2 3 4
2 5
1 2 3 4 5 6 7 8 9 10
5 2
1 2 3 4 5 6 7 8 9 10
2 3
1 2 3 4 5 6
3 2
1 2 3 4 5 6
4 5
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 */