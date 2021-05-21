package recursion;
//problem link ;https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1/?track=DSASP-Recursion&batchId=154
public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(hanoi(6,'a','c','b'));
    }
    //the main idea is to move n-1 disks from a to b using c
    // and the move disk n from a to c and move n-1 disks from b to c using a
    // time complexity is : 2^n
    // no. of moves is 2^n-1
    public static long hanoi(int n, char from, char to, char aux) {
        if(n==1){
            System.out.println("move disk 1 from rod "+from+" to rod "+to);
            return 1L;
        }
        long a = hanoi(n-1,from,aux,to);
        System.out.println("move disk "+(n)+" from rod "+from+" to rod "+to);
        long b =  hanoi(n-1,aux,to,from);

        return a+b+1;
    }
}

