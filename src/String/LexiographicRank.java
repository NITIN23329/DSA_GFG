package String;

import java.util.Arrays;
import java.util.Scanner;

public class LexiographicRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        while(testCase-->0){
            String str = sc.nextLine();
            System.out.println(findRank(str));
        }

    }
    public static int findRank(String str){
          long [] fact = new long[16];
          fact[0]=1L;
          fact[1]=1L;
          for(int i=2;i<16;i++)
              fact[i] = (long)i*fact[i-1];
          int[] count = new int[26];
          for(int i= 0;i<str.length();i++)
              count[str.charAt(i)-'a']++;
          String sorted = "";
          for(int i=0;i<26;i++)
              if(count[i]==1)
                  sorted+=""+(char)(97+i);
          return -1;
    }
}
