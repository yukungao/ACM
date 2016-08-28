/* http://www.lintcode.com/en/problem/lru-cache/ */
/*
Key Element : HashLinkedList, to access the


*/
public class Solution {

    // Should share through whole class
    private int capacity;

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        // Constructor
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private HashMap<Integer,Node> cache;
    Node head;
    Node tail;


    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        // Should bind the key to the Node
        cache = new HashMap<Integer,Node>();
        // Dummy head
        head = new Node(-1,-1);
        // Dummy tail
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(cache.containsKey(key)) {
            // If exist current, we should move it to the tail
            Node curr = cache.get(key);
            Node currPrev = curr.prev;
            Node currNext = curr.next;
            currPrev.next = currNext;
            currNext.prev = currPrev;

            moveToTail(curr);

            return curr.value;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing

    // Since the key is uniqe, we should make this as a key
    public void set(int key, int value) {
        // write your code here
        if(get(key) != -1) {
            // Simply update the value for current key
            cache.get(key).value = value;
            return;
        }
        // If current list already reach the cap;
        if(cache.size() == capacity) {
            // Remove the head of list, delete it in the cache;
            cache.remove(head.next.key);
            Node delete = head.next;
            head.next = head.next.next;
            head.next.prev = head;

            delete.prev = null;
            delete.next = null;
            delete = null;
        }
            // New the Node, put it in the tail of the list
        Node curr = new Node(key, value);
        moveToTail(curr);
        cache.put(key,curr);
    }

    // Move it to the tail
    private void moveToTail(Node curr) {
        curr.next = tail;
        curr.prev = tail.prev;
        tail.prev = curr;
        curr.prev.next = curr;
    }

}
