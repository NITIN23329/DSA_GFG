package stack;
//similar problem : https://practice.geeksforgeeks.org/pro blems/next-larger-element-1587115620/1/?track=SPC-Stack&batchId=154

import java.util.Arrays;
import java.util.Stack;

public class ClosestPreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {15 ,13, 12 ,14 ,16 ,8 ,6, 4 ,10 ,30};
        System.out.println(Arrays.toString(previousGreaterElement(arr,arr.length)));

    }
    public static int[] previousGreaterElement(int arr[], int n){
        // time complexity O(2n)
        // space complexity O(1)
        Stack<Integer> st = new Stack<>();
        int[] temp = new int[n];
        temp[0]=-1;
        st.push(0);
        for(int i =1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty())temp[i] = -1;
            else
                temp[i] = arr[st.peek()];
            st.push(i);
        }
        return temp;
    }
}
