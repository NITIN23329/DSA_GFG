package binarySearchTree;
//practice link : https://practice.geeksforgeeks.org/problems/pair-sum-in-bst/1/?track=PC-W6-BST&batchId=154
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PairSum {
    // approach 1 : traverse whole BST and check for pair using arraylist and set
    class GFG {

        void postOrder(Node root, ArrayList<Integer> list) {
            if (root == null) return;
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.data);
        }

        boolean findPair(Node root, int sum) {
            ArrayList<Integer> list = new ArrayList<>();
            postOrder(root, list);
            Set<Integer> set = new HashSet<>(list);
            for (int ele : list) {
                if (sum - ele != ele && set.contains(sum - ele)) return true;
            }
            return false;
        }
    }
    // approach 2 : use profit of inOrder traversal as it gives sorted array
    // use 2 pointer approach to    find pair with given sum in sorted array.
    class GFG2   {

         void inOrder(Node root, ArrayList<Integer> list) {
            if (root == null) return;
            inOrder(root.left, list);
            list.add(root.data);
            inOrder(root.right, list);

        }
         boolean findPair(Node root, int sum) {
            ArrayList<Integer> list = new ArrayList<>();
            inOrder(root , list);
            int left = 0;
            int right = list.size()-1;
            while(right-left>0){
                if(sum==list.get(left)+list.get(right))return true;
                if(sum>list.get(left)+list.get(right))left++;
                else right--;
            }
            return false;
        }
    }
}
