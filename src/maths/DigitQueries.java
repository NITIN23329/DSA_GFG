package maths;
// problem link : https://cses.fi/problemset/task/2431/
// solution link : https://www.youtube.com/watch?v=QAcH8qD9Pe0
public class DigitQueries {
    /*  --> character occupied by number with 1 digit = 9(1 ....9)
        --> character occupied by number with 2 digit = 180(10.....99)
        -->character occupied by number with 3 digit = 2700(100.....999)
        --> character occupied by number with d digit = 9 * (d * 10^(d-1))

        --> To find the character at given index, first we need the actual number to which this index belong.
        --> To find the actual number, we need the # of digit of it first.
        --> After finding the digit count of desired number, subtract the characters occupied by all smaller numbers
        --> then find the character at index-1.
     */
    private static char findCharacter(long index) {
        int digits = 0;             // this represents the # digits present in the number which belong to the given index
        long indexTakenByLowerDigits = 0;   // this will tell the character occupied by all smaller digit numbers
        while (true){
            digits++;
            long indexTakenByNextDigits = indexTakenByLowerDigits + 9 * (digits * (long)Math.pow(10,digits-1));
            if(indexTakenByNextDigits>=index)break;
            indexTakenByLowerDigits = indexTakenByNextDigits;

        }
        index -= indexTakenByLowerDigits;   // subtract the character occupied by all smaller digit numbers
        long numberOfSmallerNumberHavingSameDigits = (index-1)/digits;  // this gives the count of numbers < the desired number we are finding but having same digit count
        long lowest = (long)Math.pow(10,digits-1);  // is the smallest number whit given digit count
        index -= digits*numberOfSmallerNumberHavingSameDigits; // subtract the characters occupied by numbers < desired number but having same digit count
        long actualNumber = lowest + numberOfSmallerNumberHavingSameDigits;    // this is our desired number
        return String.valueOf(actualNumber).charAt((int)index-1);
    }
}
