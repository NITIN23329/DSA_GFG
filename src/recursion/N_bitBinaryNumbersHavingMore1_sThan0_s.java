package recursion;
//problem link : https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s/0
import java.util.ArrayList;
import java.util.Scanner;

public class N_bitBinaryNumbersHavingMore1_sThan0_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-->0){
            int n = sc.nextInt();
            ArrayList<String > list = new ArrayList<>();
            generate(list,n,"1",1,0);
            for(String ele : list) System.out.print(ele+" ");
            System.out.println();
        }
    }
    private static void generate( ArrayList<String > list ,int n ,  String curr , int noOfOnes,int noOfZeroes){
        if(curr.length()==n){
            list.add(curr);
            return;
        }
        if(noOfOnes==noOfZeroes)
            generate(list,n,curr+"1",noOfOnes+1,noOfZeroes);
        else{
            generate(list,n,curr+"1",noOfOnes+1,noOfZeroes);
            generate(list,n,curr+"0",noOfOnes,noOfZeroes+1);
        }
    }
}
