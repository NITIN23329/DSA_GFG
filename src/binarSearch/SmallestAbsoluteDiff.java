package binarSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// problem link : https://practice.geeksforgeeks.org/problems/smallest-absolute-difference/0
// solution link : https://www.youtube.com/watch?v=HiSvEhLIaTI
// solution link : https://leetcode.com/articles/find-k-th-smallest-pair-distance/
public class SmallestAbsoluteDiff {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase -- >0){
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.valueOf(str[i]);
            int k = Integer.parseInt(br.readLine());
            System.out.println(NaiveApproach(arr,k));
        }
    }

    public static int NaiveApproach(int[] arr, int k) {
        // time complexity O(n^2)
        int max = 0;
        int n =arr.length;
        for(int ele : arr)max = Math.max(ele,max);
        int[] temp = new int[max+1];
        for(int i = 0;i<n;i++)
            for(int j=i+1;j<n;j++)
                temp[Math.abs(arr[j]-arr[i])]+=1;
        //System.out.print(Arrays.toString(temp));
        for(int i=0;i<max+1;i++){
            k-=temp[i];
            if(k<=0)return i;


        }
        return -1;
    }
    // O(nlogn)
    public long EfficinetApproach(int arr[], int n, int k)
    {
        Arrays.sort(arr);
        int l = 0;
        int r = arr[n-1];
        int ans = -1;
        while(l<=r){
            int mid = l +(r-l)/2;
            long count = findCount(arr,mid);
            if(count >= k){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }
    private long findCount(int[] arr, int diff){
        int n =arr.length;
        int ans = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            while(j<n && arr[j] - arr[i] <= diff)j++;
            ans += j-i-1;
        }
        return ans;
    }
    
}
