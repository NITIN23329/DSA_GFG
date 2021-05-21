package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/check-if-subtree/1/?track=PC-W6-T&batchId=154
public class CheckIfSubTree {

    /**
     * // my approach is go to each node in parent, if parent.data==child.data then check furthur else
     * //check of other nodes in parent
     *time complexity O(nm)
     * bool helpr(Node* T , Node* S,Node* R){
     *       if(T==NULL && S==NULL)return true;
     *         if(T!=NULL && S==NULL)return false;
     *         if(T==NULL && S!=NULL)return false;
     *         if(T->data==S->data){
     *             bool ans =  helpr(T->left , S->left,R) && helpr(T->right , S->right,R);
     *             if (ans) return true;
     *         }
     *
     *             Node* t = R;
     *             return helpr(T->left,t,R) || helpr(T->right,t,R);
     * }
     * bool isSubTree(Node* T, Node* S) {
     *   Node* R = S;
     *   return helpr(T,S,R);

     */

    // another approach is that the inorder and pre/post order of a binary tree is unique.
    // if inorder if subtree is  a subset of inorder of parent tree and
    // pre/post order of subtree is also a subset of pre/post order of parent tree then it is true else false;
    // this approach link : https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/?ref=lbp
    // time complexity O(n)
}
