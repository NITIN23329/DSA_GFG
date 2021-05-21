package oneDArray;
////https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
import java.util.*;
//approach use sliding window techinque.
// works only when all elemenst>0
public class SubArrayWithGivenSum$OnlyPositiveElements$ {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int testCase =sc.nextInt();
        while (testCase-->0) {
            int n=  sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            int currSum = 0;
            int left = 0;
            boolean isFound = false;
            for(int i=0;i<n;i++){
                    currSum+=arr[i];
                 if(currSum>k){
                    while (currSum>k)
                        currSum-=arr[left++];
                }
                if(currSum==k) {
                    System.out.print((left + 1) + " " + (i+1)+" , ");
                    isFound = true;
                }

            }
            if(!isFound) System.out.print(-1);
            System.out.println();
           
        }
    }



}
