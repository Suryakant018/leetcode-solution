class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrier = 0;
        ListNode result = new ListNode();
        ListNode prevDigit = null;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carrier;
            int val = sum % 10;
            carrier = sum / 10;
            if (prevDigit == null) {
                result.val = val;
                prevDigit = result;
            } else {
                prevDigit.next = new ListNode(val);
                prevDigit = prevDigit.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carrier == 1) {
            prevDigit.next = new ListNode(1);
        } 
        return result;
    }
}