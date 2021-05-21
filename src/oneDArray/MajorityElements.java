package oneDArray;
//problem link : https://practice.geeksforgeeks.org/problems/majority-element/0
//similar problem : https://leetcode.com/problems/majority-element-ii/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class temp{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase -- >0){
            int n =Integer.parseInt(br.readLine());;
            String str[] = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.valueOf(str[i]);
            System.out.println(findMajor(arr,n));
        }
    }
    //approach: moore's voting algorithm
    // there is only 1 majority element possible.(frequency>n/2)
    // each element of array either contribute to majority (same elements)or try to cancel majority(diff elements)
    //assume first element is majority.
    // then for next element , if it is diff reduce the count else increase the count
    //if the count reduces to 0 then this means assumed majority element can not be majority.
    // reset the assumed majority element to current element.
    private static int findMajor(int[] arr, int n) {

        int majority = arr[0];
        int count = 1;
        for(int i=1;i<n;i++){
            if(arr[i]==majority)
                count++;
            else {
                count--;
                if (count == 0) {
                    majority = arr[i];
                    count = 1;
                }
            }

        }
        count = 0;
        for(int ele : arr)
            if(ele==majority)count++;
        if(count<=n/2)return -1;
        return majority;

    }
}
//public class MajorityElements {
//    public static void main(String[] args) {
//
//    }
//    public static int findMajor(int[] arr,int n){
//        if(n==1)return arr[0];
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int ele : arr)
//            map.put(ele,0);
//        for(int ele : arr)
//            map.put(ele,map.get(ele)+1);
//        int max = 0;
//        int maxEle = -1;
//        for(int ele : arr){
//            max = map.get(ele);
//            if(max>n/2)maxEle = ele;
//        }
//
//        return maxEle;
//
//    }
//    public static int mooresVotingAlgo(int[] array , int n){
//        int majorityIndex = 0;          // contains index of majority element not necessarily first occurring index;
//        int counter = 1;
//        for(int i = 1;i<n;i++){
//            if(array[majorityIndex]  == array[i])counter++;
//            else counter--;
//            if(counter==0){
//                majorityIndex=i;
//                counter = 1;
//            }
//        }
//        //finding number of occurence of majority;
//        int max = 0;
//        for(int i=0;i<n;i++)
//            if(array[majorityIndex]==array[i])max++;
//         if(max>n/2)return array[majorityIndex];
//         return -1;
//    }
//}
//
