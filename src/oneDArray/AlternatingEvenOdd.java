package oneDArray;

import java.util.Scanner;

public class
AlternatingEvenOdd {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-->0){
            int n =sc.nextInt();
            int[] array  = new int[n];
            for(int i=0;i<n;i++)array[i]=sc.nextInt();
            System.out.println(findSeq(array));
        }

    }
    public static int findSeq(int[] arr){
        int res=0;
        int max=0;
        for(int i = 0;i<arr.length-1;i++)
            if(Math.abs(arr[i+1]%2)!=Math.abs(arr[i]%2))
                max++;
            else{
                    res=Math.max(max,res);
                    max=0;
                }


        res = Math.max(max,res);
        return res+1;
    }
}
