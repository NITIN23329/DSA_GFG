package binaryTree;
//broblem link : https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1/?track=PC-W6-T&batchId=154
public class BTUsingIn$Post {

    /**
     * naive O(n^2)
     * int i;  => keep iterating in post order
     * Node* build(int in[] , int post[] , int start , int end){
     *     if(start>end)return NULL;
     *     Node* iter = new Node(post[i]);
     *     int ind =-1;
     *     for(int j = start ; j<=end;j++){
     *         if(in[j]==post[i]){
     *             ind = j;
     *             break;
     *         }
     *     }
     *     i--;
     *     iter->right = build(in,post,ind+1,end);
     *     iter->left = build(in,post,start,ind-1);
     *     return iter;
     *
     * }
     * Node *buildTree(int in[], int post[], int n) {
     *     i=n-1;
     *     int start = 0;
     *     int end = n-1;
     *     return build(in , post , start , end);
     * }
     */
}
