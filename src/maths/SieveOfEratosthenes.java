package maths;

import java.util.ArrayList;
import java.util.Arrays;

// problem link : https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1
// time complexity : O(nloglogn)
// space complexity : O(n)
/*
Sieve of Eratosthenes=> Find a prime number and discard their multiples.
Create a boolean array isPrime of size n+1. isPrime[i] = True if i is prime.
Initially mark whole isPrime[] to true.
Start from i = 2 and go upto i<=n, then do :
      If isPrime[i] = true, i.e. i is prime then
		Mark all multiples of i false.
		Like mark 2*i, 3*i, 4*i…until not greater than n to false .
		Optimization: instead of starting from 2*i, we can start from i*i.Why?
		Cuz we had already considered cases like 2*i(as it is considered when i=2),
		3*i, 4*i, … ,(i-1)*i. We have already discarded multiples of 2,3,….(i-1).

 */
public class SieveOfEratosthenes {
    public static ArrayList<Integer> sieveOfEratosthenes(int n){
        boolean[] isPrime = new boolean[n+1];
        ArrayList<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime,true);
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                primes.add(i);
                for(int j = i*i;j<=n;j+=i)
                    isPrime[j] = false;
            }
        }
        return primes;
    }
}
