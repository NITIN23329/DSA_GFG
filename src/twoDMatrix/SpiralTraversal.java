package twoDMatrix;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        spirallyTraverse(arr[0].length,arr.length,arr);
    }

    static void spirallyTraverse(int m, int n, int arr[][])
    {
        int left = 0;int right = m-1;int upper = 0;
        int lower =n-1;
        while(true) {
            if (lower < upper && left > right) break;
            for (int i = left; i <= right; i++)
                System.out.print(arr[upper][i] + " ");
            for (int i = upper + 1; i <= lower; i++)
                System.out.print(arr[i][right] + " ");
            if(lower == upper)break;
            for (int i = right - 1; i >= left; i--)
                System.out.print(arr[lower][i] + " ");
            if(left==right)break;
            for (int i = lower - 1; i >= upper + 1; i--)
                System.out.print(arr[i][left] + " ");
            upper++;
            lower--;
            left++;
            right--;

        }
    }
}
