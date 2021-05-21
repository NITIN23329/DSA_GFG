package greedy;

public class LargestNumberWithGivenSum {
    //approach 1 : O(n) time
    static String largestNumber(int n, int sum)
    {
        if(sum>9*n)return "-1";
        String ans = "";
        for(int i = 0;i<n;i++){
            if(sum>=9){
                ans+="9";
                sum-=9;
            }
            else{
                ans+=String.valueOf(sum);
                sum = 0;
            }
        }
        return ans;
    }
    //apporach 2 : efficient than upper one
    static String largestNumber2(int n, int sum)
    {
        if(sum>9*n)return "-1";
        String ans = "";
        int noOfNine = sum/9;
        for(int i = 0;i<noOfNine;i++)ans+="9";
        if(noOfNine==n)return ans;
        ans+=String.valueOf(sum - noOfNine*9);
        for(int i = 0;i<n-noOfNine-1;i++)ans+="0";
        return ans;
    }
}
