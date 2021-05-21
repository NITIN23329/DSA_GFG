package binarySearchTree;
//problem link : https://practice.geeksforgeeks.org/problems/vertical-sum/1
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalSumBST {

    class Tree{
        int left ;
        int right ;
        Map<Integer, Integer> map;
        public ArrayList<Integer> verticalSum(Node root) {
            map = new HashMap<>();
            left = 0;
            right = 0;
            sum(root , 0);
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = left ; i<=right ; i++)
                list.add(map.get(i));
            return list;
        }
        public void sum(Node iter , int pos){
            if(iter==null)return;
            left  = Math.min(left , pos);
            right = Math.max(right , pos);
            if(map.containsKey(pos))
                map.put(pos , map.get(pos)+iter.data);
            else map.put(pos , iter.data);
            sum(iter.left , pos-1);
            sum(iter.right , pos+1);
        }
    }
}
