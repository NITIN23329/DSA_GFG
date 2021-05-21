package bitMagic;
/********************************IMPORTANT*******************************************
 *article link : https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
  */
/*
    Approach:
        --> Step 1: find xor of a missing element and repeating element.
            To do this first take xor of array and then take a xor from value 1 to n.
        --> Step2 : then bit the rightmost set bit in the calculated xor let say x.
        --> Step3 : then divide all elements of array into groups whose xth bit is set and whose xth bit is not set.
        --> Step 4: Then also divide numbers from 1 to n into 2 groups whose xth bit is set and whose xth bit is not set.
        --> Step 5: Taking xor of corresponding groups will give us a repeating and missing element.
 */
public class FindMissingAndRepeating {
    int[] findTwoElement(int arr[], int n) {
        // step 1
        int xor = 0;
        for(var ele : arr) xor ^= ele;
        for(int i=1;i<=n;i++) xor ^= i;
        int setBit = 0;
        // step 2
        while(xor>0){
            if((xor & 1) == 1)break;
            setBit++;
            xor>>=1;
        }
        // step 3
        int set = 0;
        int notSet = 0;
        for(var ele : arr)
            if((ele & (1<<setBit)) == 0)notSet ^=ele;
            else set ^= ele;
        // step 4
        for(int i=1;i<=n;i++)
            if((i & (1<<setBit))==0)notSet^=i;
            else set ^=i;
        // step 5
        int repeating = notSet;
        int missing = set;
        for(var ele : arr)if(ele == missing ){
            int temp = missing;
            missing = repeating;
            repeating = temp;
            break;
        }
        return new int[]{repeating,missing};

    }
}
