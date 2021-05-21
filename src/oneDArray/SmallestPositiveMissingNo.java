package oneDArray;
//problem link : https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1/?track=DSASP-Arrays&batchId=154
public class SmallestPositiveMissingNo {
    //things to keep in mind :
    //1) <=0 numbers dont contribute towards result so make then size+2;
    //2) while taking out number take abs of it cuz it is possible there is a previous  no.
    // which makes it -ve and then u might ignore that no cus x<0
    //3) arr[x]>0 cur there may be more than 1 same numbers
    static int missingNumber(int arr[], int n)
    {

        for(int i=0;i<n;i++)
            if(arr[i]<=0)arr[i]=n+2;    //making all numbers positive   and <=0 numbers irrelevent.
        for(int i=0;i<n;i++){
            int x = Math.abs(arr[i])-1; //abs cuz it might be updated to negative by other previous number
            if(x<n && x>=0 && arr[x]>0) //arr[x]>0 ensures this no is not visited
                arr[x]*=-1;
        }
        int res = n+1;
        for(int i=0;i<n;i++)
            if(arr[i]>=0){
                res = i+1;
                break;
            }
        //System.out.println(Arrays.toString(arr));
        return res;

    }
}
