package binaryTree;
/**
 * ***********************************IMPORTANT**************************************
 * problem link : https://practice.geeksforgeeks.org/problems/node-at-distance/1/?track=PC-W6-T&batchId=154
 * solution link : https://www.youtube.com/watch?v=ZgT8NXIMF4g
 * approach : take a stack , push node in it, if the current node is leaf
 * then the kth node from top of stack is answer , add it to set and return .
 * after processing left subtree remove all left elements from stack and go to right subtree and do same
 *
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NodeAtKDistanceFromLeaf {
    class Solution{
        Stack<Node> st ;
        Set<Node> set;
        int printKDistantfromLeaf(Node root, int k)
        {
            if(root==null)return 0;
            st = new Stack<>();
            set = new HashSet<>();
            findCount(root , k);
            return set.size();
        }
        void findCount(Node iter , int k ){
            st.push(iter);
            if(iter.left==null && iter.right==null){
                if(st.size()<k+1)return;
                Node get = st.get(st.size()-(k+1));
                set.add(get);
                return;
            }
            if(iter.left!=null){
                findCount(iter.left , k);
                st.pop();
            }

            if(iter.right!=null){
                findCount(iter.right , k);
                st.pop();
            }

        }

    }

}
