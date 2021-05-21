package recursion;

//problem link : https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/?currentPage=1&orderBy=hot&query=

public class KthSymbolInGrammer {
    public static void main(String[] args) {
        int n = 4;
        int k = 7;
        System.out.println(find(n,k));
    }
    //use IBH(induction base hypothesis) method
    //a intuitive solution is that find bit from which final answer is derived, if it was 0 then we replace it
    //with 01 else 10 .now see that if x==0 then check if k is even . if yes then answer is 1 else 0. similar
    //approach for x==1 also.
    private static int  find(int n,int k){
        if(n==1 )
            return 0;
        int x =  find(n-1 , (k+1)/2);
        if(x==0) {
            if (k % 2 == 1)
                return 0;
            return 1;
        }
        else   {
            if(k%2==1)
                return 1;
            return 0;
        }
    }
    //another approach :
   // https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
}
