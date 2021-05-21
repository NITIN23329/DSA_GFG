package recursion;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
// time complexuit is : 2^n;
public class SubSeqOfString {
    public static void main(String[] args) {
        String str="1234";
        Set<String> list=new HashSet<>();
        distinctSubSeq("",list,str);
        System.out.println(list);
        ArrayList<String > arrayList=new ArrayList<>();
        subSeq("",arrayList,str);
        
    }
    public static void distinctSubSeq(String curr, Set<String> stringArrayList, String orgional){
        if(orgional.isEmpty())return;
        stringArrayList.add(curr);
        stringArrayList.add(curr+orgional.charAt(0));
       distinctSubSeq(curr,stringArrayList,orgional.substring(1));
       distinctSubSeq(curr+orgional.charAt(0),stringArrayList,orgional.substring(1));

    }
    public static void subSeq(String curr, ArrayList<String> stringArrayList, String orgional){
        if(orgional.isEmpty()){
            stringArrayList.add(curr);
            System.out.println(curr);
            return;
        }
        subSeq(curr,stringArrayList,orgional.substring(1));
        subSeq(curr+orgional.charAt(0),stringArrayList,orgional.substring(1));

    }
}
