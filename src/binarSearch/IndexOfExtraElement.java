package binarSearch;
//probem link :https://practice.geeksforgeeks.org/problems/index-of-an-extra-element/1
public class IndexOfExtraElement {
    public int findExtra(int a[], int b[], int n) {
        int left = 0;
        int right = n-2;
        if(a[0]!=b[0])return 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(a[mid-1]==b[mid-1] &&a[mid]!=b[mid])return mid;
            if(a[mid]!=b[mid])right=mid-1;
            else left = mid+1;

        }
        return n-1;
    }
}
