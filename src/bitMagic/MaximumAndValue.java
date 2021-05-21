package bitMagic;
/**
 * problem link : https://www.geeksforgeeks.org/maximum-value-pair-array/
 * note : java gives TLE, use cpp
 **/
import java.util.Arrays;
/*
    Approach : using bit manipulation
    --> As we need to make maximum value, we need to make 1st bit from left to 1, then 2nd bit and so on.
    --> To make a bit at position x to 1 using and operation, we need at least 2 numbers having xth bit set.
        --> and all numbers having xth bit unset is discarded in further rounds.
    --> So we make a boolean array canTake , canTake[i]  =  true means we can take ith element in and operation.
    Step 1 :
    --> Then from 1st bit from left find at-lest 2 numbers having 1st bit set,
        -->if found, then discard all other numbers having that bit unset as our answer must have 1st bit set.
        --> Otherwise do nothing and goto 2nd bit and so on.
    Step 2 :
    --> Out of all true numbers take and of any of 2 numbers, if not possible to take 2 elements return 0.
 */
public class MaximumAndValue {
    public static long maxAND (int arr[], int n) {
        boolean[] canTake = new boolean[n];
        Arrays.fill(canTake,true);
        int max = 0;
        for(int ele:arr)max = Math.max(max,ele);
        int totalBits = (int)(Math.log(max)/Math.log(2) + 1);
        // step 1
        for(int bit = totalBits-1;bit>=0;bit--){
            int x = 1<<bit;
            int setCount = 0;
            for(int i=0;i<n;i++)
                if(canTake[i] && (x & arr[i] ) !=0)setCount++;
            if(setCount>=2){
                for(int i=0;i<n;i++)
                    if((x & arr[i] ) ==0) canTake[i] = false;
            }
        }
        // step 2
        int  ans = -1;
        for(int i=0;i<n;i++)
            if(canTake[i]){
                if(ans==-1)ans = arr[i];
                else return  ans & arr[i];
            }
        return 0;
    }
}
