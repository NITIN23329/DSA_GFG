/*
    created by: nitin23329
    on Date: 01/07/21
*/
package disjointSetUnionFind;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem link : https://cses.fi/problemset/task/1676/
 */
public class RoadConstructionCSES {
    static class DSU{
        int [] parent,size;
        int totalComponents;
        int maxSizeComponent;
        // initialization takes O(n) time
        public DSU(int n){
            parent = new int[n+1];  // 1-based indexing
            size = new int[n+1];
            for(int i=1;i<=n;i++)
                makeSet(i);
        }
        public void makeSet(int x){
            parent[x] = x;
            size[x] = 1;
            totalComponents++;
        }
        // find() take O(logn) time
        public int find(int x){
            while (x != parent[x])x = parent[x];
            return x;
        }
        // union() takes O(logn) time
        public void union(int x,int y){
            x = find(x);
            y = find(y);
            if(x==y)return;
            // merge smaller component into larger component.
            if(size[x]>=size[y]){
                parent[y] = x;
                size[x] += size[y];
            }
            else {
                parent[x] = y;
                size[y] += size[x];
            }
            totalComponents--;
            maxSizeComponent = max3(maxSizeComponent,size[x],size[y]);
        }
        // isInSameSet() take O(logn)
        public boolean isInSameSet(int x,int y){
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DSU dsu = new DSU(n);
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            dsu.union(x,y);
            System.out.println(dsu.totalComponents+" "+dsu.maxSizeComponent);
        }

    }
    public static int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
