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
    public ListNode removeElements(ListNode head, int val) {
        ListNode result=new ListNode();
         ListNode temp=result;
        while(head!=null)
        {

            if(head.val!=val)
            {
              ListNode ans=new ListNode(head.val);   
               temp.next=ans;
              temp=temp.next;

            }
            
            head=head.next;
        }
        return result.next;
    }
}