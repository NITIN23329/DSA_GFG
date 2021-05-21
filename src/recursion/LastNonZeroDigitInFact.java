package recursion;
//problem link : https://practice.geeksforgeeks.org/problems/last-non-zero-digit-in-factorial/0
import java.util.Scanner;

public class LastNonZeroDigitInFact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-->0){
            int n = sc.nextInt();
            long fact = 1L;
            for(int zz=2;zz<=n;zz++){
                fact *=zz;
                while (fact%10==0)
                    fact/=10;
                //we keep track of last2 or 3 digits atmost
                //reason?? u think
                fact=fact%1000;
            }
            System.out.println(fact%10);
        }
    }
}
