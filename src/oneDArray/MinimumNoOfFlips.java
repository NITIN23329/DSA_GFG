package oneDArray;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumNoOfFlips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n  = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            printFlips(arr,n);
        }
    }

    private static void printFlips(int[] arr, int n) {
        // another approach is that if array starts with 1 then flip 0s
        // and if it start with 0 flip 1s
        // reason diff btw no of 1 gps and 0 gps is <=1
        // if array start and end with same gps then diff is 1 else 0
        //this approach is better then below one
        ArrayList<String> zeroToOne = new ArrayList<>();
        ArrayList<String> oneToZero = new ArrayList<>();
        int start = 0;
        for(int i=0;i<n-1;i++){
            if( arr[i]==0 && arr[i+1]==1)
                zeroToOne.add("("+start+" "+i+")");
            else if(arr[i]==1 && arr[i+1]==0)
                start = i+1;
        }
        if(arr[n-1]==0)zeroToOne.add("("+(n-1)+" "+(n-1)+")");
        start =0;
        for(int i=0;i<n-1;i++){
            if( arr[i]==1 && arr[i+1]==0)
                oneToZero.add("("+start+" "+i+")");
            else if(arr[i]==0 && arr[i+1]==1)
                start = i+1;
        }
        if(arr[n-1]==1)oneToZero.add("("+(n-1)+" "+(n-1)+")");
        if(oneToZero.size()>=zeroToOne.size())
            System.out.println(zeroToOne);
        else System.out.println(oneToZero);


    }
}
