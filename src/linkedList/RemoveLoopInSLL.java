package linkedList;
// problem link : https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
// solution : https://www.youtube.com/watch?v=-YiQZi3mLq0
// solution picture :C:\Users\dark_\Pictures\Camera Roll\proof of floyd cycle detection algo.jpg
import java.util.HashSet;
import java.util.Set;

public class RemoveLoopInSLL {
    public static void removeLoop(Node head){
        // time complexity O(n)
        // space complexity O(n)
        if(head==null || head.next==null)return ;
        Set<Node> set = new HashSet<>();
        Node iter = head;
        while(iter!=null){
            if(set.contains(iter.next)){
                iter.next = null;
                return;
            }
            set.add(iter);
            iter = iter.next;
        }
    }
    public static void removeLoop2(Node head){
        // time complexity O(n)
        // space complexity O(1)
        if(head == null || head.next==null)return;
        Node slow = head;
        Node fast  = head.next;
        while(true){
            if(fast==null || fast.next==null)return;
            if(fast ==slow) {
                slow = head;
                while(slow!=fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                return;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

}
