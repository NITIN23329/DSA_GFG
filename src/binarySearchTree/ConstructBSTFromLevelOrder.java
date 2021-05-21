package binarySearchTree;
// problem link : https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1/?track=PC-W6-BST&batchId=154
public class ConstructBSTFromLevelOrder {
    public Node constructBST(int[] arr){
        Node root = new Node(arr[0]);
        for(int i=1;i<arr.length;i++)
            root =  bst(root , arr[i]);
        return root;
    }
    private Node bst(Node root  , int ele){
        if(root==null){
            root = new Node(ele);
            return root;
        }
        if(root.data<ele) root.right = bst(root.right , ele);
        else root.left = bst(root.left , ele);
        return root;
    }
}
