/*
    created by: nitin23329
    on Date: 01/07/21
*/
package disjointSetUnionFind;

/**
 * In the naive implementation of DSU ,the find() take O(n) time
 * which indeed make the time of union() and isInSameSet() to  O(n) time
 */
class DSUNaive{
    private int [] parent;  //  keeps track of the parent node in the set.
    public DSUNaive(int n){
        parent = new int[n];    // 0-based indexing
        // initially each node is in a different set.
        for(int node=0;node<n;node++)
            makeSet(node);
    }
    // this function starts a new set by making the parent of new node the new node itself.
    private void makeSet(int node){
        parent[node] = node;
    }
    // this function find the representative of node z
    public int find(int z){
        while (parent[z] != z)z = parent[z];
        return z;
    }
    // this function merges the set to which x belongs and y belongs.
    public void union(int x,int y){
        x = find(x);    // find the representative of node x
        y = find(y);    // find the representative of node y
        // if both the node belongs to different node, their representative must be different
        if(x!=y)
            parent[y] = x;
    }
    // this function find whether the node x and y belongs to same set or not
    // if the belongs to same set, their representative must be same.
    public boolean isInSameSet(int x, int y){
        return find(x) == find(y);
    }
}

/**
 * In the efficient implementation of DSU by size, the find() takes O(logn)
 * which makes the time of union() and isInSameSet() O(logn)
 */
class DSUBySize{
    private int [] parent;  //  keeps track of the parent node in the set.
    private int [] size;    // this keeps track of the size of each set.
    public DSUBySize(int n){
        parent = new int[n];    // 0-based indexing
        size = new int[n];
        // initially each node is in a different set.
        for(int node=0;node<n;node++)
            makeSet(node);
    }
    // this function starts a new set by making the parent of new node as the new node itself.
    // as the set contains only 1 element, size = 1
    private void makeSet(int node){
        parent[node] = node;
        size[node] = 1;
    }
    // this function find the representative of node z
    // the height of each set can be at-most of order of O(logn)
    public int find(int z){
        while (parent[z] != z)z = parent[z];
        return z;
    }
    // this function merges the smaller size set to larger size set
    public void union(int x,int y){
        x = find(x);    // find the representative of node x
        y = find(y);    // find the representative of node y
        // if both the node belongs to different node, their representative must be different
        if(x!=y){
            if(size[y]>size[x]){
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
        }

    }
    // this function find whether the node x and y belongs to same set or not
    // if the belongs to same set, their representative must be same.
    public boolean isInSameSet(int x,int y){
        return find(x) == find(y);
    }
}
/**
 * In the efficient implementation of DSU by rank, the find() takes O(logn)
 * which makes the time of union() and isInSameSet() O(logn)
 * Here rank of a set means the height of set
 */
class DSUByRank{
    
    private int [] parent;  //  keeps track of the parent node in the set.
    private int [] rank;    // this keeps track of the height of each set.
    public DSUByRank(int n){
        parent = new int[n];    // 0-based indexing
        rank = new int[n];
        // initially each node is in a different set.
        for(int node=0;node<n;node++)
            makeSet(node);
    }
    // this function starts a new set by making the parent of new node as the new node itself.
    // as the set contains only 1 element, height = 1
    private void makeSet(int node){
        parent[node] = node;
        rank[node] = 0;
    }
    // this function find the representative of node z
    // the height of each set can be at-most of order of O(logn)
    public int find(int z){
        while (parent[z] != z)z = parent[z];
        return z;
    }
    // this function merges the smaller height set to larger height set
    public void union(int x,int y){
        x = find(x);    // find the representative of node x
        y = find(y);    // find the representative of node y
        // if both the node belongs to different node, their representative must be different
        if(x!=y){
            if(rank[x]>rank[y]) // height of x is more, hence merging the set y don't increase the height of set x
                parent[y] = x;
            else if(rank[x]<rank[y]) // height of y is more, hence merging the set x don't increase the height of set y
                parent[x] = y;
            else {  // height of x and y is same , merge any set to another and increase the height by 1
                parent[y] = x;
                rank[x]++;
            }
        }
    }
    // this function find whether the node x and y belongs to same set or not
    // if the belongs to same set, their representative must be same.
    public boolean isInSameSet(int x,int y){
        return find(x) == find(y);
    }
}
public class Implementation {
    public static void main(String[] args) {
        System.out.println("------DSU NAIVE IMPLEMENTATION------");
        DSUNaive dsuNaive = new DSUNaive(5);
        dsuNaive.union(0,2);
        System.out.println(dsuNaive.isInSameSet(0,2));
        System.out.println(dsuNaive.isInSameSet(3,4));
        dsuNaive.union(3,4);
        System.out.println(dsuNaive.isInSameSet(3,4));
        System.out.println(dsuNaive.isInSameSet(0,3));
        dsuNaive.union(4,2);
        System.out.println(dsuNaive.isInSameSet(0,3));

        System.out.println("------DSU BY SIZE IMPLEMENTATION------");
        DSUBySize dsuBySize = new DSUBySize(5);
        dsuBySize.union(0,2);
        System.out.println(dsuBySize.isInSameSet(0,2));
        System.out.println(dsuBySize.isInSameSet(3,4));
        dsuBySize.union(3,4);
        System.out.println(dsuBySize.isInSameSet(3,4));
        System.out.println(dsuBySize.isInSameSet(0,3));
        dsuBySize.union(4,2);
        System.out.println(dsuBySize.isInSameSet(0,3));

        System.out.println("------DSU BY RANK IMPLEMENTATION------");
        DSUByRank dsuByRank = new DSUByRank(5);
        dsuByRank.union(0,2);
        System.out.println(dsuByRank.isInSameSet(0,2));
        System.out.println(dsuByRank.isInSameSet(3,4));
        dsuByRank.union(3,4);
        System.out.println(dsuByRank.isInSameSet(3,4));
        System.out.println(dsuByRank.isInSameSet(0,3));
        dsuByRank.union(4,2);
        System.out.println(dsuByRank.isInSameSet(0,3));


    }
}
