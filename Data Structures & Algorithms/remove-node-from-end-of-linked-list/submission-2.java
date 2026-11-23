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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;

        // Step 1: Calculate length
        ListNode curr = head;

        while(curr != null) {
            len++;
            curr = curr.next;
        }

        // Special case: Remove the first node
        if(len == n) {
            return head.next;
        }

        // Step 2: Reach the node before the target
        ListNode temp = head;

        for(int i = 1; i < len - n; i++) {
            temp = temp.next;
        }

        // Step 3: Skip the target node
        temp.next = temp.next.next;

        return head;
    }
}
