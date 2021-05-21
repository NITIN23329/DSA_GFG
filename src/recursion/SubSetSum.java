package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSetSum {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int testCase=sc.nextInt();
        while(testCase-->0){
            int n=sc.nextInt();
            int[] arr = new int [n];
            for(int i=0 ; i< n ;i++)
                arr[i]=sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            func(0,arr,0,list);
            System.out.println(list);

        }
    }
    public static void func(int curr, int[] arr,int index,ArrayList<Integer> list){
        if(index>=arr.length){
            list.add(curr);
            return ;
        }
        func(curr,arr,index+1,list);
        func(curr+arr[index],arr,index+1,list);
    }
}
