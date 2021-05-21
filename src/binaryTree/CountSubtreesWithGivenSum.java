package binaryTree;
// problem link : https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1/?track=PC-W6-T&batchId=154
// solution link : https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/
public class CountSubtreesWithGivenSum {
    // naive approach :
   //One way is to traverse the tree from top to bottom,
   // caluclate the sum of the subtree rooted at a particular node and check if the sum is equal to X.
   // If it is, incremenet your count. Else, move on to the next node and repeat the same.
   //This approach would be O(N^2) as you'll be separately calling for the subtree sum rooted
   // at each and every node
    class Tree
    {   int findSum(Node iter ){
            if(iter==null)return 0;
            return iter.data+findSum(iter.left)+ findSum(iter.right);
        }

        int countSubtreesWithSumX(Node root, int X)
        {
            if(root==null)return 0;
            Node iter =root;
            int ans = findSum(iter);
            if(ans==X){
                return 1 + countSubtreesWithSumX(root.left , X)+ countSubtreesWithSumX(root.right,X);
            }
            else
                return  countSubtreesWithSumX(root.left , X)+ countSubtreesWithSumX(root.right,X);
        }

    }
    // O(n) apprach
    // do post order traversal , and check if the current sum is given sum then increment counter.
    class TreeEffi
    {   int count ;
        int findSum(Node iter ,int X){
            if(iter==null)return 0;
            int leftSum = findSum(iter.left , X);
            int rightSum = findSum(iter.right ,X);
            int sum = leftSum+rightSum+iter.data;
            if(sum == X)count++;
            return sum ;
        }
        int countSubtreesWithSumX(Node root, int X)
        {   count = 0;
            findSum(root , X);
            return count;
        }
    }


}
