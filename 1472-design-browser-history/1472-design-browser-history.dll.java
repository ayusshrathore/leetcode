class BrowserHistory {
    class ListNode {
        ListNode prev;
        ListNode next;
        String url;
        
        public ListNode(ListNode prev, ListNode next, String url) {
            this.prev = prev;
            this.next = next;
            this.url  = url;
        }
    }
    
    ListNode curr;
    
    public BrowserHistory(String homepage) {
        curr = new ListNode(null, null, homepage);
    }
    
    public void visit(String url) {
        curr.next = new ListNode(curr, null, url);
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(curr.prev != null && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        
        return curr.url;
    }
    
    public String forward(int steps) {
        while(curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }
        
        return curr.url;
    }
}
