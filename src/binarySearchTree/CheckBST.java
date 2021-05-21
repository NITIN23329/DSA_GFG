package binarySearchTree;
// problem link : https://practice.geeksforgeeks.org/problems/check-for-bst/1/?track=PC-W6-BST&batchId=154
public class CheckBST {
    /**
     * In BST we consider only distinct values , if there are duplicate values then its not a BST.
     */
    // approach 1 : do inorder traversal and check if the list is sorted and distinct.
    // time complexity O(n) ; space complexity O(n)\

    // approach 2
    // for every node we specify a range. the data must be in given range for a particular node
    // for left sub tree the upper bound will be its parent data-1
    // for right sub tree the lower bound is its parent data +1
    // time complexity O(n)  ;  space complexity O(1)
    boolean isBST(Node root)
    {
        return check(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    boolean check(Node iter , int low , int high){
        if(iter==null)return true;
        if(!(iter.data<=high && iter.data>=low))return false;
        return check(iter.left , low , iter.data-1) &&
                check(iter.right , iter.data+1 , high);
    }

}
