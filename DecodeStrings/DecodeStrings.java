/*
 This problem was asked by Facebook.

 Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

 For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

 NOTE : You can assume that the messages are decodable. For example, '001' is not allowed.
*/

import java.util.*;
import java.io.*;

class DecodeStrings{
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] dp = new int[s.length()+1];
        int a = 1, b = 1, c = 0;
        for(int i = 2; i <= s.length(); ++i){
            c = 0;
            if(s.charAt(i-1)>'0')
                c = b;
            if((s.charAt(i-2) == '1') || (s.charAt(i-2)=='2'&&s.charAt(i-1)<'7'))
                c = c+a;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
