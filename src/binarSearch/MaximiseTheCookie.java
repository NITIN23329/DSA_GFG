package binarSearch;
/**
 * problem link : http://foobar.iiitd.edu.in/domjudge/team/problem.php?id=744
 * problem code : PS51C
 */

import java.util.Scanner;
// time complexity O(nlogn)
/*
    approach :
           --> find out upper bound for maximum cookie. if we take it as (int)1e9, gives TLE
               --> for a particular ingredient ,what we do is we use all special ingredient along with given ingredient
                to make cookies and assuming all other ingredients has infinite amount. Find this for all ingredients and take min of it to get upper bound.
           -->  do a binary search from 0 to upper bound we found in previous step.
           --> let mid be the # of cookies we want to make
           --> if we can not make mid # of cookies using special ingredients and given ingredients, i.e. we are short of ingredients hence goto left part in bs
           --> if we can make mid # of cookies, we check can we make mid+1 # of cookies also ?
                    --> of yes goto to right part of bs
                    --> else mid is the maximum # of cookies we can make
 */
public class MaximiseTheCookie   {

    public static void main(){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k = sc.nextInt();
        int[] reqdArray = new int[n];
        int[] givenArray = new int[n];
        for(int i=0;i<n;i++)reqdArray[i] = sc.nextInt();
        for(int i=0;i<n;i++)givenArray[i] = sc.nextInt();
        long maxCookiePossible = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxCookiePossible = Math.min(maxCookiePossible,((long) givenArray[i] + k)/reqdArray[i]);
        }
        System.out.println(bs(0,(int)maxCookiePossible,reqdArray,givenArray,k));

    }

    private static int bs(int l, int r,int [] reqdArray,int[] givenArray, int k) {
        int cookies = l+(r-l)/2;
        boolean canCook = isPossible(cookies,reqdArray,givenArray,k);
        if(!canCook)
            return bs(l,cookies-1,reqdArray,givenArray,k);
        if(!isPossible(cookies+1,reqdArray,givenArray,k))
            return cookies;
        return bs(cookies+1,r,reqdArray,givenArray,k);
    }
    private static boolean isPossible(int cookies,int[] reqdArray,int[] givenArray,int special){
        for(int i=0;i<reqdArray.length;i++){
            long reqdIng = givenArray[i] - (long) cookies *reqdArray[i] ;
            if(reqdIng<0)
                special+=reqdIng;
            if(special<0)return false;
        }
        return true;
    }

}