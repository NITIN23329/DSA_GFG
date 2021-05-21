package bitMagic;
// problem link : https://practice.geeksforgeeks.org/problems/set-bits0143/1
// time complexity : O(log2(n))
public class CountSetBits {
    static int setBitsUsingLeftShift(int n) {
        int count = 0;
        int totalBits = (int)Math.floor(Math.log(n)/Math.log(2) + 1);
        for(int bit = 0;bit<totalBits;bit++)// for every bit in binary representation of n
            count +=((1<<bit) & n)==0?0:1;// check if ith bit from left is set or not
        return count;
    }
    static int setBitsUsingRightShift(int n) {
        int count = 0;
        while(n>0){ // while we have some bits to check
            count += (n&1); // check it last bit is set
            n>>=1;  // move all bits to right by 1 step
        }
        return count;
    }
}
