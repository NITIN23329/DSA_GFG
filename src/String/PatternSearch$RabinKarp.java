package String;
//solution link : https://www.youtube.com/watch?v=qQ8vS2btsxI
// problem link : https://practice.geeksforgeeks.org/problems/rabin-karp-pattern-searching/1/?track=SPC-Strings&batchId=154
public class PatternSearch$RabinKarp {
    public static void main(String[] args) {
        String parent = "abcdef";
        String child="def";
        System.out.println("robin karp primitive :");
        rabinKarpPrimitive(parent,child);
        System.out.println("robin karp advanced : ");
        rabinKarpAdvanced(parent,child);
    }
    public static void rabinKarpPrimitive(String str,String find){
        //find hashCode of find String
        // in this we find rolling hash of str and compare it with hash of find String..
        // if match then we compare every character of that window with find String..
        //else slide by one
        // worst case happens when there are different permutation of find string(spurious hit)
        // although hash od both sliding window and find is same but they are not same
        // eg str: 'cbacbacba' and find : 'abc' time complexity worst case O((n-m+1)*m)
        // relatively faster than naive algoritm
        int hashCode_find = 0;
       for(int i=0;i<find.length();i++)
           hashCode_find+=find.charAt(i);
       int rolling_hashCode = 0;
       for(int i=0;i<find.length();i++)rolling_hashCode+=str.charAt(i);
       // handling first case explicitly
       if(rolling_hashCode==hashCode_find){
            int i;
            for(i=0;i<find.length();i++)
                if(str.charAt(i)!=find.charAt(i))break;;
            if(i==find.length()) System.out.println(0);
       }
       for(int i=1;i<=str.length()-find.length();i++){
           rolling_hashCode+=str.charAt(i+find.length()-1)-str.charAt(i-1);
           if(rolling_hashCode==hashCode_find){
               int j;
               for ( j=0;j<find.length();j++)
                   if (str.charAt(i + j) != find.charAt(j)) break;
               if(j==find.length())
                   System.out.println(i);

           }
       }
    }
    public static void rabinKarpAdvanced(String str,String find){
        // this code will reduces spurious hit and hence reduce probability of getting worst case
        // improved hashing technique
        // average case time : O(n+m)
        // worst case time :O(nm)
        final int d = 3;
        final int mod = 13;
        int hashCode_find = 0;
        for(int i=0;i<find.length();i++)
            hashCode_find = (hashCode_find+ (find.charAt(i)-96)*(int)Math.pow(d,i))%mod;
        int rolling_hashCode = 0;
        for(int i=0;i<find.length();i++)
            rolling_hashCode=(rolling_hashCode+(str.charAt(i)-96)*(int)Math.pow(d,i))%mod;
        if(rolling_hashCode==hashCode_find){
            int i;
            for(i=0;i<find.length();i++)
                if(str.charAt(i)!=find.charAt(i))break;;
            if(i==find.length()) System.out.println(0);
        }
        //System.out.println(hashCode_find);
        for(int i=1;i<=str.length()-find.length();i++){
            rolling_hashCode = ( (rolling_hashCode-(str.charAt(i-1)-96)*(int)Math.pow(d,0))/d + (str.charAt(i+find.length()-1)-96)*(int)Math.pow(d,find.length()-1))%mod;
           // System.out.println(rolling_hashCode+" roll");
            if(rolling_hashCode==hashCode_find){
                int j;
                for ( j=0;j<find.length();j++)
                    if (str.charAt(i + j) != find.charAt(j)) break;
                if(j==find.length())
                    System.out.println(i);

            }
        }
    }
}
