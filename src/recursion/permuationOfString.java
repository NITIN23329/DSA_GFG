package recursion;
//problem link : https://practice.geeksforgeeks.org/problems/permutation-with-spaces/0
import java.util.*;

public class permuationOfString {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int testCase=sc.nextInt();
        sc.nextLine();
        while(testCase-->0){
            String str=sc.nextLine();
            Set<String> list =new HashSet<>();
            func("",list,str,0);
            ArrayList<String> arr = new ArrayList<>(list);
            Collections.sort(arr);
            for( String ele: arr)
                System.out.print(ele +" ");
            System.out.println();
        }
    }
    public static void func(String curr,Set<String> list,String str,int index){
        if(index>=str.length()){
            list.add(curr);
            return;
        }
        for(int i=0;i<curr.length()+1;i++)
            func(curr.substring(0,i)+str.charAt(index)+curr.substring(i),list,str,index+1);
        //func(str.charAt(index)+curr,list,str,index+1);

    }
}
// another approach using I/P - O/P method
class temp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase  = sc.nextInt();
        sc.nextLine();
        while (testcase-->0){
            String str = sc.nextLine();
            ArrayList<String > list = new ArrayList<>();
            addSpaces(list,str.substring(1) ,str.charAt(0)+"" );
            Collections.sort(list);
            for(String ele : list)
                System.out.print("("+ele+")");
            System.out.println();
        }
    }

    private static void addSpaces(ArrayList<String> list, String str, String curr) {
        if(str.isEmpty()){
            list.add(curr);
            return;
        }
        addSpaces(list,str.substring(1),curr+" "+str.charAt(0));
        addSpaces(list,str.substring(1),curr+str.charAt(0));;
    }
}