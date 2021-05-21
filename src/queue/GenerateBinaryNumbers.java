package queue;
// problem link : https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1/?track=SPC-Queue&batchId=154

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        long n = 20;
        System.out.println(generate(n));
    }
    static ArrayList<String> generate(long n)
    {
        ArrayList<String> temp = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-->0){
            String str = q.poll();
            temp.add(str);
            q.add(str+"0");
            q.add(str+"1");
        }
        return temp;
    }
}
