package binaryTree;
//problem link : https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
// another problem : https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1/?track=PC-W6-T&batchId=154
import java.util.LinkedList;
import java.util.Queue;

public class leftViewOfBinaryTree {

    void leftView(Node root)
    {
        //O(n) solution
        if(root==null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        System.out.print(root.data+" ");
        while(q.size()>1){
            Node x = q.poll();
            if(x==null){
                q.add(x);
                System.out.print(q.peek().data+" ");
            }
            else{

                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }

    }
}