package binarySearchTree;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this(data,null,null);
    }
    public Node(int data, Node left ,Node right){
        this.data=data;
        this.left = left;
        this.right = right;
    }
}
