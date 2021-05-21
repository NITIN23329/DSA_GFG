package stack;
// problem link : https://leetcode.com/problems/maximal-square/
import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalSquare {
    // approach 1 : using stack
    // time complexity O(mn) , space complexity O(n) where m= # of row and n = # of columns
    // this solution can be done using the MAXIMAL SOLUTION APPROACH
    //which can be solved using largest rectangle in a histogram solution
    //Note : in case of maximal rectangle problem, we found area = height * width of largest rectangle for each i in 0 to n-1
    //here we will find side = min(height,width), area = side*side for each i in 0 to n-1.
        public int maximalSquare(char[][] matrix) {
            int n = matrix[0].length;
            int m = matrix.length;
            int[] hist = new int[n];
            int ans = 0;
            for(int row=0;row<m;row++){
                for(int col=0;col<n;col++)
                    hist[col] += matrix[row][col]=='1'? 1 : -hist[col];
                ans = Math.max(ans,histogram(hist,n));
            }
            return ans;
        }
        private int histogram(int[] hist,int n){
            int[] minRightIndex = new int[n];
            int[] minLeftIndex = new int[n];
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i=n-1;i>=0;i--){
                while(!dq.isEmpty() && hist[dq.peek()]>=hist[i])
                    dq.pop();
                minRightIndex[i] = dq.isEmpty()? n :dq.peek();
                dq.push(i);
            }
            dq = new ArrayDeque<>();
            for(int i=0;i<n;i++){
                while(!dq.isEmpty() && hist[dq.peek()]>=hist[i])
                    dq.pop();
                minLeftIndex[i] = dq.isEmpty()? -1 : dq.peek();
                dq.push(i);
            }
            int ans = 0;
            for(int i=0;i<n;i++){
                int width = minRightIndex[i]-i+i-minLeftIndex[i]-1;
                int height = hist[i];
                int side = Math.min(width,height);
                ans = Math.max(ans,side*side);
            }
            return ans;
        }
}
