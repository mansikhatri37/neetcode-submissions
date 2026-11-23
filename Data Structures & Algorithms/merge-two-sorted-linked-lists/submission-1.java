
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while(head1 != null && head2 != null) {

            if(head1.val < head2.val) {
                ans.next = head1;
                head1 = head1.next;
            }
            else {
                ans.next = head2;
                head2 = head2.next;
            }

            ans = ans.next;
        }

        // Attach remaining nodes
        if(head1 != null) {
            ans.next = head1;
        }

        if(head2 != null) {
            ans.next = head2;
        }

        return dummy.next;
    }
}
