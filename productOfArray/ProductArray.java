/*This problem was asked by Uber.
 
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6] */

import java.util.*;
import java.io.*;

class ProductArray{
    static int[] solve(int[] a, int n){
        int[] res = new int[n];
        long product = 1L;
        for(int i = 0; i < n; ++i){
            if(a[i] != 0)
                product *= a[i];
        }
        for(int i = 0; i < n; ++i){
            if(a[i] == 0)
                res[i] = 0;
            else
                res[i] = (int)product/a[i];
        }
        return res;
    }
    /*Follow-up: what if you can't use division?
         1. In res array, store product of elements of index 0 to i-1 for each i in 1 traversal, in 2nd traversal compute i+1 to n-1 index for each i.
                TC = N , SC = N
         2. TC = N, SC = 1
            log(N1*N2*N3) = log(N1)+log(N2)+log(N3)
            similarly, log(N1*N3) = log(N1+N3)       { N1+N3 = N1+N2+N3 - N2 }
                log(N1*N3) = log(N1)+log(N2)+log(N3) - log(N2)
                N1*N3 is nothing but our res[2]
     */
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        String[] str = s.trim().split(" ");
        int[] a = new int[n];
        for(int i  = 0; i < n ; ++i)
            a[i] = Integer.parseInt(str[i]);
        int[] res = solve(a, n);
        for(int i  = 0; i < n; ++i){
            writer.write(res[i]+" ");
        }
        writer.write("\n");
        writer.flush();
    }
}
