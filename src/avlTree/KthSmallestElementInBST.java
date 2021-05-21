package avlTree;

import java.util.ArrayList;

/**
 * *******************************************IMPORTANT****************************
 * ***************************************SEE LAST SOLUTION************************
 * // problem link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

public class KthSmallestElementInBST {
    //naive solution
    //time complexity O(n)
    public int kthSmallest(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root , list);
        return list.get(k-1);
    }
    private void inOrder(Node root , ArrayList<Integer> list){
        if(root==null)return;
        inOrder(root.left , list);
        list.add(root.data);
        inOrder(root.right , list);
    }
    // another approach better then above;
    // the size of list become k last element is our ans and then return
    // time complexity O(k)
    ArrayList<Integer> list;
    public int kthSmallest1(Node root, int k) {
        list = new ArrayList<>();
        inOrder(root , k);
        return list.get(k-1);

    }
    private void inOrder(Node root,int k){
        if(root==null)return;
        inOrder(root.left , k);
        list.add(root.data);
        if(list.size()==k){
            return;
        }

        inOrder(root.right , k);
    }
    //solution : gfg DSA course BST track
    // efficient solution
    // HOTS solution
    // time complexity o(height)
    // this special approach require extra information to be stored for each Node;
    // this extra informaton is the number of nodes to left of a particular node
    // if the leftCount +1 is equal to k then we found our node
    // if the leftCount+1 is greater than k then answer is on left subtree
    // else we update the k to k-leftCount-1 and go to right subtree
    //code :
    //more info?? : https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/754890/2-Simple-approaches-and-a-HOTS-approach(**must-see**)
    // updated node
    class Node{
        int data;
        int leftCount;     //stores number of nodes in its left subtree
        Node left,right;
        public Node(int data){
            this.data = data;
            leftCount = 0;
        }
    }
    // implementation of this approach
    Node head;
    int ans;
    public void findKThSmallest(Node iter,int k){
        if(iter==null)return;
        if(iter.leftCount+1==k){
            ans = iter.data;
            return;
        }
        else if(iter.leftCount+1>k){
            findKThSmallest(iter.left , k);
        }
        else
            findKThSmallest(iter.right ,k-iter.leftCount-1);
    }

}
