package oneDArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Leaders {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase -- >0){
            int n =Integer.parseInt(br.readLine());;
            String str[] = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(str[i]);
            ArrayList<Integer> list =leaders(arr);
            StringBuilder sb=new StringBuilder();
            for (int ele : list)
                sb.append(ele).append(" ");

            System.out.println(sb);

        }
    }
    public static ArrayList<Integer> leaders(int[] arr){
        int[] temp = new int[arr.length];
        int max = arr[arr.length-1];
        for(int i = arr.length-1;i>=0;i--){
            max = Math.max(max,arr[i]);
            temp[i]=max;
        }
        ArrayList<Integer> list =new ArrayList<>();
        for(int i = 0;i<temp.length;i++)
            if(temp[i]==arr[i])list.add(temp[i]);
        return list;
    }
}
