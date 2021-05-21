package avlTree;

import java.util.TreeSet;
// It is a Tree Data Structure that implements AVL tree
public class TreeSetImplementation {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        //insertion takes O(logn)
        // all elements must be distinct
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(9);
        treeSet.add(4);
        treeSet.add(-9);
        treeSet.add(24);
        System.out.println(treeSet);
        for(int ele : treeSet) System.out.println(ele);
        treeSet.remove(9);
        System.out.println(treeSet);
        System.out.println(treeSet.first()+" "+treeSet.last());
        System.out.println(treeSet.floor(8));
        System.out.println(treeSet.ceiling(-3));
        System.out.println(treeSet.headSet(5));
        System.out.println(treeSet.tailSet(5));
        System.out.println(treeSet.subSet(-9 , 5));
        System.out.println(treeSet.contains(24));
    }
}
