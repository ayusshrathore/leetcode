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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int n = 0;
        /* Divide the linked list into 2 halves */
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            n++;
        }
        
        /* Reverse the second half */
        ListNode curr = slow;
        ListNode prev = null;
        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode second = prev;
        ListNode first = head;
        
        /* The second pointer will point to first node of the reversed half, which is the (n-1-i)th node in the original linked list. 
        By moving both pointers forward at the same time, we find all twin sums & finally return the max of them */
        int res = 0;
        while(first != null && second != null) {
            res = Math.max(res, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        
        return res;
    }
}