import java.util.*;
import java.io.*;

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class lru{
    private HashMap<Integer, Node> h;
    private int k, count;
    private Node head, tail;
    
    public lru(int k){
        this.k = k;
        h = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }
    
    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public void add(Node n){
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
    }
    
    public void set(int key, int value){
        if(h.containsKey(key)){
            Node n = h.get(key);
            n.value = value;
            remove(n);
            add(n);
        }
        else{
            Node n = new Node(key, value);
            h.put(key, n);
            if(count < k){
                count++;
                add(n);
            }
            else{
                h.remove(tail.prev.key);
                remove(tail.prev);
                add(n);
            }
        }
    }
    
    public int get(int key){
        if(!h.containsKey(key))
            return Integer.MIN_VALUE;
        Node n = h.get(key);
        int x = n.value;
        remove(n);
        add(n);
        return x;
    }
    
}

public class LRUCache{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int k = Integer.parseInt(reader.readLine());
        lru l = new lru(2);
        l.set(1, 1);
        l.set(2, 2);
        System.out.println(l.get(1));
        l.set(3, 3);
        System.out.println(l.get(2));
        l.set(4, 4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        /*HashMap<Integer, Node> h = lru.h;
        for(Map.Entry<Integer, Node> x : h.entrySet()) {
            System.out.println(x.getKey()+" : "+x.getValue());
        }*/
    }
}
