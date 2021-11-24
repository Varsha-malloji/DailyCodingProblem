/*
 This problem was asked by Amazon.

 Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

 Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
*/
import java.util.*;
import java.io.*;

class EncodeString{
    public static void main (String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        s = s.toUpperCase();
        String res = "";
        int count = 1;
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(c == ch)
               count++;
            else{
                res += String.valueOf(count);
                res += String.valueOf(c);
                count = 1;
                c = ch;
            }
        }
        res += String.valueOf(count);
        res += String.valueOf(c);
        System.out.println(res);
    }
}
