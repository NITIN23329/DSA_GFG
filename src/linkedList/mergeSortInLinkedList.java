package linkedList;

public class mergeSortInLinkedList {
    public static void main(String[] args) {
        Node head=new Node(9);
        head.next=new Node(8);
        head.next.next=new Node(7);
        head.next.next.next=new Node(6);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(-8);
        head=sort(head);
        Node iter=head;
        while(iter!=null){
            System.out.println(iter.data);
            iter=iter.next;
        }
    }
    public static Node sort(Node head){
        if(head==null || head.next==null)return head;
        Node left,right;
        Node slow=head,fast=head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node nextMiddle=slow.next;
        slow.next=null;
        left=sort(head);
        right=sort(nextMiddle);
        return  merge( left,right);

    }
    public static  Node merge(Node left,Node right){
        Node result;
        //if(left==null || right==null)return null;
       if(left.data<right.data){result=new Node(left.data);left=left.next;}
       else{ result=new Node(right.data);right=right.next;}
       Node iter=result;
       while (left!=null && right!=null){
           if(left.data<right.data){
               iter.next=new Node(left.data);
                left=left.next;
           }
           else{
               iter.next=new Node(right.data);
                right=right.next;
           }
           iter=iter.next;

       }
       while (left!=null){
           iter.next=new Node(left.data);
           iter=iter.next;
           left=left.next;
       }
        while (right!=null){
            iter.next=new Node(right.data);
            iter=iter.next;
            right=right.next;
        }
            return result;
    }

}


