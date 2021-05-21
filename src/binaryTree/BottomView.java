package binaryTree;
// prolem link : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/?track=PC-W6-BST&batchId=154
import java.util.*;

public class BottomView {
    class Tree
    {
        int left;
        int right;
        class data{
            int pos ;
            Node temp;
            public data(int position ,Node node){
                pos = position;
                temp = node;
            }
        }
        public ArrayList<Integer> bottomView(Node root)
        {   left =0;
            right = 0;
            Queue<data> q =new LinkedList<>();
            Map<Integer ,Integer> map = new HashMap<>();
            q.add(new data(0 , root));
            ArrayList<Integer> list = new ArrayList<>();
            while(!q.isEmpty()){
                data x = q.poll();
                int pos = x.pos;
                Node iter = x.temp;
                left = Math.min(left,pos);
                right = Math.max(right , pos);
                map.put(pos , iter.data);
                if(iter.left!=null)q.add(new data(pos-1 , iter.left));
                if(iter.right!=null)q.add(new data(pos+1 , iter.right));
            }
            for(int i=left ; i<=right ; i++)list.add(map.get(i));
            return list;
        }

    }
}
