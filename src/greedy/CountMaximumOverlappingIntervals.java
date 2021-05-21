package greedy;
// problem link : https://cses.fi/problemset/task/1619/
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CountMaximumOverlappingIntervals {
    /*
   --> Approach : greedy  with time O(nlogn)
   --> Sort all meetings in increasing order of start time, this will club overlapping meetings together.
   --> Then create a pq in which meeting having shortest end time is at top
   --> Then for a particular meeting remove all meetings from pq whose end time < start time of current meeting.
   --> Then all remaining meeting are overlapping with current meetings.

   */
    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> arr = new ArrayList<>();
        for(int i=0;i<n;i++)arr.add(new int[]{sc.nextInt(), sc.nextInt()});
        arr.sort((a,b)->(a[0]-b[0])); // we sort according to start date as it will keep overlapping meeting together.
        // having meetings with smaller end date first so that we can remove all non overlapping meetings
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        int max = 0;
        for(int i=0;i<n;i++){
            // remove all non-overlapping intervals with ith meeting
            while (!pq.isEmpty() && pq.peek()[1]<arr.get(i)[0])pq.poll();
            pq.add(arr.get(i));
            max = Math.max(pq.size(),max);  // pq.size() is the # of meeting overlapping with each other
        }
        System.out.println(max);

    }
}
