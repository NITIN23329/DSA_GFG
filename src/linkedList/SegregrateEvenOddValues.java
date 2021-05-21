package linkedList;
// link : https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list/0
public class SegregrateEvenOddValues {
    public static Node function(Node head){
        //time complexity O(n)
        // space complexity O(1) i.e. in place
        Node dummy = new Node(0);
        dummy.next = head;
        Node iter = head;
        Node prev = dummy;
        Node bound = dummy;
        while(iter!=null){
            Node curr = iter.next;
            if(iter.data%2==0){
                Node temp = bound.next;
                if(temp==iter)prev = iter;
                else{
                    bound.next = iter;
                    iter.next = temp;
                    prev.next = curr;
                }
                bound = bound.next;
            }
            else  prev = iter;

            iter = curr;
        }
        return dummy.next;
    }
    // another approach is make 2 temporary list. 1st list contains all even nodes
    // and 2nd list contains all odd nodes and join even and odd.
    //time complexity O(n)
    // space complexity O(n)
}
