package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1/?track=PC-W6-T&batchId=154

import java.util.Stack;

public class SpiralTraversal {

    void printSpiral(Node node)
    {   if(node==null)return;
        Stack<Node> right = new Stack<>();
        Stack<Node> left = new Stack<>();
        StringBuilder br = new StringBuilder("");
        right.push(node);
        while(!(right.isEmpty() && left.isEmpty())){
            while(!right.isEmpty()){
                Node x = right.pop();
                br.append(x.data).append(" ");
                if(x.right!=null)left.push(x.right);
                if(x.left!=null)left.push(x.left);
            }
            while(!left.isEmpty()){
                Node x = left.pop();
                br.append(x.data).append(" ");
                if(x.left!=null)right.push(x.left);
                if(x.right!=null)right.push(x.right);
            }
        }

        System.out.print(br);
    }
}
