/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
ption
Solution
Discuss (999+)
Submissions
Back
4ms Java Solution
0
_kushagra17's avatar
_kushagra17
2
December 4, 2023 2:11 PM

1 VIEWS

Intuition
Approach
Complexity
Time complexity:
Space complexity:
Code
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a min heap to keep track of the smallest element from each list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the min heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Create a dummy node to represent the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the min heap until it's empty
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the min heap
            ListNode smallest = minHeap.poll();

            // Add the smallest node to the merged list
            current.next = smallest;
            current = current.next;

            // Move to the next node in the list and add it to the min heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next; // The merged list starts from the next of the dummy node
    }
}