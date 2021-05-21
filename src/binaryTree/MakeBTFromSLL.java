package binaryTree;
//problem link: https://practice.geeksforgeeks.org/problems/make-binary-tree/1/?track=PC-W6-T&batchId=154
import java.util.HashMap;
import java.util.Map;
class ListNode{
    int data;
    ListNode next;
    public ListNode(int data) {
        this.data = data;
    }
}
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this(data,null,null);
    }
    public TreeNode(int data,TreeNode left ,TreeNode right){
        this.data=data;
        this.left = left;
        this.right = right;
    }
}
public class MakeBTFromSLL {
    // my solution using hashMap
    public static TreeNode convert(ListNode head, TreeNode node) {
        if(head==null)return null;
        Map<Integer,TreeNode> map = new HashMap<>();
        map.put(0,new TreeNode(head.data));
        head = head.next;

        int ind=1;
        while(head!=null){
            map.put(ind++,new TreeNode(head.data));
            head = head.next;
        }
        for(int i=0;i<map.size();i++){
            TreeNode parent = map.get(i);
            TreeNode left ;
            if(2*i+1<map.size())left= map.get(2*i+1);
            else left = null;
            TreeNode right;
            if(2*(i+1)<map.size())right=  map.get(2*(i+1));
            else right = null;
            parent.left = left;
            parent.right = right;
        }
        return map.get(0);
    }
    // another approach usign queue
    // https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
}
