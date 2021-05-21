package linkedList;
//problem link : https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
import java.util.HashSet;
import java.util.Set;

public class DetectLoop {
    public boolean detectLoop1(Node head) {
        // time complexity O(n)
        // space complexity O(n)
        //it does not change the linked list
        Set<Node> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head))return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean floydCycle(Node head){
        //time complexity O(n)
        // space complexity O(1)
        //it does not change the linked list
        if(head==null || head.next==null)return false;
        Node slow = head;
        Node fast = head.next;
        while(true){
            if(fast==null || fast.next==null)return false;
            if(fast==slow)return true;
            fast = fast.next.next;
            slow = slow.next;
        }
    }
    // another approach is to update Node class by adding extra boolean value
    // isVisited which keep track of the node is visited or not.
    // while iterating if we find iter.isVisited==true then loop exists or if see null return false;
    public boolean detectLoop4(Node head){
        //time complexity O(n)
        // space complexity O(1)
        //it  changes the linked list
        if(head==null || head.next==null)return false;
        Node dummy = new Node(0);
        while (head.next!=dummy && head.next!=null){
            Node temp = head.next;
            head.next =  dummy;
            head = temp;
        }
        if(head.next==null)return false;
        return true;
    }
}