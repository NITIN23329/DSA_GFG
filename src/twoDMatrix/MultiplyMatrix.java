package twoDMatrix;

public class MultiplyMatrix {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1,2},{2,3},{3,4}};
        int[][] arr2 = new int[][]{{5,6,7},{8,9,10}};
        multiplyMatrix(arr1.length,arr1[0].length,arr2.length,arr2[0].length,arr1,arr2);
    }
    static void multiplyMatrix(int n1, int m1, int n2, int m2, int arr1[][], int arr2[][])
    {   if(m1!=n2)System.out.print(-1);
        else{
            int[][] arr = new int[n1][m2];
            for(int i=0;i<n1;i++){
                for(int j = 0;j<m2;j++){
                    int sum = 0;
                    for(int k=0;k<arr1[i].length;k++)sum+=arr1[i][k]*arr2[k][j];
                    arr[i][j] = sum;
                    System.out.print(arr[i][j]+" ");
                }
            }
        }

    }
}
