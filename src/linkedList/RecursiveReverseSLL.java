package linkedList;

public class RecursiveReverseSLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node iter ;

         iter = reverse(head,null);
        while (iter!=null){
            System.out.print(iter.data+" ");
            iter=iter.next;
        }
    }
    public static Node reverse(Node iter,Node prev){
        Node curr = iter.next;
        iter.next = prev;
        if(curr!= null) return reverse(curr,iter);
        return iter;
    }

}





