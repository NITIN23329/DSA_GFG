package binarSearch;
// peak is always the maximum element present in given array
// basic idea is the given array is a sequence of ascending and descending order
// if your mid lies in ascending then peak element lise to right of it ,
// if mid lies in descending them peak lies left to it.
// approach :https://leetcode.com/articles/find-peak-element/
// problem : https://practice.geeksforgeeks.org/problems/peak-element/1
public class findPeak {
    public static void main(String[] args) {
        int[] arr = new int[]{5,10,20,15,7};
        System.out.println(findPeak(arr,arr.length));
    }
    public static int findPeak(int[] arr,int n)
    {
        if(n==1)return 0;

        int start = 0;
        int end =arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(mid==0 && arr[mid]>=arr[mid+1])return mid;
            if(mid==arr.length-1 && arr[mid]>=arr[mid-1]) return mid;
            if(arr[mid]>=arr[mid+1] && arr[mid]>=arr[mid-1])return mid;
            if(arr[mid]>=arr[mid+1])
                end = mid-1;
            else start=mid+1;
        }
        return -1;

    }
}
