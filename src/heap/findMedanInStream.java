package heap;
/**
 * *********************************************IMPORTANT**************************************
 * problem link : https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1/?track=SPC-Heap&batchId=154
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class findMedanInStream {
    // time complexity O(nlogn)
    // approach : make a max heap that contains smaller elements from current input element
    // and min heap that contains all greater elements than given number ,
    // if max heap size = min heap size return avg of both roots else return root of max heap
    static class FindMedian
    {
        static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        static PriorityQueue<Integer> min = new PriorityQueue<>();

        // Function to insert heap
        public static void insertHeap(int x)
        {
            if(max.isEmpty()){
                max.add(x);
                return;
            }
            if(max.size()==min.size() ){
                if(min.peek()<x){
                    max.add(min.poll());
                    min.add(x);
                }else max.add(x);
                return;
            }
            if(max.peek()>=x){
                min.add(max.poll());
                max.add(x);
                return;
            }

            min.add(x);

        }


        // function to getMedian
        public static double getMedian()
        {
            if(min.size()==max.size())
                return (min.peek()+max.peek())/2.0;
            return max.peek();
        }

    }
}
