package binaryTree;
//problem link : https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1/?track=PC-W6-T&batchId=154
public class checkbalanced {
    /** my code: time complexity O(n^2)
     * int height(Node *iter){
     *     if(iter==NULL)return 0;
     *     return 1 + max(height(iter->left),height(iter->right));
     * }
     * bool isBalanced(Node *root)
     * {   if(root==NULL)return true;
     *     if(abs(height(root->left) - height(root->right))>1)return false;
     *
     *     return isBalanced(root->left) && isBalanced(root->right);
     * }
     */
    boolean isBalanced(Node root)
    {   //O(n) solution
        if(root==null)return true;

        int[] a  =  helpr(root);
        return a[0] != -1;
    }
    int [] helpr(Node root){
        // it simultaneously calculate height of a node and check if node is balanced
        // we can dont need to consider an array; we can take a variable.
        // if it is negative, it means node is unbalanced else it will represent height of node
        if(root==null){
            int[] arr = new int[2];
            arr[0] = 1;
            arr[1] = 0;
            return arr;
        }
        int[] left = helpr(root.left);
        int[] right = helpr(root.right);
        int[] arr = new int[2];
        if(left[0]==-1 || right[0]==-1 || Math.abs(left[1]-right[1])>1)arr[0] = -1;
        else arr[0]=1;
        arr[1] = 1+Math.max(left[1],right[1]);
        return arr;

    }
}
