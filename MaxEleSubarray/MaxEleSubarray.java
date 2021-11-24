/*
 This problem was asked by Google.

 Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

 For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

 10 = max(10, 5, 2)
 7 = max(5, 2, 7)
 8 = max(2, 7, 8)
 8 = max(7, 8, 7)
 
 Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
*/

import java.util.*;
import java.io.*;

class MaxEleSubarray{
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        String s = reader.readLine();
        String[] str = s.trim().split(" ");
        for(int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(str[i]);
        int k = Integer.parseInt(reader.readLine());
        int max = Integer.MIN_VALUE;
        Deque<Integer> p = new LinkedList<>();
        int i = 0;
        for(i = 0; i < k; ++i){
            while(!p.isEmpty() && a[i]>=a[p.peekLast()]){
                p.removeLast();
            }
            p.addLast(i);
        }
        for(; i < n; ++i){
            System.out.print(a[p.peek()] + " ");
            while(!p.isEmpty() && p.peek()<=i-k)
                p.removeFirst();
            while(!p.isEmpty() && a[i]>=a[p.peekLast()])
                p.removeLast();
            p.addLast(i);
        }
        System.out.print(a[p.peek()] + " ");
    }
}
