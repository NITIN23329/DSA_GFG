package binarSearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,8,9,12};
        System.out.println(recusive(arr,0,arr.length-1,1));
        System.out.println(ierative(arr,8));
    }
    // for calculation of mid , do not use mid = (start+end)/2 because
    // there might be case when start becomes end and end is really large
    // So start + end leads to over flow; thats why use mid = start + (end-start)/2
    public static int recusive(int[] arr , int start,int end,int ele){
        if(start>end)return -1;
        int mid = start +(end-start)/2;
        if(arr[mid]==ele)return mid;
        if(arr[mid]>ele)
           return recusive(arr,start,mid-1,ele);
        return recusive(arr,mid+1,end,ele);
    }
    public static int ierative(int[] arr, int ele){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==ele)return mid;
            if(arr[mid]>ele)end=mid-1;
            else start=mid+1;
        }
        return -1;
    }
}
