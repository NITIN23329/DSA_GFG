package oneDArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumSubCircularArray {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase -- >0){
            int n =Integer.parseInt(br.readLine());;
            String str[] = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.valueOf(str[i]);
            System.out.println(findMaxSum(arr,n));
        }
    }
    public static int findMaxSum(int[] arr,int n){
        int res1 = subArray(arr,n);
        int res2 = circularArray(arr,n);

        return Math.max(res1,res2);
    }
    public static int circularArray(int[] arr,int n){
        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1;i<n;i++){
            int x = arr[i];
            x=Math.min(x+sum[i-1],x);
            sum[i] = x;
        }
        int min = 999999;
        for(int i =0;i<n;i++)min = Math.min(min,sum[i]);
        int total=arr[0];
        for(int i=1;i<n;i++)total+=arr[i];
        if(total-min==0)return -1;
        return total-min;

    }
    public static int subArray(int[] arr,int n){
        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1;i<n;i++){
            int x= arr[i];
            x=Math.max(x+sum[i-1],x);
            sum[i] = x;
        }
        int max = -99999;
        for(int i =0;i<n;i++)max = Math.max(max,sum[i]);
        return max;
    }
}
