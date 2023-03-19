// 2 Stack Solution
class BrowserHistory {
    Stack<String> past;
    Stack<String> future;
    String curr;
    
    public BrowserHistory(String homepage) { // youtube
        past = new Stack<>();
        future = new Stack<>();
        curr = homepage;
    }
    
    public void visit(String url) { // curr -> leetcode, past-> youtube
        past.push(curr);
        curr = url;
        
        future = new Stack<>(); // as new page is visited, clear all forward pages
    }
    
    public String back(int steps) {
        while(!past.isEmpty() && steps > 0) {
            future.push(curr);
            curr = past.pop();
            steps--;
        }
        
        return curr;
    }
    
    public String forward(int steps) {
        while(!future.isEmpty() && steps > 0) {
            past.push(curr);
            curr = future.pop();
            steps--;
        }
        
        return curr;
    }
}
