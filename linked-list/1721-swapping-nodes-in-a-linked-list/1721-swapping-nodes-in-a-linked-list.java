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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> lst = new ArrayList<>();
        
        ListNode curr = head;
        while(curr != null) {
            lst.add(curr.val);
            curr = curr.next;
        }
        
        int first = lst.get(k-1);
        int second = lst.get(lst.size()-k);
        
        lst.set(k-1, second);
        lst.set(lst.size()-k, first);
        
        curr = head;
        for(int i = 0; i < lst.size(); i++) {
            head.val = lst.get(i);
            head = head.next;
        }
        
        return curr;
    }
}