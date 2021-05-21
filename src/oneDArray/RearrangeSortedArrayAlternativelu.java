package oneDArray;
// store 2 numbers in one index using division and modulus
//
//find maximum element and take z = 10^maxdigits
// at even index  a[i]=a[i]+(max_curr%z)*z
// at odd index a[i]=a[i]+ (min_curr%z)*z
// finally divide each eleemnt by z
// utube link to approach :https://www.youtube.com/watch?v=KOglcclYgXI&feature=youtu.be
// link to question gfg ; https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0
//similar problem https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space/0

import java.util.Arrays;

public class RearrangeSortedArrayAlternativelu {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rearrange(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void rearrange(int arr[], int n){

        int x = String.valueOf(arr[n-1]).length();
        x = (int)Math.pow(10,x);
        for(int i=0;i<n;i++)arr[i] = arr[i]*x;
        int left = 0;
        int right = n-1;
        int i = 0;
        while(left<=right){
            int max = arr[right]/x;
            int min = arr[left]/x;
            arr[i++] += max;
            if(i==n)break;
            arr[i++] += min;
            left++;
            right--;
        }
        i=0;
        for( i=0;i<n;i++)
            arr[i] = arr[i]%x;

    }
}
