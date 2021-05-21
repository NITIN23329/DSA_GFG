package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1/?track=PC-W6-T&batchId=154
public class MaxDiffBtwNodeAndAncestor {
    class Tree
    {   int max;
        int maxDiff(Node root)
        {
            max = -999999;
            findMin(root);
            return max;
        }
        int findMin(Node root){
            if(root==null)return 999999;

            int left = findMin(root.left);
            int right = findMin(root.right);
            max = Math.max(max , Math.max(root.data - left , root.data - right));
            return Math.min(root.data , Math.min(left , right));
        }

    }


}
