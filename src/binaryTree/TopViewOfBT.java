package binaryTree;

/**
 *  **********************************IMPORTANT***************************************
 *  problem link : https://practice.geeksforgeeks.org/problems/vertical-width-of-a-binary-tree/1/?track=PC-W6-T&batchId=154
 *  another problem : https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1/?track=PC-W6-BST&batchId=154
 */
public class TopViewOfBT {
    /**
     * my approach. maintain a global minvalue,maxvalue and count. min value is the left most node seen so far from root(denoted as 0),
     * max is the right most node seen so fare from root and count is the no of extreme nodes.
     * curr is the position of current node wrt root. if current is less than min
     * then it is a extreme node on left side, update min and increment count
     * if curr is > max, then it is extreme node on right side, update max and increment count
     *
     * void find(Node *iter ,int curr, int &min,int &max ,int &count){
     *     if(iter==NULL)return;
     *     if(curr<min){
     *         min=curr;
     *         count++;
     *     }
     *      if(curr>max){
     *         max = curr;
     *         count++;
     *     }
     *     find(iter->left , curr-1,min,max,count);
     *     find(iter->right,curr+1,min,max,count);
     * }
     * int verticalWidth(Node* root)
     * {   int count = 0;
     *     if(root==NULL)return 0;
     *     int min = 0;
     *     int max = 0;
     *     find(root,0,min , max , count);
     *     return count+1;
     * }
     */
}
