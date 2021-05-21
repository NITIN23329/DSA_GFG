package binarSearch;

public class binarySearchOnInfiniteArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,12,13,14,15,16,18,19,29,39};
        System.out.println(infiniteArray(arr,16));
    }
    public static int infiniteArray(int[] arr,int ele){
        int upperBound =1;
        while (  arr[upperBound]<ele )upperBound*=2;       //we increment upper bound by power of 2
        // so final solution becomes O(logn+logn) = O(logn)
        if (arr[upperBound]==ele)return upperBound;
        return binarySearch(arr,upperBound/2,upperBound-1,ele);
    }
    public static int binarySearch(int[] arr , int start,int end,int ele){
        if(start>end)return -1;
        int mid = start +(end-start)/2;
        if(arr[mid]==ele)return mid;
        if(arr[mid]>ele)
            return binarySearch(arr,start,mid-1,ele);
        return binarySearch(arr,mid+1,end,ele);
    }
}
