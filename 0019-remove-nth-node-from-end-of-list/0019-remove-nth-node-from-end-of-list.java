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
        int cnt = 0;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        temp = dummy;
        int rem = cnt - n;
        for (int i = 0; i < rem; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
