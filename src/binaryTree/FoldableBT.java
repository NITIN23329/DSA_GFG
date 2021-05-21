package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1/?track=PC-W6-T&batchId=154
public class FoldableBT {

    /**
     * approach : take the left subtree of root , make its mirror image and
     * superimpose it in right  subtree of root
     * void mirror(Node* iter){
     *     if(iter==NULL)return ;
     *     Node * temp = iter->left;
     *     iter->left = iter->right;
     *     iter->right = temp;
     *     mirror(iter->left);
     *     mirror(iter->right);
     * }
     * bool isSimilar(Node* iter , Node* root){
     *     if(iter==NULL && root==NULL)return true;
     *     if(iter!=NULL && root==NULL)return false;
     *     if(iter==NULL && root!=NULL)return false;
     *     return isSimilar(iter->left , root->left) && isSimilar(iter->right , root->right);
     * }
     * bool IsFoldable(Node* root)
     * {
     *     if(root == NULL)return true;
     *      mirror(root->left);
     *      Node * iter = root->left;
     *     root = root->right;
     *     return isSimilar(iter , root);
     * }
     */
}
