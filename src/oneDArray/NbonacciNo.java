package oneDArray;


import java.util.Arrays;
import java.util.Scanner;

public class NbonacciNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0;i<n-1;i++)
            arr[i] = 0;
        arr[n-1]=1;
        int sum = 1;
        for(int i=n;i<m;i++){
            arr[i]=sum;
            sum+=arr[i]-arr[i-n];
        }
        System.out.println(Arrays.toString(arr));
    }

}
