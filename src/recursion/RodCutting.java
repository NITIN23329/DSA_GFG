package recursion;
// time compexity is : 3^n
public class RodCutting {
    public static void main(String[] args) {
        int n = 423;
        int a = 45, b = 12, c = 34;
        System.out.println(rod(n,a,b,c));
    }
    public static int rod(int n,int a,int b,int c){

        if(n<0)return -1;
        if(n==0)return 0;
        int x= rod(n-a,a,b,c);
        int y=rod(n-b,a,b,c);
        int z=rod(n-c,a,b,c);
        int max=Math.max(Math.max(x,y),z);
        if(max==-1)return -1;
        return 1+max;
    }
}
