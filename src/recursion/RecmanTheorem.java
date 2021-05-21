package recursion;

/*problem link : https://practice.geeksforgeeks.org/problems/recamans-sequence/0
*youtube video to recman series ; https://www.youtube.com/watch?v=FGC5TdIiT9U&t=116s
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecmanTheorem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-->0){
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            recman(set,n,0,1);
            System.out.println();

        }
    }
    private static void recman(Set<Integer> set , int n,int curr,int jump){
        if(jump==n+1)return;
        set.add(curr);
        System.out.print(curr+" ");
        if(curr-jump>=0 && !set.contains(curr-jump)){
            recman(set,n,curr-jump,jump+1);
        }
        else {
            recman(set,n,curr+jump,jump+1);
        }
    }
}
