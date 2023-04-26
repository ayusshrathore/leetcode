class SmallestInfiniteSet {
    
    private PriorityQueue<Integer> pq;
    private Set<Integer> st;
    private int currSmallest = 0;
    
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        st = new HashSet<>();
        currSmallest = 1;
    }
    
    public int popSmallest() {
        int result;
        
        if(!pq.isEmpty()) {
            result = pq.remove();
            st.remove(result);
        }
        else {
            result = currSmallest;
            currSmallest++;
        }
        
        return result;
    }
    
    public void addBack(int num) {
        
        if(num >= currSmallest || st.contains(num))
            return;
        
        st.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */