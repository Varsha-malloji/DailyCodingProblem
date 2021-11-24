/*
This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
*/

import java.util.*;
import java.io.*;

class EditDistance{
    static int solve(String s, String t, int n, int m){
        if(n == 0)
            return m;
        if(m == 0)
            return n;
        if(s.charAt(n-1) == t.charAt(m-1))
            return solve(s, t, n-1, m-1);
        int x = Math.min(solve(s, t, n-1, m), solve(s, t, n, m-1));
        int min = Math.min(x, solve(s, t, n-1, m-1));
        return 1+min;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        int n = s.length(), m = t.length();
        System.out.println(solve(s, t, n, m));
    }
}
