package bitMagic;
//problem link :  https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1#
public class FindMissingNumber {
    /*
    Approach : There are all numbers present from 1 to n except one.
    So initally find xor of all elements from 1 to n. Then we do xor  with all elements of array .
     By doing this, we have all numbers twice except one and that will be out missing number.
     */
    int MissingNumber(int [] arr, int n) {
        int xor = 0;
        for(int i=1;i<=n;i++)xor ^= i;
        for(int ele : arr)xor ^= ele;
        return xor;
    }

}
