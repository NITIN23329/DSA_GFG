package binaryTree;
// problem link ; https://practice.geeksforgeeks.org/problems/children-sum-parent/1/?track=PC-W6-T&batchId=154
public class childSumProperty {

    public static int isSumProperty(Node root) {
        if (root == null) return 1;
        int a = isSumProperty(root.left);
        int b = isSumProperty(root.right);
        if (a == 0 || b == 0) return 0;
        if (root.left != null && root.right != null) {
            if (root.data != root.left.data + root.right.data)
                return 0;
            return 1;
        }
        if (root.left != null) {
            if (root.data != root.left.data) return 0;
            return 1;
        }
        if (root.right != null) {
            if (root.data != root.right.data) return 0;
            return 1;
        }
        return 1;
    }
}