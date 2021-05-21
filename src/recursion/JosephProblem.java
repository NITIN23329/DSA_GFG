package recursion;
//problem link : https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle/0
//similar problem : https://practice.geeksforgeeks.org/problems/finding-position/0
import java.util.ArrayList;
import java.util.Scanner;

// time compexity O(n^2)
public class JosephProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase=  sc.nextInt();
        while (testCase-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt()-1;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(i + 1);
            System.out.println(josephus(list, 0, k));
        }

    }

    private static int josephus(ArrayList<Integer> list , int curr , int k) {
      if(list.size()==1)
          return list.get(0);
      list.remove((curr+k)%list.size());
      return josephus(list,(curr+k)%(list.size()+1),k);
    }
}