package oneDArray;
//problem link ;https://practice.geeksforgeeks.org/problems/check-if-array-is-sorted-and-rotated-clockwise-1587115620/1/?track=DSASP-Arrays&batchId=154
class SortedRotated{
    // like if the array is sorted ascending and rotated eg 3 4 5 1 2 then arr[0]>arr[n-1].
    // if array is descending and rotated eg 2 1 5 4 3 . then arr[0]<arr[n-1].
    public static boolean checkRotatedAndSorted(int arr[], int num){

        if(arr[0]>=arr[num-1])
            return checkAsc(arr,num);
        return checkDes(arr,num);
    }
    private static boolean checkAsc(int[] arr , int n){
        int i=0;
        while(i<n-1 && arr[i]<=arr[i+1])
            i++;
        i++;
        if(i==n)return false;
        while(i<n-1){
            if(arr[i]>arr[i+1])return false;
            i++;
        }
        return true;
    }
    private static boolean checkDes(int[] arr,int n){
        int i = 0;
        while(i<n-1 && arr[i]>=arr[i+1])
            i++;
        i++;
        if(i==n)return false;
        while(i<n-1){
            if(arr[i]<arr[i+1])return false;
            i++;
        }
        return true;
    }

}
