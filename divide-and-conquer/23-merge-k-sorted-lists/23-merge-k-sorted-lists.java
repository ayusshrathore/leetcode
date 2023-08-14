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
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            ListNode curr = list;
            while (curr != null) {
                pq.add(curr.val);
                curr = curr.next;
            }
        }
        while(!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll());
            dummy.next = node;
            dummy = node;
        }
        return head.next;
    }
}