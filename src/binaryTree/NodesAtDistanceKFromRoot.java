package binaryTree;
/** problem link : https://practice.geeksforgeeks.org/problems/k-distance-from-root/1

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NodesAtDistanceKFromRoot {
    void printKdistance(Node root, int k)
    {
        //my solution , iterative
        Queue<Node> q = new LinkedList<>();
        int count = 01;
        if(root==null)return;
        q.add(root);
        q.add(null);
        ArrayList<Integer> list = new ArrayList<>();
        while(q.size()>1 ){
            if(count>k+1 )break;
            Node x = q.poll();
            if(x==null){
                count++;
                q.add(x);
            }
            else{
                if(count==k+1)list.add(x.data);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }

        }
        for(int ele:list)System.out.print(ele+" ");
    }
    void printKDistanceRecursive(Node root, int k){
        //recursive solution
        if(root==null)return;
        if(k==0)System.out.println(root.data+" ");
        else{
            printKDistanceRecursive(root.left,k-1);
            printKDistanceRecursive(root.right,k-1);
        }
    }
}

