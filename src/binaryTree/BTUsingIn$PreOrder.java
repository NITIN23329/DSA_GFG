package binaryTree;

import java.util.HashMap;
import java.util.Map;

//problem link : https://practice.geeksforgeeks.org/problems/construct-tree-1/1
//another problem : https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1/?track=PC-W6-BST&batchId=154
public class    BTUsingIn$PreOrder {

    // naive O(n^2) solution
    class Solution
    {    int i;
        public  Node buildTree(int inorder[], int preorder[], int n)
        {   i=0;
            int start = 0;
            int end = n-1;
           return build(  inorder , preorder , start ,end);

        }
        public   Node build( int[] inorder , int[] preorder , int start , int end){
            if(start>end || i>=inorder.length)return null;
            Node iter = new Node(preorder[i]);
            int ind = -1;
            for(int j=start;j<=end;j++){
                if(inorder[j]==preorder[i]){
                    ind = j;
                    break;
                }
            }
            i++;
            iter.left = build(inorder,preorder, start , ind-1);
            iter.right = build( inorder,preorder  , ind+1 , end);
            return iter;
        }
    }

    // instead of searching in inorder ,we can use hashmap which stores node values as key and their index as value
    // this work provided the tree must have distinct values.
    // time complexity O(n)
    static int i=0;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {   i=0;
        int start = 0;
        int end = n-1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(inorder[i],i);
        return build(  inorder , preorder , start ,end,map);

    }
    public  static Node build( int[] inorder , int[] preorder , int start , int end,Map<Integer,Integer> map){
        if(start>end || i>=inorder.length)return null;
        Node iter = new Node(preorder[i]);
        int ind = map.get(preorder[i]);

        i++;
        iter.left = build(inorder,preorder, start , ind-1, map);
        iter.right = build( inorder,preorder  , ind+1 , end,map);
        return iter;
    }

}
