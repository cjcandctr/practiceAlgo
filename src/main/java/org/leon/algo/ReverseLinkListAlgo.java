package org.leon.algo;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}
public class ReverseLinkListAlgo {
    public ListNode ReverseLinkedList(ListNode head){
        if(head ==null || head.next == null) return head;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while(current.next != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        current.next = pre;

        return current;
    }
}
