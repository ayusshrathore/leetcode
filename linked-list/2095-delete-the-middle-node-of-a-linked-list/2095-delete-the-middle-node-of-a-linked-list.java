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
class Solution { // Two pointers, Two pass O(n) + O(n)
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }
        
        ListNode slow = head, fast = head, node = head;
            
        while(fast != null && fast.next != null) { // calculating mid of the linked list (1st pass)
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode mid = slow;
        while(node != null) { // removing the mid (2nd pass)
            if(node.next == mid) {
                node.next = mid.next;
                break;
            }
            node = node.next;
        }
        
        return head;
    }
}