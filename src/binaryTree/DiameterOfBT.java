package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1/?track=PC-W6-T&batchId=154
public class DiameterOfBT {
    /* time complexity o(n*n)
        int height(Node *iter){
            if(iter==NULL)return 0;
            return 1 + max(height(iter->left),height(iter->right));
        }
        int diameter(Node* node) {
            if(node==NULL)return 0;
            int left = height(node->left);
            int right = height(node->right);
            return max( max(diameter(node->left),diameter(node->right)) , right+left+1);
        }
     */

    /**
     * pre compute height of each node in tree and store in a hashmap
     * instead of calling height function ,in  above approach  use hashmap to  get height a node in O(1) .

     */
    int diameter(Node root) {
        //O(n) solution
        int[] arr =helpr(root);
        return arr[1];
    }
    private int[] helpr(Node iter){
        // stores height in arr[0] and stores maximum diameter till now in arr[1]
        if(iter==null){
            int[] arr = new int[2];
            arr[0] = 0;
            arr[1] = 0;
            return arr;
        }
        int[] left = helpr(iter.left);
        int[] right = helpr(iter.right);
        int[] arr = new int[2];
        arr[1] = Math.max(left[0]+right[0]+1,Math.max(left[1],right[1]));
        arr[0] = Math.max(left[0],right[0])+1;
        return arr;
    }

}
