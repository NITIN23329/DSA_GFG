package recursion;
//problem link : https://practice.geeksforgeeks.org/problems/next-happy-number/0
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NextHappyNuber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            System.out.println(findHappy(n));
        }
    }

    private static int findHappy(int n) {
       for(int i=n+1;;i++){
           if(isHappy(i,new HashSet<>()))
               return i;
       }

    }

    private static boolean isHappy(int n, Set<Integer> set) {
       int x = findSum(n);
       if(x==1)return true;
       if(set.contains(x))return false;
       set.add(x);
       return isHappy(x,set);
    }

    private static int findSum(int n) {
        if(n==0)
            return 0;
        return (n%10)*(n%10) + findSum(n/10);
    }
}
