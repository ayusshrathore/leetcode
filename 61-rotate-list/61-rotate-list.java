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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
        if (k > length) k = k % length;
        while (k-- > 0) {
            ListNode previous = findPrevious(head);
            ListNode last = previous.next;
            last.next = head;
            head = last;
            previous.next = null;
        }
        return head;
    }
    
    private ListNode findPrevious(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            if (current.next.next == null) previous = current;
            current = current.next;
        }
        return previous;
    }
}