/*
    created by: nitin23329
    on Date: 20/06/21
*/
package segmentTrees;
import java.util.Scanner;



// problem link : https://www.spoj.com/problems/GSS3/

public class GSS3 {
    static class Node{
        int max;        // contains the maximum sum subarray in node's range
        int prefix;     // contains maximum prefix
        int suffix;     // contains maximum suffix
        int full;       // contains total sum for node's range
        public Node() {
            max = prefix = suffix = full = 0;
        }
    }
    static Node[] segTree;
    static int[] arr;
    private static Node merge(Node left, Node right){
        if(left==null)return right;
        if(right==null)return left;
        Node parent = new Node();
        // take total sum of left and right child to get total sum for parent node.
        parent.full = left.full + right.full;
        // parent's max is max of children and left child's suffix + right child's prefix.
        parent.max = max3(left.max,right.max,left.suffix + right.prefix);
        // parent's prefix is max of left child's prefix, total of parent sum, and left child's total + right child's prefix
        parent.prefix = max3(left.prefix,parent.full,left.full+right.prefix);
        // parent's suffix is max of right child's suffix, total of parent sum, and right child's total + left child's suffix
        parent.suffix = max3(right.suffix, parent.full,right.full + left.suffix);
        return parent;
    }
    private static Node createTree(int stL,int stR,int stIndex){
        if(stL == stR){
            Node leaf = new Node();
            leaf.max = leaf.prefix = leaf.suffix = leaf.full = arr[stL];
            return segTree[stIndex] = leaf;
        }
        int mid = (stL + stR)/2;
        Node left = createTree(stL,mid,2*stIndex+1);
        Node right = createTree(mid+1,stR,2*stIndex+2);
        return segTree[stIndex] = merge(left,right);
    }
    private static Node  getNode(int stL,int stR,int l,int r,int stIndex){
        if(stL>r || stR<l){     // case 1 : current node's range is disjoint to query range.
            return null;
        }
        if(l<=stL && r>=stR)    // case 2 : current node's range is covered by query range.
            return segTree[stIndex];
        // case 3 : combine answer of both children
        int mid = (stL + stR)/2;
        Node left = getNode(stL,mid,l,r,2*stIndex+1);
        Node right = getNode(mid+1,stR,l,r,2*stIndex+2);
        return merge(left,right);
    }
    private static Node updateNode(int stL,int stR,int updateIndex,int updateValue,int stIndex){
        if(stL>updateIndex || stR<updateIndex)return segTree[stIndex];
        if(stL == stR){
            Node leaf = new Node();
            leaf.max = leaf.prefix = leaf.suffix = leaf.full = updateValue;
            return segTree[stIndex] = leaf;
        }
        int mid = (stL + stR)/2;
        Node left = updateNode(stL,mid,updateIndex,updateValue,2*stIndex+1);
        Node right = updateNode(mid+1,stR,updateIndex,updateValue,2*stIndex+2);
        return segTree[stIndex] = merge(left,right);
    }
    private static void solve(){
        int n = sc.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++)arr[i] =sc.nextInt();
        segTree = new Node[4*n];
        createTree(0,n-1,0);
        int q = sc.nextInt();
        while (q-->0){
            int oprn = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(oprn == 0)updateNode(0,n-1,x-1,y,0);
            else {
                Node ans = getNode(0,n-1,x-1,y-1,0);
                System.out.println(ans.max);
            }

        }

    }
    static Scanner sc = new Scanner(System.in);
    public static int max3(int a, int b, int c) { return max2(max2(a, b), c); }
    public static int max2(int a, int b) { return Math.max(a, b); }
}
