package bitMagic;

/**
 * **************************************IMPORTANT******************************************
 */
// problem link : https://practice.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1
public class TwoNumbersWithOddOccurence {
    // time complexity : O(n),space complexity :O(1)
    /*
        Approach : Using bit manipulation
        Step 1:
        --> Find xor of all elements in given array.
        --> Result will be xor of 2 odd occuring element.
        Step 2:
        --> Then find the rightmost set bit in them.(letn say xth bit from right)
        --> The rightmost set bit tells us that xth bit is different
             in both odd occuring element thats why xor of that bit is 1.
        Step 3:
        --> Then we can divide whole array into 2 groups,
                whose xth bit is set and whose xth bit is not set.
        --> Each of these 2 groups will have only 1 odd occuring element in them.
    */
    public int[] twoOddNum(int arr[], int n){
        // step 1
        int xor = 0;
        for(var ele : arr)xor ^= ele;
        //step2
        int setBit = 0;
        while(xor>0){
            if((xor&1)==1)break;
            setBit++;
            xor>>=1;
        }
        //step3
        int xorSet = 0;
        int xorNotSet = 0;
        for(var ele : arr)
            if((ele & (1<<setBit)) != 0 )xorSet ^=ele;
            else xorNotSet ^= ele;
        return new int[]{Math.max(xorSet,xorNotSet),Math.min(xorSet,xorNotSet)};
    }
}
