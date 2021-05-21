package linkedList;
//****************************IMPORTANT************************
// problem link : https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

import java.util.HashMap;
import java.util.Map;
class RNode {
    int val;
    RNode next;
    RNode random;

    public RNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class ColoneLLHavingRandomRefrence{
    public RNode copyRandomList1(RNode head) {
        //time complexity O(n)
        // space complexity O(1)
        Map<RNode,RNode> map = new HashMap<>();
        RNode iter = head;
        while(iter!=null){
            map.put(iter,new RNode(iter.val));
            iter = iter.next;
        }
        iter = head;
        while(iter!=null){
            RNode temp=map.get(iter);
            temp.next = map.get(iter.next);
            temp.random = map.get(iter.random);
            iter = iter.next;
        }
        return map.get(head);
    }
    public RNode copyRandomList2(RNode head) {
        //time complexity O(n)
        // space complexity O(1)
        // make sure you don't update original list.
        RNode iter = head;
        if(head==null)return head;
        while(iter!=null){
            RNode temp = iter.next;
            iter.next = new RNode(iter.val);
            iter = iter.next;
            iter.next = temp;
            iter = iter.next;
        }
        iter = head;
        while(iter!=null){
            if(iter.random==null)iter.next.random =null;
            else
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        RNode old = head;
        RNode newNode = head.next;
        RNode t = newNode;
        while(newNode.next!=null){
            old.next = old.next.next;
            newNode.next = newNode.next.next;
            old = old.next;
            newNode =  newNode.next;
        }old.next = old.next.next;
        return t;
    }
}

