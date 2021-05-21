package binarSearch;

public class findMaxInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{7,8,9,1,2,3,4,5,6};
        System.out.println(findMax(arr));
    }
    public static int findMax(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[0]>arr[mid])end =mid-1;
            else if(arr[mid]>arr[0] && ((mid==arr.length-1)|| !(arr[mid+1]<arr[mid]) ))start = mid+1;
            else return mid;
        }
        return -1;
    }
}
