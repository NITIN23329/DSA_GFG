package linkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionsOf2SLL {
    public Node getIntersectionNode(Node headA, Node headB) {
        //time complexity O(n+m)
        // space complexity O(n) n:length of headA
        Set<Node> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(set.contains(headB))return headB;
            headB = headB.next;
        }
        return null;
    }
    public Node getIntersectionNode1(Node headA, Node headB) {
        //time complexity O(n+m)
        // space complexity O(1)
        int len1 = 0;
        int len2 = 0;
        Node iter1 = headA;
        while(iter1!=null){
            len1++;
            iter1=iter1.next;
        }
        Node iter2 = headB;
        while(iter2!=null){
            len2++;
            iter2 = iter2.next;
        }
        if(len1>=len2){
            int x = len1-len2;
            iter1=headA;
            while(x-->0)iter1=iter1.next;
            iter2 = headB;
        }else{
            int x = len2-len1;
            iter2 = headB;
            while(x-->0)iter2 = iter2.next;
            iter1 = headA;
        }
        while(iter1!=null && iter2!=null){
            if(iter1==iter2)return iter1;
            iter1=iter1.next;
            iter2 = iter2.next;
        }
        return null;
    }

}
