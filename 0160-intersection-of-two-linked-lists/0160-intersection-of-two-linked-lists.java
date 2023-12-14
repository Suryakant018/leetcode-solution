/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int len1 = 1;
        ListNode temp1 = headA;
        while(temp1.next!=null){
            temp1 = temp1.next;
            len1++;
        }
        int len2 = 1;
        ListNode temp2 = headB;
        while(temp2.next!=null){
            temp2 = temp2.next;
            len2++;
        }
        ListNode curr1 = headA , curr2 = headB;
        if(len1>len2){
            int skip = len1 - len2;
            curr1 = headA;
            for(int i=1;i<=skip;i++){
                curr1 = curr1.next;
            }
        }else{
            int skip = len2 - len1;
            curr2 = headB;
            for(int i=1;i<=skip;i++){
                curr2 = curr2.next;
            }
        }
        while(curr1!=null && curr2!=null){
            if(curr1 == curr2){
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }
}