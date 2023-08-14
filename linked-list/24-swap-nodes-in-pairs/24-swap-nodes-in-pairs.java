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
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
        
        List<Integer> lst = new ArrayList<>();
        
        ListNode curr = head;
        
        if(curr.next.next == null) {
            lst.add(curr.next.val);
            lst.add(curr.val);
            curr = curr.next;
        }
        
        while(curr.next != null) {
            lst.add(curr.next.val);
            lst.add(curr.val);
            
            if(curr.next.next != null)
                curr = curr.next.next;
            
            else curr = curr.next;
        }
        
        curr = head;
        
        for(int val : lst) {
            head.val = val;
            head = head.next;
        }
        
        return curr;
    }
}