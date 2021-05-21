package stack;

import java.util.Arrays;
import java.util.Stack;

//problem link : https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1/?track=SPC-Stack&batchId=154

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {15 ,13, 12 ,14 ,16 ,8 ,6, 4 ,10 ,30};
        System.out.println(Arrays.toString(calculateSpanEfficient(arr,arr.length)));
    }
    public static int[] calculateSpanNaive(int prices[], int n)
    {
        //time complexity O(n^2)
        // space complexity O(1)
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j = i;j>=0;j--){
                if(prices[i]<prices[j])break;
                count++;

            }
            temp[i]=count;
        }
        return temp;
    }
    public static int[] calculateSpanEfficient(int arr[], int n){
        // time complexity O(2n)
        // space complexity O(1)
        Stack<Integer> st = new Stack<>();
        int[] temp = new int[n];
        temp[0]=1;
        st.push(0);
        for(int i =1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty())temp[i] = i+1;
            else
                temp[i] = i-st.peek();
            st.push(i);
        }
        return temp;
    }
}
