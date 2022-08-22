package org.leon.algo;

import org.junit.jupiter.api.Test;

class ReverseLinkListAlgoTest {
    @Test
    public void LinkedListT(){
        ListNode la = new ListNode(0,null);
        for(int i=1; i<10;i++){
            ListNode a = new ListNode(i);
            a.next = la;
            la = a;
        }

        System.out.println("original list is: ");
        ListNode head = la;
        while(la != null){
            System.out.print( la.val + ", ");
            la = la.next;
        }
        System.out.println();
        System.out.println("reversed list is: ");
        ReverseLinkListAlgo ra = new ReverseLinkListAlgo();
        ListNode reversed = ra.ReverseLinkedList(head);

        while(reversed != null){
            System.out.print(reversed.val + ", ");
            reversed = reversed.next;
        }
    }
}