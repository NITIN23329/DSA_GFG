package greedy;
//problem link : https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1/?track=SPC-Greedy&batchId=154
// same algo problem : https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1/?track=DSASP-Greedy&batchId=154
import java.util.Arrays;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3 ,2 ,5};
        int[] end ={2 ,4, 3, 6};
        System.out.println(activitySelection(start , end , 4));
    }
    //approach : sort according to end time
    // consider non overlapping activities
    //start with that activity which has smallest finish time.
    //time complexity O(nlogn)
    public static int activitySelection(int[] start, int[] end, int n)
    {
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr,(a,b)->(a[1] - b[1]));
        int count = 0;
        int currTime = 0;
        for(int i=0;i<n;i++){
            if(currTime<arr[i][0]){
                count++;
                currTime = arr[i][1];
            }
        }
        return count;
    }

}
