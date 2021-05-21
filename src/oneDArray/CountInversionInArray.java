package oneDArray;
/*
*****************************************IMPORTANT****************************************
* problem link : https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
* problem link : https://leetcode.com/problems/global-and-local-inversions/
* time complexity : O(nlogn), space complexity : o(n)
* approach :
*   --> inversions are counted in merge() function cuz in this function comparison of left and right arrays are done.
*   --> So we have 2 sorted arrays left and right and we need to count inversions in current array.
*   --> Note: Right array comes immediately after left array.
*   --> Suppose for some mid+1<=j<=r and l<=i<=mid, right[j]<left[i],
*       --> then all elements after i and including i in left array forms inversion with element right[j].
*   --> Count all these inversions during merge process and return it to mergeSort().
*   --> Well this count is only from sorting current array, we also add inversions done to sort left and right array and return it.
 */
public class CountInversionInArray {
    static long inversionCount(long arr[], long N){
        return mergeSort(arr,0,arr.length-1);
    }
    private static long mergeSort(long[] arr,int l,int r){
        if(l==r)return 0 ;  // no inversion if only 1 element
        int mid = (r-l)/2 + l;
        return mergeSort(arr,l,mid) + mergeSort(arr,mid+1,r) +
                merge(arr,l,mid,r);
    }
    private static long merge(long[] arr,int l,int mid,int r){
        long inversions = 0;
        long[] temp = new long[r-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j])temp[k++] = arr[i++];
            else {
                inversions += (mid-i+1);
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid)temp[k++] = arr[i++];
        while(j<=r)temp[k++] = arr[j++];
        for(int ind=l;ind<=r;ind++)arr[ind] = temp[ind-l];
        return inversions;
    }
}
