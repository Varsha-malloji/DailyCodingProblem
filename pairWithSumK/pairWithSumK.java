/* This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?*/

import java.io.*;
import java.util.*;

class pairWithSumK{
    static boolean solve(int[] a, int n, int k){
        HashSet<Integer> h = new HashSet<>();
        for(int i = 0; i < n; ++i){
            if(h.contains(k-a[i]))
                return true;
            h.add(a[i]);
        }
        return false;
    }
    /*  1.Use two pointers 
        2.BinarySearch for k-a[i] */
    
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        String s = reader.readLine();
        String[] str = s.trim().split(" ");
        for(int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(str[i]);
        int k = Integer.parseInt(reader.readLine());
        writer.write(solve(a, n, k)+"");
        writer.flush();
    }
}
