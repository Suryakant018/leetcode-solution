class Solution {
    public void reorderList(ListNode head) {
       if(head==null || head.next==null)return ;

        ListNode p1=head,p2=head,p3=null;
        // 1.finding middle
        while(p2!=null && p2.next!=null){
            p2=p2.next.next;
            p3=p1;
            p1=p1.next;
        }

        // seprate first list from 2nd
        p3.next=null;
        
        // 2. reversing 2nd list
        ListNode curr=p1;
        p1=null;
        while(curr!=null){
            ListNode ne=curr.next;
            curr.next=p1;
            p1=curr;
            curr=ne;
        }

       // 3. merge both of list
        p2=head;
        while(p1!=null && p2!=null){
                ListNode temp=p2.next;
                p2.next=p1;
                p2=p2.next;
                p1=temp;
        }
        
    }
}