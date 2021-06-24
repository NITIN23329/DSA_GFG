/*
    created by: nitin23329
    on Date: 18/06/21
*/
package segmentTrees;
// problem link : https://codeforces.com/contest/380/problem/C
import java.util.Scanner;

public class CorrectBracketSubsequenceLength {
    static class Node{  // data which will be stored in each node
        int matched,open,close;
        public Node(){matched = open = close = 0;}
    }

    private static Node getCorrectBracketCount(int currNodeL,int currNodeR,int l,int r,int currNodeIndex,Node[] segTree){
        if(r<currNodeL || currNodeR<l)return new Node(); // case 1: query range is disjoint to curr node's range
        if(l<= currNodeL && r>= currNodeR) return segTree[currNodeIndex];   // case 2 : query range covers current node's index
        int mid = (currNodeL+currNodeR)/2;
        // case 3 : ask children of answer and merge their answer
        Node leftNode = getCorrectBracketCount(currNodeL,mid,l,r,2*currNodeIndex+1,segTree);
        Node rightNode = getCorrectBracketCount(mid+1,currNodeR,l,r,2*currNodeIndex+2,segTree);
        return mergeChildren(leftNode,rightNode);
    }
    private static Node mergeChildren(Node left,Node right){
        Node node = new Node();
        // some of left node's open brackets will be merged with some of right node's close bracket
        int currMatched = Math.min(left.open,right.close);
        node.matched = currMatched + left.matched + right.matched;
        // all the merged open bracket's take no part in further merge process
        node.open = left.open + right.open - currMatched;
        // all the merged close bracket's take no part in further merge process
        node.close = left.close + right.close - currMatched;
        return node;
    }
    private static Node createSegTree(int currNodeL,int currNodeR,int currNodeIndex,Node[] segTree,char[] str){
        if(currNodeL == currNodeR){ //reached a leaf node
            Node node = new Node();
            if(str[currNodeL] == ')')node.close = 1;
            else node.open = 1;
            return segTree[currNodeIndex] = node;
        }
        int mid = (currNodeL+currNodeR)/2;
        Node leftNode = createSegTree(currNodeL,mid,2*currNodeIndex+1,segTree,str);
        Node rightNode = createSegTree(mid+1,currNodeR,2*currNodeIndex+2,segTree,str);
        return segTree[currNodeIndex] = mergeChildren(leftNode,rightNode);
    }
    private static void solve(){
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int n = str.length;
        Node [] segTree = new Node[4*n];
        createSegTree(0,n-1,0,segTree,str);
        int q = sc.nextInt();
        while (q-->0){
            int l = sc.nextInt()-1;
            int r = sc.nextInt()-1;
            Node ans = getCorrectBracketCount(0,n-1,l,r,0,segTree);
            System.out.println(ans.matched*2); // print length of correct bracket
        }
    }
}
