package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1/?track=PC-W6-T&batchId=154
public class MaxPathSum {
    class Tree
    {
        int max ;
        int findMaxSum(Node iter)
        {
            max = -99999;
            helpr(iter);
            return max;
        }
        int helpr(Node iter){
            if(iter==null)return 0;
            int maxLeft = helpr(iter.left);
            int max1 = Math.max(maxLeft+iter.data,iter.data);
            int maxRight = helpr(iter.right);
            int max2 = Math.max(maxRight+iter.data , iter.data);
            max = Math.max(max , Math.max(maxLeft+maxRight + iter.data,Math.max(max1,max2)));
            return Math.max(max1 , max2);
        }
    }

}
