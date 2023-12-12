
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
    private List<Integer> list = new ArrayList<>();
    public Solution(ListNode head) {
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
    }
    
    public int getRandom() {
        return list.get((int)Math.floor(Math.random() * list.size()));
    }
}