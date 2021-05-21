package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//priblem link : https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1/?track=SPC-Stack&batchId=154
//solution link : https://www.geeksforgeeks.org/the-celebrity-problem/
public class celeribityProblem {
    int getIdNaive(int arr[][], int n)
    {   //time complexity O(n^2)
        // space complexity O(n)
        Map<Integer,Integer> map = new HashMap<>(n);
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1)
                    if(map.containsKey(i))
                        map.put(i,map.get(i)+1);
                    else
                        map.put(i,1);
            }
        }
        if(map.size()==0)return -1;
        for(int key = 0;key<n;key++)
            if(map.containsKey(key)==false)return key;

        return -1;
    }
    int getId(int arr[][], int n)
    {
        //O(n) time complexity
        //O(n) space compelxity
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--)st.push(i);
        while(!(st.size()<=1)){
            int a = st.pop();
            int b = st.pop();
            if(arr[b][a]==1 && arr[a][b]==1)continue;
            if(arr[a][b]==1)st.push(b);
            if(arr[b][a]==1)st.push(a);
        }
        if(st.isEmpty()==true)return -1;
        int x = st.pop();
        for(int i=0;i<n;i++)
            if(x!=i && arr[x][i]==1)return -1;
        for(int i=0;i<n;i++)
            if(x!=i && arr[i][x]==0)return -1;
        return x;
    }
}
