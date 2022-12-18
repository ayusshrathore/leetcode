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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a = list1;
        ListNode b = list2;
        ListNode merged = null, first = null;
        if (a == null && b == null) return null;
        if (a == null) return b;
        else if (b == null) return a;
        else {
            merged = a.val < b.val ? a : b;
            first = merged;
            if (a.val < b.val) a = a.next;
            else b = b.next;
            while (a != null && b != null) {
                if (a.val < b.val) {
                    merged.next = a;
                    merged = a;
                    a = a.next;
                } else {
                    merged.next = b;
                    merged = b;
                    b = b.next;
                }
            }
            if (a != null) merged.next = a;
            if (b != null) merged.next = b;
        }
        return first;
    }
}