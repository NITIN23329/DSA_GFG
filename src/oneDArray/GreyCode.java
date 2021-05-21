package oneDArray;

import java.io.PrintStream;
import java.util.Scanner;

// problem link : https://cses.fi/problemset/task/2205/
public class GreyCode {
    /*
      --> We can see that some of them are already in grey order and some of them must be swapped
      --> Like 00,01 and 10,11 are already grey, if we swap 10 and 11 then 00,01,11,10 is also grey.
      --> Likewise 000,001,011,010 and  100,101,111,110 are already grey, If we swap the later part we get :
          -->  000,001,011,010,110,111,101,100 which are now in grey code. We can extend it further.
      --> Note : swap lower places first.
   */
    public static void solve() {
        int n = sc.nextInt();
        int len = (int)Math.pow(2,n);
        String[] str = new String[len];
        for(int i=0;i<len;i++)
            str[i] = convert2Binary(i,n);    // O(mlogm)

        for(int i=4;i<=len;i*=2){            // O(logm)
            for(int j = 0;j+i<=len;j+=i){    // m
                int  l = j+i/2;
                int r = j+i-1;
                while (l<r){                     // O(logm)/2
                    swap(str,l,r);               // O( m * logm * logm)
                    l++;
                    r--;
                }
            }
        }
        // total time complexity loose upper bound: O( m * logm * logm), where m = 2^n
        StringBuilder sb = new StringBuilder();
        for(String ele:str)sb.append(ele).append("\n");
        out.println(sb);


    }
    private static void swap(String[] str, int l,int r){
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
    private static String convert2Binary(int val,int n){
        StringBuilder binary = new StringBuilder();
        while (val>0){
            binary.insert(0,val%2==0?"0":"1");
            val/=2;
        }
        int zeros = n - binary.length();
        for(int i=0;i<zeros;i++)binary.insert(0,"0");
        return binary.toString();
    }
    static Scanner sc = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);
}
