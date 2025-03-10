package greedy;
// problem link : https://leetcode.com/problems/car-pooling/
public class CarPooling {
    // time and space complexity : O(n)
/*
  approach : using prefix sum
  -->Let for every point, we can find # of passengers in car, if that is > capacity , we return false.
  --> How to find # of passengers for every point? We can use prefix sum technique.
  --> let say the points are represented by index of array.
  --> What we do is we add passenger to start point for every trip and we subtract passenger to end point of that trip.
        --> Why subtract at end point, to deboard or  balance off the passengers added at start point.
  --> Now if we take prefix sum, it will tell us the # of passengers for every point.
  ---> Let start point of a trip is 3 and end point is 6 and passengers count is 4 .
  --> So the array will initially look like
            point:             [...1,2,3,4,5,6,7,8....]
            passengerCount:    [...2,2,2,2,2,2,2,2....]
 --> Now we add 4 to start point at index 3
            point:             [...1,2,3,4,5,6,7,8....]
            passengerCount:    [...0,0,4,0,0,0,0,0....]
 --> Now we subtract 4 to end point at index 6
            point:             [...1,2,3,4,5,6, 7,8....]
            passengerCount:    [...0,0,4,0,0,-4,0,0....]
 --> To find  # of passengers for every point do a prefix sum
            point:             [...1,2,3,4,5,6,7,8....]
            passengerCount:    [...0,0,4,4,4,0,0,0....]
--> So at points 3,4,5, we have 4 passengers in car.
--> We do this for all trips and check at any point if prefix sum > capacity we return false otherwise true.

*/
        public boolean carPooling(int[][] trips, int capacity) {
            int lastEndPoint = 0;
            for(int[] trip : trips)lastEndPoint = Math.max(lastEndPoint,trip[2]);
            int[] passengerCount = new int[lastEndPoint+1];
            for(int[] trip:trips){
                int start = trip[1],end = trip[2];
                passengerCount[start] += trip[0];
                passengerCount[end]  -= trip[0];
            }
            int curr_capacity = 0;
            for(int i=0;i<=lastEndPoint;i++){
                curr_capacity += passengerCount[i];
                if(curr_capacity>capacity)return false;
            }
            return true;
        }
}
