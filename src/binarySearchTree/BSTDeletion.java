package binarySearchTree;
// problem link : https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1/?track=PC-W6-BST&batchId=154
public class BSTDeletion {
    // time complexity O(height)
    // space complexity O(height)
    public static Node deleteNode(Node root, int ele)
    {   if(root==null)return null;
        if(root.data==ele && root.left==null && root.right==null)return null;
        else if(root.data==ele && root.left!=null){
            int temp = findMax(root.left);
            root.data = temp;
            root.left = deleteNode(root.left , temp);
            return root;
        }
        else if(root.data==ele){
            int temp = findMin(root.right); // changing iter in helper function does not chan   ge root
            root.data = temp;
            root.right =deleteNode(root.right , temp);
            return root;
        }
        else if (root.data>ele)root.left = deleteNode(root.left , ele);
        else root.right = deleteNode(root.right,ele);
        return root;
    }
    private static int findMin(Node iter){
        while(iter.left!=null)iter =iter.left;
        return iter.data;
    }
    private static int findMax(Node iter){
        while(iter.right!=null)iter =iter.right;
        return iter.data;
    }
}
