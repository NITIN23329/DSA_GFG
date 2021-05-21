package binaryTree;
/**
 * *************************************INPORTANT*******************************
 * problem link : https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1/?track=PC-W6-T&batchId=154
 * solution link : https://www.youtube.com/watch?v=lUnNK9jPg2Y
 *
 */

import java.util.ArrayList;

public class SerializeDeserialize {
    class Tree {
        // do the preorder traversal , when we get null we add null else we add value of node

        public void serialize(Node root, ArrayList<Integer> list) {
            if(root==null){
                list.add(null);
                return;

            }
            list.add(root.data);
            serialize(root.left , list);
            serialize(root.right , list);
        }
        // we iterate over list  , (make tree in preorder fashion) first we make node then we call for its left subtree
        // and for its right subtree , if we get null we simple increment the counter and return null.
        int i;
        public Node deSerialize(ArrayList<Integer> list){
            i = 0;
            return form(list);
        }
        private Node form(ArrayList<Integer> list){
            if(i==list.size() )return null;
            if( list.get(i)==null){
                i++;
                return null;
            }
            Node iter = new Node(list.get(i));
            i++;
            iter.left = form(list);
            iter.right = form(list);
            return iter;
        }
    }
}
