/*
     This problem was asked by Stripe.

     Given an array of integers, find the first missing positive integer in linear time and constant space.
     In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

     For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

     You can modify the input array in-place.
 */

import java.util.*;
import java.io.*;

class FirstMissingNumber{
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n+1];
        String s = reader.readLine();
        String[] str = s.trim().split(" ");
        int ans = 0;
        for(int i = 0; i < n; ++i){
            int x = Integer.parseInt(str[i]);
            if(x > 0 && x < n){
                a[x] = 1;
            }
        }
        for(int i = 1; i < n; ++i){
            if(a[i] == 0){
                ans = i;
                break;
            }
        }
        if(ans == 0)
            ans = n-1;
        System.out.println(ans);
    }
}
