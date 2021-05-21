package recursion;
//problem link :  https://leetcode.com/problems/generate-parentheses/
import java.util.ArrayList;

public class GenerateBalancedParanthesis {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> list = new ArrayList<>();
        generate(list,n,"",0,0);
        System.out.println(list);
    }
    //curr is the current string formed so far in a recursive call
    //usedOpen is the number of "(" used so far in a recursive call
    //currOpen is the number of "(" for which ")" is not present so far
    //time compexity : 2^(n) // for 1 to n we have 2 recursive calls then only 1 recursive call for n+1 to 2n
    private static void generate(ArrayList<String>list ,int n,String curr , int usedOpen,int currOpen){
        if(curr.length()==2*n){
            list.add(curr);
            return;
        }
        // if we used all n  "(" then we have only ")" to use
        if(usedOpen==n){
            generate(list,n,curr+")",usedOpen,currOpen-1);
        }
        // if the current string is balanced the we can only use "(" otherwise it will become imbalanced
        else if(currOpen==0){
            generate(list,n,curr+"(",usedOpen+1,currOpen+1);
        }
        // we can add "(" or ")"
        else{
            generate(list,n,curr+"(",usedOpen+1,currOpen+1);
            generate(list,n,curr+")",usedOpen,currOpen-1);
        }

    }
}
