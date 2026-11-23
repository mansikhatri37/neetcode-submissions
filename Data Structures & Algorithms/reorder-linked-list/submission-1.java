/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
        //find the middle
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        //now slow points to the last element of the first linkedlist

        ListNode prev = null;
        ListNode next = null;

        ListNode second = slow.next;
        slow.next = null; //splitting the linkedlist

        while(second != null){
            next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //prev is the head of the reversed linkedlist
        ListNode first = head;
        second = prev;

        while(second != null){

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
