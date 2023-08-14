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
        if (head.next == null) return null;
        ListNode current = head;
        ListNode runner = head;
        ListNode previous = head;
        for (int i = 0; i < n; i++) 
            runner = runner.next;
        while (runner != null) {
            previous = current;
            current = current.next;
            runner = runner.next;
        }
        if (current != null) previous.next = current.next;
        return current == head ? previous.next : head;
    }
}