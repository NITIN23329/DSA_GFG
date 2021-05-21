package recursion;

import java.util.Scanner;

public class RecursiveSequence {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        long[] arr = new long[10];
        int c = 2;
        arr[0]=1;
        for(int i=1;i<10;i++){
            long ans = 1L;
            for(int j=0;j<i+1;j++){
                ans*=c;
                c++;
            }
            arr[i] = arr[i-1]+ans;
        }
        while(testCase-->0){
            int n = sc.nextInt();
            System.out.println(arr[n-1]);
        }
    }
}
