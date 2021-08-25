/*
 This problem was asked by Google.

 Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

*/
import java.util.*;
import java.io.*;

public class SerializeDeserialize{
    
    static int pos = 0;
    
    static Node deserialize(String s){
        if(s.charAt(pos) == '-'){
            pos++;
            return null;
        }
        String res="";
        while(s.charAt(pos) != ' '){
            res += String.valueOf(s.charAt(pos++));
        }
        pos++;
        Node root = new Node(Integer.parseInt(res));
        root.left = deserialize(s);
        root.right = deserialize(s);
        return root;
    }
    
    static String serialize(Node root){
        String res = "";
        if(root == null) {
            res += "-";
            return res;
        }
        res += root.data;
        res += " ";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }
    
    static void printTree(Node root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        printTree(root.left);
        printTree(root.right);
    }
    
    static Node insert(int[] a, int n){
        Map<Integer, Node> h = new HashMap<>();
        for(int i = 0; i < n; ++i)
            h.put(i, new Node(i));
        Node root = null;
        for(int i = 0; i < n; ++i){
            if(a[i] == -1)
                root = h.get(i);
            else{
                Node temp = h.get(a[i]);
                if(temp.left != null)
                    temp.right = h.get(i);
                else
                    temp.left = h.get(i);
            }
        }
        return root;
    }
    
    public static void main(String args[]) throws IOException{
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(reader.readLine());   // no.of nodes
         int[] a = new int[n];   // stores parent of every node i, give parent of rootnode = -1
         String s = reader.readLine();
         String str[] = s.trim().split(" ");
         for(int i = 0; i < n; ++i)
             a[i] = Integer.parseInt(str[i]);
         Node root = insert(a, n);
         String res = serialize(root);
         System.out.println(res);
         Node r = deserialize(res);
         printTree(r);
     }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
