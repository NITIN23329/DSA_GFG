package heap;
/**
 * **************************************IMPORTANT***********************************
 * problem link : https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1/?track=SPC-Heap&batchId=154
 */

import java.util.*;

public class mergeKSortedArrays {
    //naive approach
    // my approach ; make a min heap on basis of lengths of arrays , take 2 shortest length arrays ,
    // merge them and put back to min heap until there a single final array is left;
    //time complexity O(nklog k) ; n = size of array , k is number of arrays
    //Space Complexity: O( nklog k).
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k)
    {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1.length - o2.length;
            }
        });
        for(int i = 0;i<k;i++){
            Integer[] temp = new Integer[arrays[i].length];
            for(int j = 0;j<arrays[i].length ; j++)temp[j] = arrays[i][j];
            pq.add(temp);
        }
        while(pq.size()!=1){
            Integer[] a = pq.poll();
            Integer[] b= pq.poll();
            pq.add(merge(a , b));
        }
        Integer[] temp = pq.poll();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(temp));
        return list;

    }
    private static Integer[] merge(Integer[] a  , Integer[] b ){
        Integer[] temp = new Integer[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                temp[k++] =a[i++];
            }
            else temp[k++] = b[j++];
        }
        while(i<a.length)temp[k++] = a[i++];
        while(j<b.length)temp[k++] = b[j++];
        return temp;
    }


    /**
     * // efficient approach
     * //time complexity O(nklog k) ; n = size of array , k is number of arrays
     * // space complexity O(k + nk) k is used of min heap and nk to store result
     * APPROACH:
     *
     * 1. Create an output array.
     * 2. Create a min heap of size k and insert 1st element in all the arrays into the heap
     * 3. Repeat following steps while priority queue is not empty.
     * a) Remove minimum element from heap (minimum is always at root) and store it in output array.
     * b) Insert next element from the array from which the element is extracted. If the array doesn’t have any more elements, then do nothing.
     */
    class Solution{
         class data{
            int index;
            int[] arr;
            public data(int[] arr  ){
                this.arr = arr;
                this.index = 0;
            }
            public void update(){
                index++;
            }
        }
        public  ArrayList<Integer> mergeKArrays(int[][] arrays,int k)
        {
            PriorityQueue<data> pq = new PriorityQueue<>(new Comparator<data>() {
                @Override
                public int compare(data d1, data d2) {
                    return d1.arr[d1.index] - d2.arr[d2.index];
                }
            });
            for(int i = 0;i<k;i++){
                data d = new data(arrays[i]);
                pq.add(d);

            }
            ArrayList<Integer> list = new ArrayList<>();
            while(!pq.isEmpty()){
                data d = pq.poll();
                list.add(d.arr[d.index]);
                d.update();
                if(d.index<k)
                    pq.add(d);
            }
            return list;
        }
    }

}
