package queue;

/* **********************************IMPORTANT**********************************************
 *
 * problem link: https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1/?track=DSASP-Queue&batchId=154
 * problem link : https://leetcode.com/problems/gas-station/
 * solution link : https://practice.geeksforgeeks.org/tracks/SPC-Queue/?batchId=154
 */

import java.util.Deque;
import java.util.LinkedList;


public class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {60,30,50,100};
        int[] distance = {40,60,100,50};
        System.out.println(tourEfficient(petrol,distance ));
    }
    static int tourEfficient(int[] petrol , int[] distance){
        // time complexity O(2n)
        // space comlexity O(n+1)
        // here we will store index in dq
        // maintain a sum variable the keeps track of remaining petrol
        // the idea is add each index to last of dq
        // remove from first until sum <0
        int n = distance.length;
        Deque<Integer> dq = new LinkedList<>();
        long sum = 0L;
      for(int i=0;;i++){
          sum+=petrol[i%n];
          sum-=distance[i%n];
          dq.addLast(i%n);
          while (!dq.isEmpty() && sum<0){
              int index = dq.pollFirst();
              sum-=petrol[index];
              sum+=distance[index];
          }
          if(dq.size()==n+1 && dq.peekLast().equals(dq.peekFirst()))break;
          if(dq.isEmpty() && i>2*n)return -1;
      }
      return dq.peekFirst();
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // time : O(n), space O(1)
        /*
            --> approach :
                --> Suppose we start at index i and suppose the first index which we can not reach from i is j.
                --> Then if we start from any index i+1 to j, we can not pass the jth index.Why?
                --> Cuz our currGas is always >=0 and it might have more gas if we started from a previous index.
                --> Then we again start from j+1 and try to cover a circle.
                --> If we can not reach an index j< start index, then there is no way we can complete our tour.Why?
                --> Cuz our new startIndex is j+1 <= startIndex and we have already consider it.
         */
        int currIndex = 0;
        int currGas = 0;
        int startIndex = 0;
        int n = gas.length;
        while(true){
            if(currIndex>=n && currIndex%n == startIndex)
                return startIndex;
            currGas += gas[currIndex%n];
            currGas -= cost[currIndex%n];
            if(currGas<0){
                if(currIndex%n<startIndex)break;
                startIndex = currIndex+1;
                currGas = 0;
                currIndex = startIndex;
            }else currIndex++;
        }
        return -1;
    }

}
