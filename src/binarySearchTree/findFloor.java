package binarySearchTree;
// problem link : https://practice.geeksforgeeks.org/problems/implementing-floor-in-bst/1/?track=PC-W6-BST&batchId=154
// another problem : https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1/?track=PC-W6-BST&batchId=154
// yet another : https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1/?track=PC-W6-BST&batchId=154
import java.util.ArrayList;

public class findFloor {
    // approach 1 : do inorder traversal ,  it will give a sorted array
    // and then find closest smaller value in it
    // time complexity O(n)
    // space complexity (n)
    class Sol
    {
        void inOrder(Node root, ArrayList<Integer> list) {
            if (root == null) return;
            inOrder(root.left, list);
            list.add(root.data);
            inOrder(root.right, list);

        }
        int floor(Node root, int key)
        {
            ArrayList<Integer> list = new ArrayList<>();
            inOrder(root , list);
            if(list.get(0)>key)return -1;
            if(list.get(list.size()-1)<=key)return list.get(list.size()-1);
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)<=key && list.get(i+1)>key)return list.get(i);
            }
            return -1;
        }

    }
    // another approach by me :
    // maintain a variable which keep track of nearest smaller number to key ,
    // if we found and more nearest number we update the variable
    // time complexity O(height)
    // space complexity O(1);
    class SolEfficient
    {   int closest = -1;
        int floor(Node root, int key)
        {
            if(root==null)return closest;
            if(key-root.data>=0 && key-closest>key-root.data)closest = root.data;
            if(root.data<key)return floor(root.right , key);
            else return floor(root.left , key);
        }

    }
    // approach 3 :
    //if root key is same as we key then we return root.data
    // it root .data if greater then key ,the root can not be the answer , we go to left subtree
    // if root.data is small then we update ans as root (because root can be a floor)and go to right subtree.
    class SolEfficient2
    {
        int floor(Node root, int key)
        {
            Node ans = null;
           while (root!=null){
               if(root.data==key)return key;
               if(root.data>key)root = root.left;
               else{
                   ans = root;
                   root = root.right;
               }
           }
           return ans.data;
        }

    }
}
