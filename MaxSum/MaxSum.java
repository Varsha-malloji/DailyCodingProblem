/*
 This problem was asked by Airbnb.

 Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

 For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

 Follow-up: Can you do this in O(N) time and constant space?
*/

import java.util.*;
import java.io.*;

class MaxSum{
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        String s = reader.readLine();
        String[] str = s.trim().split(" ");
        for(int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(str[i]);
        int sum1 = a[0], sum2 = 0, max = 0;
        for(int i = 1; i < n; ++i){
            max = Math.max(sum1, sum2);
            sum1 = sum2+a[i];
            sum2 = max;
        }
        max = Math.max(sum1, sum2);
        System.out.println(max);
    }
}
