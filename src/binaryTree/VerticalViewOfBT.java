package binaryTree;
/**
 * ************************IMPORTANT***************************************
 * problem link : https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1/?track=PC-W6-BST&batchId=154
 */

import java.util.*;

public class VerticalViewOfBT {
    // my approcah : we have to do level order traversal and we need to keep track of
    // horizontal position relative to root node , to do so i updated the node structure
    // and added extra field hat keep track of horizontal position of a particular node
    // also i used hashmap to store a node according
    // to its horizontal position in  a particular arraylist.
    // left and right keep track of maximum left and maximum right horizontal position
    class BinaryTree
    {    class data{
            int pos ;
            Node root;
            public data(int pos , Node node){
                this.pos = pos;
                root = node;
            }
        }
         ArrayList <Integer> verticalOrder(Node root)
        {
            Queue<data> q = new LinkedList<>();
            Map<Integer , ArrayList<Integer> > map = new HashMap<>();
            q.add(new data(0 , root));
            int left = 0;
            int right = 0;
            while(!q.isEmpty()){
                data x = q.poll();
                int pos = x.pos;
                Node iter = x.root;
                left = Math.min(left , pos);
                right = Math.max(right , pos);
                if(!map.containsKey(pos))map.put(pos , new ArrayList<>());
                map.get(pos).add(iter.data);
                if(iter.left!=null)q.add(new data(pos-1 , iter.left));
                if(iter.right!=null)q.add(new data(pos+1 , iter.right));
            }
            //System.out.println(map);
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=left  ; i<=right ; i++){
                ArrayList<Integer> temp = map.get(i);
                list.addAll(temp);
            }
            return list;
        }

    }
}
