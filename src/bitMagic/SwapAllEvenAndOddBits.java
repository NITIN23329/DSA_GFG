package bitMagic;
// problem link : https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1/?track=DSASP-BitMagic&batchId=154#
public class SwapAllEvenAndOddBits {
    // time and space complexity : O(1)
    /*
        --> We need to swap odd index bit with even index.
        --> Alternatively we can can we need to shift even index bits to left by 1 step(left shift)
        --> And we need to shift odd index bits to right by 1 step(right shift)
        --> But how to combine both answers to get swapped number.
        --> We take a number x which has even bit set to 1 and odd bits set to 0,
            then if we take (n<<1) & x, then we will get answer for even bits.
        --> We take a number y which has odd bit set to 1 and even bits set to 0,
            then if we take (n>>1) & y, then we will get answer for odd bits .
        --> Then we combine previous 2 steps to get swapped number
     */
    public static int swapBits(int n){
        int x = 0xAAAAAAAA;  // it will have all even index bit set
        int y = 0x55555555;  // it will have all odd index bit set.
        return ((n<<1) & x) | ((n>>1) & y);
    }
}
