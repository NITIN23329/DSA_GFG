package linkedList;

//problem link : https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
// problem 2 link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
class Node
{
    int data;
    Node next;
    public Node(int d)
    {data = d; next = null; }
}

public class KthNodeOnePass {
    int getNthFromLast(Node head, int n)
    {
        int count = 0;
        Node fast = head;
        Node sec = head;
        while( count++<n){
            if(fast==null)return -1;
            fast = fast.next;

        }

        while(fast!=null){
            fast = fast.next;
            sec = sec.next;
        }
        return sec.data;
    }
}
