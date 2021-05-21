package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/level-order-traversal-line-by-line/1/?track=PC-W6-T&batchId=154
//
import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversalLineByLine {

    static void levelOrderMethod1(Node node)
    {
        //my solution prints each level in a new line
        //time complexity O(N+nooflevels)
        //space complexity O(N+nooflevels)
        // we can also use null in place of -999
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(new Node(-999));
        while(q.size()>1){
            Node x = q.poll();
            if(x.data==-999){
                System.out.println();
                q.add(x);
            }
            else{
                System.out.print(x.data+" ");
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }
    }
    static void levelOrderMethod2(Node node)
    {   //time complexity O(N)
        //space complexity O(width)
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0;i<count;i++){
                Node x = q.poll();
                System.out.print(x.data+" ");
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            System.out.println();
        }

    }
}
