package org.leon.algo;


import java.util.HashMap;
import java.util.Map;
class LinkedListNode{
    LinkedListNode pre;
    LinkedListNode next;
    int val;
    int key;

    public LinkedListNode(int key, int val) {
        this.val = val;
        this.key = key;
    }

}
public class LRUCache {
    private int capacity;
    private LinkedListNode head;
    private LinkedListNode tail;
    private Map<Integer, LinkedListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedListNode(-1, -1);
        tail = new LinkedListNode(-1, -1);
        head.next=tail;
        tail.pre = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            LinkedListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            LinkedListNode node = map.get(key);
            node.val = val;
            moveToHead(node);
        }else{

            if(this.map.size() >= this.capacity){
                LinkedListNode last = tail.pre;
                LinkedListNode pre = last.pre;
                pre.next = tail;
                tail.pre = pre;
                last.pre = null;
                last.next = null;
                map.remove(last.key);
            }
            LinkedListNode  node = new LinkedListNode(key, val);
            this.map.put(key,node);
            addToHead(node);
        }
    }

    private void moveToHead(LinkedListNode node) {
        LinkedListNode pre = node.pre;
        LinkedListNode next = node.next;
        pre.next = next;
        next.pre = pre;

        addToHead(node);
    }

    private void addToHead(LinkedListNode node) {
        LinkedListNode sec = head.next;
        node.pre =head;
        node.next = sec;
        head.next=node;
        sec.pre=node;
    }
}
