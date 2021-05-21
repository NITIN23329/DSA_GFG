package linkedList;
// problem link :https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
public class ReverseSLLInGroup {
}
class GfG
{
    public static Node reverse(Node head, int k)
    {
        Node iter = head;
        Node right1 = null;
        Node left1 = null;
        Node right2  = null;
        Node left2 = head;
        int count = 0;
        while(iter!=null){
            count++;
            int x = k;
            Node prev = null;
            while(x-->0 && iter!=null){
                Node curr = iter.next;
                iter.next = prev;
                prev = iter;
                iter = curr;
            }
            if(count==1)head = prev;
            right1=prev;
            right2 = iter;
            if(left1!=null)
                left1.next = right1;
            left2.next = right2;
            left1 = left2;
            left2 = iter;

        }
        return head;
    }
}
