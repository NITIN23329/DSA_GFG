/*
    created by: nitin23329
    on Date: 21/06/21
*/

/**
 *  problem link : https://www.spoj.com/problems/GSS5/
 *  Epic problem ......:)
 */
package segmentTrees;

import java.util.Scanner;

public class GSS5 {
    static class Node{
        int prefix;
        int suffix;
        int full;
        int max;
        public Node(int init) {
            prefix = suffix = full = max = init;
        }
        public Node() {
            this(0);
        }
    }
    static class SegTree{
        Node[] segTree;
        int[] arr;
        int n;
        public SegTree(int[] arr,int n) {
            this.arr = arr;
            this.n = n;
            segTree = new Node[4*n];
            createSegTree(0,n-1,0);
        }
        private Node merge(Node left,Node right){
            if(left==null)return right; // these 2 null check lines were added cuz of the getNode()
            if(right==null)return left;
            Node parent = new Node();
            parent.full = left.full + right.full;
            parent.max = max3(left.max,right.max, left.suffix + right.prefix);
            parent.prefix = max2(left.prefix,left.full + right.prefix);
            parent.suffix = max2(right.suffix, right.full+ left.suffix);
            return parent;
        }
        private Node createSegTree(int stL,int stR,int stIndex){
            if(stL == stR){
                Node leaf = new Node(arr[stL]);
                return segTree[stIndex] = leaf;
            }
            int mid = (stR - stL)/2 + stL;
            Node left = createSegTree(stL,mid,2*stIndex+1);
            Node right = createSegTree(mid+1,stR,2*stIndex+2);
            return segTree[stIndex] = merge(left,right);
        }
        public Node getNode(int stL,int stR,int l,int r,int stIndex){
            if(l>stR || r<stL)return null;
            if(l<=stL && r>=stR)return segTree[stIndex];
            int mid = (stR - stL)/2 + stL;
            Node left = getNode(stL,mid,l,r,2*stIndex+1);
            Node right = getNode(mid+1,stR,l,r,2*stIndex+2);
            return merge(left,right);
        }
    }
    private static void solve(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        SegTree segTree = new SegTree(arr,n);
        int q = sc.nextInt();
        while (q-->0){
            int x1 = sc.nextInt()-1;
            int y1 = sc.nextInt()-1;
            int x2 = sc.nextInt()-1;
            int y2 = sc.nextInt()-1;
            if(y1<x2){  // case both segments are non overlapping
                Node betweenSegment;
                betweenSegment = segTree.getNode(0,n-1,y1,x2,0);
                Node leftSegment = x1==y1?new Node():segTree.getNode(0,n-1,x1,y1-1,0);
                Node rightSegment = x2==y2?new Node():segTree.getNode(0,n-1,x2+1,y2,0);
                // ans = take all elements in between Segment, take max suffix of left segment and take max prefix of right segment if profitable
                System.out.println(betweenSegment.full + max2(0,leftSegment.suffix) + max2(0,rightSegment.prefix));
            }
            else {  // case both segments are overlapping
                Node overlap = segTree.getNode(0,n-1,x2,y1,0);
                int c1 = overlap.max;   // we take max subarray in overlapping segment only
                Node leftSegment =  x1==x2?new Node() : segTree.getNode(0,n-1,x1,x2-1,0);
                Node rightSegment = y1==y2?new Node(): segTree.getNode(0,n-1,y1+1,y2,0);
                // we take suffix of left segment and prefix of overlap segment
                int c2 = leftSegment.suffix + overlap.prefix;
                // we take suffix of overlap segment and prefix of right segment
                int c3 = overlap.suffix + rightSegment.prefix;
                // we take full overlapping segment and take left suffix and right prefix
                int c4 = leftSegment.suffix + overlap.full + rightSegment.prefix;
                System.out.println(max2(max2(c1,c2),max2(c3,c4)));
            }
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static int max3(int a, int b, int c) { return max2(max2(a, b), c); }
    public static int max2(int a, int b) { return Math.max(a, b); }
}
