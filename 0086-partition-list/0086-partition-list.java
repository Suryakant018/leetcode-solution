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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode temp = new ListNode(0, head);
        ListNode first = temp;
        ListNode second = new ListNode(0);
        ListNode secondNode = second;
        while(first.next != null){
            if(first.next.val >= x){
                while(first.next != null && first.next.val >= x){
                    second.next = new ListNode(first.next.val);
                    second = second.next;
                    first.next = first.next.next;
                }
            }
            if(first.next != null)
                first = first.next;
        }
        first.next = secondNode.next;
        return temp.next;
    }
}