package binaryTree;

/**
 * *********************IMPORTANT********************************
 * problem link : https://practice.geeksforgeeks.org/tracks/PC-W6-T/?batchId=154
 * similar problem : https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1/?track=PC-W6-T&batchId=154
 */
public class BTToDLL {
    // my apporach: do in order traversal and form a new list
    // time complexity O(n)
    // space compleixty O(n)
    class GfG
    {
        Node head;      // it should not change in recursive calls
        Node list;
        Node bToDLLMySol(Node root)
        {
            if(root==null)return null;
            list = null;
            head=null;
            convertMySol(root);
            return head;

        }
        void convertMySol(Node root){
            if(root==null)return;
            convertMySol(root.left);
            if(head==null){
                head = new Node(root.data);
                list = head;
            }
            else{
                Node temp = new Node(root.data);
                list.right = temp;
                temp.left = list;
                list = temp;

            }
            convertMySol(root.right);
        }
    }
    // efficient approach: do in order traversal and keep hold of previously visited node.
    // make previous.right = current node and current .left  = previous node for every node in tree/
    // time complexity O(n)
    // space compleixty O(1)
    class GfGEfficent
    {   Node head;
        Node prev;
        Node bToDLL(Node root)
        {
            head=null;
            prev = null;
            convert(root);
            return head;
        }
        void convert(Node curr){
            if(curr == null)return;
            convert(curr.left );

            curr.left = prev;
            if(prev==null){
                head = curr;
            }else
                prev.right = curr;
            prev = curr;
            convert(curr.right);

        }
    }
}
