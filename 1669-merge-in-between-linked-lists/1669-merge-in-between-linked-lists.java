class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode itr = list1;
        ListNode aPrev = null;
        ListNode bEnd = list1;
        for(int i = 0; i < a; i++) {
            aPrev = itr;
            itr = itr.next;
        }
        for(int i = 0; i <= b; i++) {
            bEnd = bEnd.next;
        }
        ListNode bPrev = list2;
        while(bPrev.next != null) {
            bPrev = bPrev.next;
        }
        aPrev.next = list2;
        bPrev.next = bEnd;
        return list1;
    }
}