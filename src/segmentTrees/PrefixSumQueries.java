/*
    created by: nitin23329
    on Date: 21/06/21
*/
package segmentTrees;

import java.util.Scanner;

public class PrefixSumQueries {
    static class Node{
        long full;
        long prefix;
        public Node(){
            this(0);
        }
        public Node(int init){
            full = prefix = init;
        }
    }
    static class SegTree{
        Node[] segTree;
        int[] arr;
        public SegTree(int[] arr,int n){
            this.arr = arr;
            segTree = new Node[4*n];
            createSegTree(0,n-1,0);
        }
        public Node merge(Node left,Node right){
            if(left == null)return right;       // null checks are added only for getNode()
            if(right == null) return left;
            Node parent = new Node();
            parent.full = left.full + right.full;
            parent.prefix = Math.max(left.prefix, left.full + right.prefix);
            return parent;
        }
        public Node createSegTree(int stL,int stR,int stIndex){
            if(stL == stR){
                Node leaf = new Node(arr[stL]);
                return segTree[stIndex] = leaf;
            }
            int mid = (stL + stR)/2;
            Node left = createSegTree(stL,mid,2*stIndex+1);
            Node right = createSegTree(mid+1,stR,2*stIndex+2);
            return segTree[stIndex] = merge(left,right);
        }
        public Node updateNode(int stL,int stR,int updateValue,int updateIndex,int stIndex){
            if(updateIndex < stL || updateIndex > stR)  // the current node's range is disjoint to the update index so do nothing and return current node
                return segTree[stIndex];
            if(stL == stR){ // the current node's range is the update index so update the node.
                Node leaf = new Node(updateValue);
                return segTree[stIndex] = leaf;
            }
            int mid = (stL + stR)/2;
            Node left = updateNode(stL,mid,updateValue,updateIndex,2*stIndex+1);
            Node right = updateNode(mid+1,stR,updateValue,updateIndex,2*stIndex+2);
            return segTree[stIndex] = merge(left,right);
        }
        public Node getNode(int stL,int stR,int l,int r,int stIndex){
            if(stL>r || l>stR)// the current node's range is disjoint to the query range , so don't consider current node
                return null;
            if(l<=stL && r>=stR)    // the current's node is range is completely covered by the query range.
                return segTree[stIndex];
            // merge answers of children
            int mid = (stL + stR)/2;
            Node left = getNode(stL,mid,l,r,2*stIndex+1);
            Node right = getNode(mid+1,stR,l,r,2*stIndex+2);
            return merge(left,right);
        }

    }

    private static void solve(int test) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        SegTree segTree = new SegTree(arr, n);
        while (q-- > 0) {
            int query = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            switch (query) {
                case 1:
                    segTree.updateNode(0, n - 1, y, x - 1, 0);
                    break;
                case 2:
                    System.out.println(Math.max(0, segTree.getNode(0, n - 1, x - 1, y - 1, 0).prefix));
            }
        }
    }
}
