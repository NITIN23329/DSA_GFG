package binarySearchTree;
//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/?track=PC-W6-BST&batchId=154
public class LCAOfBST {
    class BST {
        // logic is use the property of bst and assume that both n1 and n2 are present.
        // if both n1 and n2 are greater than root go to right
        // if both n1 and n2 are smaller than root go to left
        // else the ans is root because one of n1 or n2 is on left side and other is on right side.

        Node LCA(Node root, int n1, int n2) {
            if (root == null) return null;
            if (root.data == n1 || root.data == n2) return root;
            else if (root.data > n1 && root.data < n2 || root.data < n1 && root.data > n2) return root;
            else if (root.data > n1 && root.data > n2) return LCA(root.left, n1, n2);
            else return LCA(root.right, n1, n2);

        }
    }
}
