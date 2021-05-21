package recursion;
//problem link : https://practice.geeksforgeeks.org/problems/fact-digit-sum/0
import java.util.Scanner;

public class FactDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase  = sc.nextInt();
        while (testCase-->0){
            int n = sc.nextInt();
            int[] fact = new int[10];
            fact[0]=fact[1]=1;
            for(int i=2;i<10;i++)
                fact[i] = i*fact[i-1];
            StringBuilder str = new StringBuilder();
            while (n!=0){
                for(int i=9;i>=1;i--)
                    if(n-fact[i]>=0) {
                        str.append(i);
                        n-=fact[i];
                        break;
                    }
            }
            System.out.println(str.reverse());
        }
    }
}
