/*
    created by: nitin23329
    on Date: 17/06/21
*/
package segmentTrees;

import java.util.Arrays;
class Main{
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20 ,30 ,40, 50, 60};
        SumSegmentTrees segmentTrees = new SumSegmentTrees(arr);
        System.out.println(Arrays.toString(segmentTrees.segmentTreeArray));
        System.out.println(segmentTrees.getSum(1,3));
        System.out.println(segmentTrees.getSum(0,5));
        System.out.println(segmentTrees.getSum(0,2));
        System.out.println(segmentTrees.getSum(4,5));
        System.out.println(segmentTrees.getSum(5,5));

        segmentTrees.updateIndex(2,-10);
        System.out.println(Arrays.toString(segmentTrees.segmentTreeArray));

        System.out.println(segmentTrees.getSum(1,3));
        System.out.println(segmentTrees.getSum(0,5));
        System.out.println(segmentTrees.getSum(0,2));
        System.out.println(segmentTrees.getSum(4,5));
        System.out.println(segmentTrees.getSum(5,5));

    }
}
class SumSegmentTrees {
    public int [] segmentTreeArray;
    public int n;
    public SumSegmentTrees(int[] arr){
        this.n = arr.length;
        int level = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
        segmentTreeArray = new int[(1<<level)-1];
        Arrays.fill(segmentTreeArray,-1);
        createSegmentTree(0,n-1,arr,0);
    }
    // time : O(n)
    private int createSegmentTree(int stL,int stR,int[] arr,int stIndex){
        if(stL==stR){   // reaches a leaf node
            segmentTreeArray[stIndex] = arr[stL];
            return segmentTreeArray[stIndex];
        }
        int mid = (stR-stL)/2 + stL;
        int leftSubTree = createSegmentTree(stL,mid,arr,2*stIndex+1);
        int rightSubTree =  createSegmentTree(mid+1,stR,arr,2*stIndex+2);
        segmentTreeArray[stIndex] = leftSubTree + rightSubTree;
        return segmentTreeArray[stIndex];   // return sum of children
    }

    // time : O(logn)
    public int getSum(int l,int r){return getSumHelper(0,n-1,l,r,0);}
    private int getSumHelper(int stL,int stR,int l,int r,int stIndex){
        if(l>stR || r<stL)  // case 1 , query is entirely disjoint from current node's range
            return 0;
        if(l<=stL && r>=stR)    // case 2, query covers the node fully
            return segmentTreeArray[stIndex];
        int stMid = (stR - stL)/2 + stL;
        // case 3 : query intersects with current node but doesn't fully cover, ask children
        return getSumHelper(stL,stMid,l,r,2*stIndex+1)
                + getSumHelper(stMid+1,stR,l,r,2*stIndex+2);

    }
    // time : O(logn)
    public void updateIndex(int updateIndex,int newValue){updateIndexHelper(0,n-1,updateIndex,newValue,0);}
    private int updateIndexHelper(int stL,int stR,int updateIndex,int newValue,int stIndex){
        //case 1: update index is disjoint from current node's range
        if(updateIndex<stL || updateIndex>stR)
            return segmentTreeArray[stIndex];   // no change
        // case2: we have reached to the leaf node which was meant to be updated and return the difference
        if(updateIndex == stL && updateIndex==stR){
            segmentTreeArray[stIndex] = newValue;   // update the node value
            return newValue;    // return updated value
        }
        // update the current node's value
        int stMid = (stR - stL)/2 + stL;
        int updatedLeftSubtree = updateIndexHelper(stL,stMid,updateIndex,newValue,2*stIndex+1);
        int updatedRightSubtree = updateIndexHelper(stMid+1,stR,updateIndex,newValue,2*stIndex+2);
        return segmentTreeArray[stIndex] = updatedLeftSubtree + updatedRightSubtree;
    }
}
