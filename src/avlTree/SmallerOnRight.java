package avlTree;
/**
 * *************************************IMPORTANT***************************************
 * problem link : https://practice.geeksforgeeks.org/problems/smaller-on-right/0/?track=PC-W6-BST&batchId=154
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SmallerOnRight {
    //the idea is to use a AVL tree like tree set ;
    // after every insertion we need to count elements smaller on right
    // so we travel from right to left in array and
    // count the element smaller than particular element in tree
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
           TreeSet<Integer> treeSet = new TreeSet<>();
            int count = 0 ;
            for(int i = n-1;i>=0;i--){
                treeSet.add(arr[i]);
                Set<Integer> set= treeSet.headSet(arr[i]);
                count = Math.max(count , set.size());

            }
            System.out.println(count);

        }
    }
}
