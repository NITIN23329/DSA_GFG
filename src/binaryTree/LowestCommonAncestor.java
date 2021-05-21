package binaryTree;
/** *********************************************IMPORTANT**************************************
 * problem link : https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1/?track=PC-W6-T&batchId=154
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {
    Node lca1(Node root, int n1,int n2)
    {
        //my solution requires 2 traversal of tree
        // space complexity O(n)
        if(root==null)return null;
        ArrayList<Node> v1 = new ArrayList<>();
        ArrayList<Node> v2 = new ArrayList<>();
        Node iter = root;
        int f1 = findAncestors(iter,n1,v1);
        if(f1==-1)return null;
        iter = root;
        findAncestors(iter,n2,v2);
        //System.out.println(v1+"   "+v2);
        Set<Node> s2 = new HashSet<>(v2);
        for(Node ele : v1){
            if(s2.contains(ele))return ele;
        }
        return null;
    }
    int findAncestors(Node root, int n1, ArrayList<Node> v1){
        if(root==null)return -1;
        if(root.data==n1){
            v1.add(root);
            return 1;
        }
        int a = findAncestors(root.left,n1,v1);
        if(a==1){
            v1.add(root);
            return 1;
        }
        int b = findAncestors(root.right,n1,v1);
        if(b==1){
            v1.add(root);
            return 1;
        }
        return -1;
    }
}
